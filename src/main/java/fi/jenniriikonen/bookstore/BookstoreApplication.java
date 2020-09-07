package fi.jenniriikonen.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.jenniriikonen.bookstore.domain.Book;
import fi.jenniriikonen.bookstore.domain.BookRepository;
import fi.jenniriikonen.bookstore.domain.Category;
import fi.jenniriikonen.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	//Adding some demo data to database
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
		log.info("save a couple of books");
		crepository.save(new Category("Kids"));
		crepository.save(new Category("Adults"));
		
		repository.save(new Book("Koiramäen lapset", "Mauri Kunnas", 1987, "ISBN1", 17.95, crepository.findByName("Kids").get(0)));
		repository.save(new Book("Koiramäen aikuiset", "Mauri Kunnas", 2020, "ISBN2", 17.95, crepository.findByName("Adults").get(0)));
	
		log.info("fetch all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	
	};
	
	}

}
