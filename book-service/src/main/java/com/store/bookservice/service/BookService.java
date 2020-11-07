package com.store.bookservice.service;

import com.store.bookservice.contant.BookConstant;
import com.store.bookservice.model.Book;
import com.store.bookservice.param.SearchBookParam;
import com.store.bookservice.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(List<Book> book) {
        bookRepository.saveAll(book);
    }

    @Cacheable(value="twenty-second-cache", key = BookConstant.BOOK_KEY)
    public List<Book> getBooks(SearchBookParam param) {
        logger.info("Fetching records for request \n"+param.toString());
        return bookRepository.findBooksByIsbnOrTitleOrSubtitleOrAuthorOrPublishedOrUpdatedOrPublisherOrPagesOrDescriptionOrWebsite(
                param.getIsbn(),
                param.getTitle(),
                param.getSubtitle(),
                param.getAuthor(),
                param.getPublished(),
                param.getUpdated(),
                param.getPublisher(),
                param.getPages(),
                param.getDescription(),
                param.getWebsite());
    }
}
