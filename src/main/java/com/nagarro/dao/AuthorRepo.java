package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entities.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{
	public Author findByAuthName(String name);
}
