package io.jaxb.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import io.jaxb.entities.Book;
import io.jaxb.entities.BookCategory;
import io.jaxb.entities.Theme;

/**
 * @author YACINE
 *
 */


//Xml file model
@XmlRootElement(name = "jpa_manytoone")
public class ModelFileJaxb {
     
	//List of books
	private List<Book> listBook = new ArrayList<Book>();
	//List of book categories
	private List<BookCategory> listBookCategory = new ArrayList<BookCategory>();
	//List of book Themes
	private List<Theme> listTheme = new ArrayList<Theme>();

	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	@XmlElementWrapper(name = "bookCategories")
	@XmlElement(name = "bookCategory")
	public List<BookCategory> getListBookCategory() {
		return listBookCategory;
	}

	public void setListBookCategory(List<BookCategory> listBookCategory) {
		this.listBookCategory = listBookCategory;
	}

	@XmlElementWrapper(name = "themes")
	@XmlElement(name = "theme")
	public List<Theme> getListTheme() {
		return listTheme;
	}

	public void setListTheme(List<Theme> listTheme) {
		this.listTheme = listTheme;
	}

}
