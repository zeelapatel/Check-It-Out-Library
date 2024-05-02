package edu.neu.csye6200.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.entity.Book;
@Service
public interface BookRepo extends JpaRepository<Book, Long>{

}
