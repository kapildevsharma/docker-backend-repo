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
        return authorRepo.findById(id);
	}
	
	public List<Author> findAll(){
		logger.info("****author is Cacheable");
        return authorRepo.findAll();
	}
	
	public Author findByAuthName(String name) {
        return authorRepo.findByAuthName(name);
	}
	
	public Author save(Author author) {
        return authorRepo.save(author);
	}
}
