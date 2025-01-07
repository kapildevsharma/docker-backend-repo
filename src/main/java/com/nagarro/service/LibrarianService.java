package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.LibrarianRepo;
import com.nagarro.entities.Librarian;

@Service
public class LibrarianService {
	@Autowired
	private LibrarianRepo librarianRepo;

	public Librarian findByNameAndPassword(String name, String password) {
		Librarian librarian = librarianRepo.findByNameAndPassword(name, password);
		return librarian;
	}
}
