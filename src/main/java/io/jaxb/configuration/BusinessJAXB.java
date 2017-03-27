package io.jaxb.configuration;

import java.io.File;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.ui.context.Theme;

import io.jaxb.entities.Book;
import io.jaxb.entities.BookCategory;
import io.jaxb.entities.Theme;
import io.jaxb.services.BookCategoryService;
import io.jaxb.services.BookService;
import io.jaxb.services.ThemeService;

/**
 * @author YACINE
 *
 */

@Configuration
@EnableBatchProcessing
@EnableJpaRepositories("io.spring.repositories")
@ImportResource("classpath:/config/config-beans.xml")
public class BusinessJAXB {

	@Autowired
	public BookService bookService;

	@Autowired
	public BookCategoryService bookCategoryService;

	@Autowired
	public ThemeService themeService;
	
	
	

	// Converting java to Xml
	public void marshalling() {
		
		
		long startTime = System.currentTimeMillis();
		
		 //get from database
		List<Book> listBook = bookService.findAll();
		List<BookCategory> listBookCategory = bookCategoryService.findAll();
		List<Theme> listTheme = themeService.findAll();

		try {
			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(ModelFileJaxb.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// for getting nice formatted output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// specify the location and name of xml file to be created
			File XMLfile = new File("./src/main/resources/data/exported_data_jaxb.xml");

			ModelFileJaxb modelFile = new ModelFileJaxb();
			modelFile.setListBookCategory(listBookCategory);
			modelFile.setListBook(listBook);

			modelFile.setListTheme(listTheme);
			
			// Writing to XML file
			jaxbMarshaller.marshal(modelFile, XMLfile);
			
			long endTime = System.currentTimeMillis();
			double seconds = (endTime - startTime) / 1000.0;
			
			// Writing Export duration to console
			System.out.println("Export duration : " + seconds + " seconds");


		} catch (JAXBException e) {
			// some exception occured
			e.printStackTrace();
		}
		
		

	}
	
	
	
	

	// Converting XML to java
	public void unmarshalling() {
		

		try {

			long startTime = System.currentTimeMillis();
            
			// specify the location and name of xml file to be imported
			File file = new File("./src/main/resources/data/data_to_import_jaxb.xml");
			
			// create JAXB context and initializing Unmarshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(ModelFileJaxb.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			ModelFileJaxb result = (ModelFileJaxb) jaxbUnmarshaller.unmarshal(file);

			List<Book> listBooks = result.getListBook();
			List<BookCategory> listBookCategory = result.getListBookCategory();
			List<Theme> listTheme = result.getListTheme();
			
            //save on database
			themeService.save(listTheme);
			bookCategoryService.save(listBookCategory);
			bookService.save(listBooks);

			long endTime = System.currentTimeMillis();
			double seconds = (endTime - startTime) / 1000.0;
			
			//Writing Export duration to console
			System.out.println("Import duration : " + seconds + " seconds");

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		

	}
	
	
	
	

}
