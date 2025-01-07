package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nagarro.dao.AuthorRepo;
import com.nagarro.entities.Author;
import com.nagarro.util.CacheNames;

@Service
public class AuthorService {

	org.slf4j.Logger logger  = LoggerFactory.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepo authorRepo;

	public Optional<Author> findById(int id){
		Optional<Author> opt_author = authorRepo.findById(id);
		return opt_author;
	}
	
	public List<Author> findAll(){
		logger.info("****author is Cacheable");
		List<Author> authors = authorRepo.findAll();
		return authors;
	}
	
	public Author findByAuthName(String name) {
		Author author = authorRepo.findByAuthName(name);
		return author;
	}
	
	public Author save(Author author) {
		Author savedAuthor = authorRepo.save(author);
		return savedAuthor;
	}
}
