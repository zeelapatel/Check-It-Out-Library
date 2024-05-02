package edu.neu.csye6200.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.Factory.BooksServiceFactory;
import edu.neu.csye6200.entity.AssignBooks;
import edu.neu.csye6200.entity.Book;
import edu.neu.csye6200.services.BooksService;

@RestController
@CrossOrigin
@RequestMapping("/Books")
public class BookController {
	private final BooksService booksService;

	public BookController(BooksService booksService) {
		this.booksService = booksService;
	}

	@PostMapping("/assignBook")
	public Object assignBook(@RequestBody AssignBooks book) {
		return BooksServiceFactory.getInstance(booksService).assignBook(book);
	}

	@PostMapping("/addBook")
	public void addBook(@RequestBody Book book) {
		booksService.addBook(book);
	}

	@GetMapping("/sortByName")
	public List<Book> sortBookByName() {
		// Assuming that booksService is an instance variable in your controller
		List<Book> allBooks = BooksServiceFactory.getInstance(booksService).findAllBook();

		// Sort books by name using Comparator
		List<Book> sortedBooks = allBooks.stream().sorted(Comparator.comparing(Book::getBookName))
				.collect(Collectors.toList());

		return sortedBooks;
	}

	@GetMapping("/sortByQuantity")
	public List<Book> sortBookByQuantity() {
		// Assuming that booksService is an instance variable in your controller
		List<Book> allBooks = BooksServiceFactory.getInstance(booksService).findAllBook();

		// Sort books by name using Comparator
		List<Book> sortedBooks = allBooks.stream().sorted(Comparator.comparing(Book::getQuantity))
				.collect(Collectors.toList());

		return sortedBooks;
	}

	@GetMapping("/findAllBok")
	public List<Book> getAllBook() {
		return BooksServiceFactory.getInstance(booksService).findAllBook();

	}
}
