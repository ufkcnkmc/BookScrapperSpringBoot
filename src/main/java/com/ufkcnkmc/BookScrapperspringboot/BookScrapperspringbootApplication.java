package com.ufkcnkmc.BookScrapperspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.BookService;

/*@SpringBootApplication
public class BookScrapperspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookScrapperspringbootApplication.class, args);
	}

}*/
@SpringBootApplication
public class BookScrapperspringbootApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookScrapperspringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.scrapeAndSaveBooks();
    }
}

