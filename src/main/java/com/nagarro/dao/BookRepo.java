package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
