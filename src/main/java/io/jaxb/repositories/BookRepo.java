package io.jaxb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jaxb.entities.Book;

/**
 * @author YACINE
 *
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	
}
