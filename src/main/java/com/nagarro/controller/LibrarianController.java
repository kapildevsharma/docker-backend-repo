package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entities.Librarian;
import com.nagarro.service.LibrarianService;

@RestController
public class LibrarianController {
	@Autowired
	private LibrarianService librarianService;

	@GetMapping("/lib/{id1}/{id2}")
	public Librarian getLibrarian(@PathVariable("id1") String name,@PathVariable("id2") String password) {
		Librarian librarian = librarianService.findByNameAndPassword(name,password);
		return librarian;
	}
}
