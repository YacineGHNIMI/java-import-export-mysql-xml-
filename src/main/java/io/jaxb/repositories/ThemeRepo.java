package io.jaxb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jaxb.entities.Theme;

/**
 * @author YACINE
 *
 */
@Repository
public interface ThemeRepo extends JpaRepository<Theme, Integer> {

}
