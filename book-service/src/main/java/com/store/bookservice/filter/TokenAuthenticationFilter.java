package com.store.bookservice.filter;

import com.store.bookservice.security.model.AuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final String TOKEN_HEADER = "Authorization";
	private static final String TOKEN_PREFIX = "Netcore ";

	public TokenAuthenticationFilter() {
		super("/books/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		AuthenticationToken token = validateHeader(request.getHeader(TOKEN_HEADER));
		if (ObjectUtils.isEmpty(token)) {
			throw new ServletException("401 - UNAUTHORIZED");
		}
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	private AuthenticationToken validateHeader(String authenticationHeader) {
		if (StringUtils.isBlank(authenticationHeader) || !authenticationHeader.startsWith(TOKEN_PREFIX)) {
			return null;
		}
		return new AuthenticationToken(authenticationHeader.replace(TOKEN_PREFIX, ""));
	}

}
