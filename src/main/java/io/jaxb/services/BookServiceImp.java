package io.jaxb.services;

import io.jaxb.entities.Book;
import io.jaxb.repositories.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YACINE
 *
 */
@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookRepo bookRepo;

	@Override
	public List<Book> findAll() {

		return bookRepo.findAll();

	}

	@Override
	public void save(Book book) {
		bookRepo.save(book);
	}

	@Override
	public void save(List<Book> books) {
		bookRepo.save(books);
	}
}
