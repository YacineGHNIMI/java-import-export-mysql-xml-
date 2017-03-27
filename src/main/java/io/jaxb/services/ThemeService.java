package io.jaxb.services;

import java.util.List;

import io.jaxb.entities.Theme;

/**
 * @author YACINE
 *
 */
public interface ThemeService {

	public List<Theme> findAll();

	public void save(Theme theme);

	public void save(List<Theme> theme);

}
