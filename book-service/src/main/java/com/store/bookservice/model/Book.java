package com.store.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="javatechie",type="book",shards=2)
public class Book implements Serializable {
    @Id
    private Long isbn;
    private String title;
    private String subtitle;
    private String author;
    private String published;
    private String publisher;
    private String updated;
    private Integer pages;
    private String description;
    private String website;
}
