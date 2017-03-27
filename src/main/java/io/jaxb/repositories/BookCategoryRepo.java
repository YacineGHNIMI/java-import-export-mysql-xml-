package io.jaxb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jaxb.entities.BookCategory;

/**
 * @author YACINE
 *
 */
@Repository
public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer> {

	public List<BookCategory> findAll();

}
