package io.jaxb.services;

import io.jaxb.entities.Theme;
import io.jaxb.repositories.ThemeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YACINE
 *
 */
@Service
public class ThemeServiceImp implements ThemeService {

	@Autowired
	private ThemeRepo themeRepo;

	@Override
	public List<Theme> findAll() {
		return themeRepo.findAll();
	}

	@Override
	public void save(Theme theme) {

		themeRepo.save(theme);

	}

	@Override
	public void save(List<Theme> themes) {

		themeRepo.save(themes);

	}
}
