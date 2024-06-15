package com.library.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String nameOfUser;
    String bookName;
    String author;
    LocalDate dateOfIssue;
    LocalDate returnDate;


    public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	// Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameOfUser() {
        return nameOfUser;
    }
    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }
    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    // Constructors
    
    public Users() {}
	public Users(Long id, String nameOfUser, String bookName, String author, LocalDate dateOfIssue,
			LocalDate returnDate) {
		super();
		this.id = id;
		this.nameOfUser = nameOfUser;
		this.bookName = bookName;
		this.author = author;
		this.dateOfIssue = dateOfIssue;
		this.returnDate = returnDate;
	}
}
