package io.jaxb;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import io.jaxb.configuration.BusinessJAXB;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author YACINE
 *
 */

@ComponentScan("io.jaxb")
public class JaxbApplication {

	final static Logger logger = Logger.getLogger("JaxbApplication");

	public static void main(String[] args) throws Exception {

		System.out.println("\nMenu Options\n");
		System.out.println("(1) - Export from database --- (Database to XML)");
		System.out.println("(2) - Import to   database --- (XML to Database)");

		System.out.print("Please enter your selection:\t");

		Scanner scanner = new Scanner(System.in);

		int selection = scanner.nextInt();

		ApplicationContext appContextJAXB = new AnnotationConfigApplicationContext(BusinessJAXB.class);
		BusinessJAXB businessJAXB = appContextJAXB.getBean(BusinessJAXB.class);

		if (selection == 1) {
            //java to xml
			businessJAXB.marshalling();
		}

		if (selection == 2) {
			//xml to java
			businessJAXB.unmarshalling();
		}

	}
}
