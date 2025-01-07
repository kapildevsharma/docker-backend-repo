package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nagarro.dao.BookRepo;
import com.nagarro.entities.Book;
import com.nagarro.util.CacheNames;

@Service
public class BookService {
	
	org.slf4j.Logger logger  = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findAll(){
        logger.info("Fetching all books from the database (Cacheable).");
		List<Book> books = bookRepo.findAll();
		return books;
	}
	
    @Cacheable(cacheNames = CacheNames.BOOKS, key = "#id")
	public Optional<Book> findById(int id){
        logger.info("Fetching book with ID {} from the database (Cacheable).", id);
		Optional<Book> op_book = bookRepo.findById(id);
		return op_book;
	}
	
    @CachePut(cacheNames = CacheNames.BOOKS, key = "#book.bookId")
	public Book save(Book book) {
    	if (book == null || book.getBookId() ==0 || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book and author cannot be null.");
        }
        logger.info("Saving book with ID {} to the database (CachePut).", book.toString());
        Book savedBook = bookRepo.save(book);
        refreshCache(); // Refresh the cache after saving
        return savedBook;
	}
	
    @CacheEvict(cacheNames = CacheNames.BOOKS, allEntries = true)
	public void delete(Book book) {
    	if (book == null || book.getBookId() == 0) {
            throw new IllegalArgumentException("Book or bookId cannot be null");
        }
		logger.info("****remove books is Cacheable");
		bookRepo.delete(book);
		refreshCache(); // Refresh the cache after deletion
	}
    
    @CacheEvict(cacheNames = CacheNames.BOOKS, allEntries = true)
    public void clearCache() {
        logger.info("Clearing all entries in the BOOKS cache.");
    }
    
    public void refreshCache() {
        logger.info("Refreshing the BOOKS cache with updated data.");
        clearCache();
        findAll(); // Repopulate the cache
    }
    
}
