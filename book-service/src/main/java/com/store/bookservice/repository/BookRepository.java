package com.store.bookservice.repository;

import com.store.bookservice.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Long> {

    List<Book> findBooksByIsbnOrTitleOrSubtitleOrAuthorOrPublishedOrUpdatedOrPublisherOrPagesOrDescriptionOrWebsite(
            Long isbn,
            String title,
            String subtitle,
            String author,
            LocalDateTime published,
            LocalDateTime updated,
            String publisher,
            Integer pages,
            String description,
            String website);
}
