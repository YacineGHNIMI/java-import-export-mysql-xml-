package io.jaxb.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;

/**
 * @author YACINE
 *
 */
@Entity
public class Theme {

	private int id;

	private String name;

	private List<BookCategory> bookCategories;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theme", cascade = CascadeType.ALL)
	public List<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}
}
