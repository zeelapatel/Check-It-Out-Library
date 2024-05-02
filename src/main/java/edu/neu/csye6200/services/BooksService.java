package edu.neu.csye6200.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.entity.AssignBooks;
import edu.neu.csye6200.entity.Book;
import edu.neu.csye6200.entity.Student;
import edu.neu.csye6200.repo.AssignBooksRepo;
import edu.neu.csye6200.repo.BookRepo;
import edu.neu.csye6200.repo.StudentRepo;

@Service
public class BooksService {

	@Autowired
	private AssignBooksRepo assignBooksRepo;

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private StudentRepo studentRepo;

	public Object assignBook(AssignBooks book) {
		Optional<Book> bookWithId = bookRepo.findById(book.getBookId());
		Optional<Student> databaseStudent = studentRepo.findById(book.getStudentId());

		if (databaseStudent.isPresent()) {
			Student existingStudent = databaseStudent.get();

			// Check if the student information matches
			if (existingStudent.getFirstName().equalsIgnoreCase(book.getFirstName())
					&& existingStudent.getLastName().equalsIgnoreCase(book.getLastName())
					&& existingStudent.getStudid().equals(book.getStudentId())) {

				if (bookWithId.isPresent() && bookWithId.get().getQuantity() != 0) {
					Book existingBook = bookWithId.get();

					// Check if the book ID matches
					if (existingBook.getId().equals(book.getBookId())) {
						// Reduce the quantity of the book

						existingBook.setQuantity(existingBook.getQuantity() - 1);
						bookRepo.save(existingBook);

						// Save the book assignment
						return assignBooksRepo.save(book);
					} else {
						// Invalid BookID
						String response = "Invalid BookID";
						return response;
					}
				} else {
					// Book not found
					String response = "Book not found";
					return response;
				}
			} else {
				// Invalid Student Information
				String response = "Invalid Student Information";
				return response;
			}
		}

		// Invalid Student Details
		String response2 = "Invalid Student Details";
		return response2;
	}

	public List<AssignBooks> getBooksByStudentId(Long studentId) {
		return assignBooksRepo.findByStudentId(studentId);
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub

		bookRepo.save(book);

	}

	public List<Book> findAllBook() {
		List<Book> allBook = bookRepo.findAll();

		return allBook;

	}
}
