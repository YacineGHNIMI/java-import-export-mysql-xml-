package io.jaxb.services;

import java.util.List;

import io.jaxb.entities.BookCategory;

/**
 * @author YACINE
 *
 */

public interface BookCategoryService {

	public List<BookCategory> findAll();

	public void save(BookCategory book);

	public void save(List<BookCategory> book);

}
