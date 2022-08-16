package com.rrun.book.repository;

import com.rrun.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findByTitle(String bookName);

}
