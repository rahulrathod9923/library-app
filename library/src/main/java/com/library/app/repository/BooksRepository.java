package com.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.app.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{

}
