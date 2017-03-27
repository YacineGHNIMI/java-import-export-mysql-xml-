package io.jaxb.entities;

import javax.persistence.*;

/**
 * @author YACINE
 *
 */

@Entity
public class Book {

	private int id;
	private String name;
	private BookCategory bookCategory;

	public Book() {

	}

	public Book(String name) {
		this.name = name;
	}

	public Book(String name, BookCategory bookCategory) {
		this.name = name;
		this.bookCategory = bookCategory;
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

	@ManyToOne
	@JoinColumn(name = "book_category_id")
	public BookCategory getBookCategory() {
		return bookCategory;
	}

	// @XmlElement
	// public int getBookCategoryId() {
	// return bookCategory.getId();
	// }

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", name='" + name + '\'' + ", bookCategory=" + bookCategory + '}';
	}
}
