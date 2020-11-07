package com.store.bookservice.controller;

import com.store.bookservice.model.Book;
import com.store.bookservice.param.SearchBookParam;
import com.store.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/search")
    public List<Book> findBook(@RequestBody SearchBookParam param){
        return bookService.getBooks(param);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveBook(@RequestBody List<Book> book){
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
