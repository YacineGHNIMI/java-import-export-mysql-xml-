package io.jaxb.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;

/**
 * @author YACINE
 *
 */

@Entity
@Table(name = "book_category")
public class BookCategory {

	private int id;

	private String name;

	private List<Book> books;

	private Theme theme;

	@ManyToOne
	@JoinColumn(name = "theme_id")
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public BookCategory() {

	}

	public BookCategory(String name) {
		this.name = name;
	}

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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookCategory", cascade = CascadeType.ALL)
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		String result = String.format("Category[id=%d, name='%s']%n", id, name);
		if (books != null) {
			for (Book book : books) {
				result += String.format("Book[id=%d, name='%s']%n", book.getId(), book.getName());
			}
		}

		return result;
	}
}