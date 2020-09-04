package fi.jenniriikonen.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jenniriikonen.bookstore.domain.Book;
import fi.jenniriikonen.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	//Adding some demo data to database
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book b1 = new Book("Koiramäen lapset", "Mauri Kunnas", 1987, "ISBN1", 17.95);
		Book b2 = new Book("Koiramäen aikuiset", "Mauri Kunnas", 2020, "ISBN2", 17.95);	
		Book b3 = new Book("Koiramäen vanhukset", "Mauri Kunnas", 2060, "ISBN3", 17.95);	
	
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
	
	
	};
	
	}

}
