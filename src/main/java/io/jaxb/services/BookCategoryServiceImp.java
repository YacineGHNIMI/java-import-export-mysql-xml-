package io.jaxb.services;

import io.jaxb.entities.BookCategory;
import io.jaxb.repositories.BookCategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YACINE
 *
 */
@Service
public class BookCategoryServiceImp implements BookCategoryService {

	@Autowired
	BookCategoryRepo bookCategoryRepo;

	@Override
	public List<BookCategory> findAll() {
		return bookCategoryRepo.findAll();
	}

	@Override
	public void save(BookCategory book) {

		bookCategoryRepo.save(book);

	}

	@Override
	public void save(List<BookCategory> books) {

		bookCategoryRepo.save(books);

	}
}
