package io.jaxb.services;

import java.util.List;

import io.jaxb.entities.Book;

/**
 * @author YACINE
 *
 */

public interface BookService {

	public List<Book> findAll();

	public void save(Book book);

	public void save(List<Book> book);

}
