package com.library.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.app.entity.Books;
import com.library.app.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
    @Autowired
    private BooksService booksService;

    @PostMapping("/create")
    public Books createBook(@RequestBody Books books) {
        return booksService.createBook(books);
    }

    @GetMapping("/fetch/{id}")
    public Optional<Books> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }

    @GetMapping("/fetchAll")
    public List<Books> getAllBook() {
        return booksService.getAllBooks();
    }

    @PutMapping("/update/{id}")
    public Books updateBookById(@RequestBody Books books, @PathVariable Long id) {
        return booksService.updateBookById(books, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return booksService.deleteById(id);
    }
}
