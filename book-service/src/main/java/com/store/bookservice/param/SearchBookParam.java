package com.store.bookservice.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookParam {
    private Long isbn;
    private String title;
    private String subtitle;
    private String author;
    private LocalDateTime published;
    private String publisher;
    private LocalDateTime updated;
    private Integer pages;
    private String description;
    private String website;
}
