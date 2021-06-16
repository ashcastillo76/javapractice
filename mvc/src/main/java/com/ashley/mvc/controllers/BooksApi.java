package com.ashley.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashley.mvc.models.Book;
import com.ashley.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
//	returns all books
	  @RequestMapping("/api/books")
	    public List<Book> index() {
	        return bookService.allBooks();
	    }
	    
//	  post method
	    @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        return bookService.createBook(book);
	    }
	    
//	    returns a specific book by id
	    @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = bookService.findBook(id);
	        return book;
	    }
	    
//	    a put method for a book to update a book
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
	    
//	    deletes a book from the database
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	    }

}
