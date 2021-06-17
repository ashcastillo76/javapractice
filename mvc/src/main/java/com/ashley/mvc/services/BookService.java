package com.ashley.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.mvc.models.Book;
import com.ashley.mvc.repositories.BookRepo;

@Service
public class BookService {
	 // adding the book repository as a dependency. calls all the methods in the repository
    private final BookRepo bookRepo;
    
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
//    	in optional checks if present
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
//        	if present, returns the book
            return optionalBook.get();
        } else {
            return null;
        }
    }
//    updates a book
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            return bookRepo.save(book);
        } else {
            return null;
        }
    }
    
//    deletes a book
    public Book deleteBook(Long id) {
         bookRepo.deleteById(id);
         return null;
    
    }
}

