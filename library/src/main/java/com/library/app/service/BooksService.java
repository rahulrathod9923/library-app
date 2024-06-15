package com.library.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.entity.Books;
import com.library.app.repository.BooksRepository;


@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;

	public Books createBook(Books book) {
		return booksRepository.save(book);
	}

	public Optional<Books> getBookById(Long id) {
		return booksRepository.findById(id);
	}

	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}

	public Books updateBookById(Books books, Long id) {
		Books existingBook = booksRepository.findById(id).get();
		existingBook.setAuthor(books.getAuthor());
		existingBook.setBookName(books.getBookName());
		
		return booksRepository.save(existingBook);
	}

	public String deleteById(Long id) {
		booksRepository.deleteById(id);
		return "Record deleted successfully";
	}
}
