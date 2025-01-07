package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entities.Author;
import com.nagarro.entities.Book;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;

@RestController
public class Book_AuthorController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private BookService bookService;

	@PostMapping("/author")
	public Author saveAuthor(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}

	@GetMapping("/author/{id}")
	public Author getAuthor(@PathVariable("id") int id) {
		Optional<Author> opt_author = authorService.findById(id);
		Author author = opt_author.get();
		return author;
	}

	@GetMapping("/authors")
	public List<Author> getAllAuthor() {
		List<Author> authors = authorService.findAll();
		return authors;
	}

	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book) {
		Author newAuth = authorService.findByAuthName(book.getTemp_authName());
		book.setAuthor(newAuth);
		bookService.save(book);
		return book;
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		List<Book> books = bookService.findAll();
		return books;
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		Optional<Book> op_book = bookService.findById(id);
		Book book = op_book.get();
		return book;
	}

	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable int id) {
		Optional<Book> op_book = bookService.findById(id);
		Book prev_book = op_book.get();
		prev_book.setBookName(book.getBookName());
		prev_book.setAddedOn(book.getAddedOn());
		prev_book.setAuthor(authorService.findByAuthName(book.getTemp_authName()));
		bookService.save(prev_book);
		return prev_book;
	}

	@DeleteMapping("/delete/{id}")
	public Book delete(@PathVariable int id) {
		Optional<Book> del_book = bookService.findById(id);
		Book book = del_book.get();
		bookService.delete(book);
		return book;
	}
}
