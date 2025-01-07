package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entities.Librarian;

public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {
	public Librarian findByNameAndPassword(String name,String password);
}
