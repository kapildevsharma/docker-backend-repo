package com.nagarro.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Book  implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	private int bookId;
	private String bookName;
	private String addedOn;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "author")
	private Author author;
	@Transient
	private String temp_authName;

	public Book(int bookId, String bookName, String addedOn, Author author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.addedOn = addedOn;
		this.author = author;
	}

	public Book() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTemp_authName() {
		return temp_authName;
	}

	public void setTemp_authName(String temp_authName) {
		this.temp_authName = temp_authName;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", addedOn=" + addedOn + "]";
	}

}
