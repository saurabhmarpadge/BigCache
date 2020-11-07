package com.store.bookservice.controller;

import com.store.bookservice.security.model.AuthenticationToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/token")
public class TokenController {

	private static final long EXPIRATION_SECONDS = 60;
	private static final String SECURITY_KEY = "!@sdfIJ29JId";

	@PostMapping
	public AuthenticationToken generate(@RequestHeader("clientTxt") String clientTxt,
										@RequestHeader("clientId") String clientId) {
		return new AuthenticationToken(Jwts.builder().setSubject(clientTxt).claim("role", "USER")
				.claim("Id", clientId).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_SECONDS * 1000))
				.signWith(SignatureAlgorithm.HS256, SECURITY_KEY).compact());
	}
}