package edu.neu.csye6200.Factory;

import edu.neu.csye6200.entity.AssignBooks;
import edu.neu.csye6200.entity.Book;
import edu.neu.csye6200.services.BooksService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksServiceFactory {

	@Autowired
	private final BooksService bookService;

	private static BooksServiceFactory instance;

	public BooksServiceFactory(BooksService bookService) {
		super();
		this.bookService = bookService;
	}

	public static BooksServiceFactory getInstance(BooksService bs) {
		if (instance == null) {
			instance = new BooksServiceFactory(bs);
		}
		return instance;
	}

	public List<AssignBooks> getBook(Long studentid) {
		return bookService.getBooksByStudentId(studentid);
	}

	public Object assignBook(AssignBooks book) {
		return bookService.assignBook(book);
	}

	public List<Book> findAllBook() {
		return bookService.findAllBook();

	}

}