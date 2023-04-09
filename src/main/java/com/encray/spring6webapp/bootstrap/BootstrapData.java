package com.encray.spring6webapp.bootstrap;

import com.encray.spring6webapp.domain.Author;
import com.encray.spring6webapp.domain.Book;
import com.encray.spring6webapp.domain.Publisher;
import com.encray.spring6webapp.repositories.AuthorRepository;
import com.encray.spring6webapp.repositories.BookRepository;
import com.encray.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("eric");
    eric.setLastName("evans");

    Author rod = new Author();
    rod.setFirstName("road");
    rod.setLastName("Johnson");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("12345");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("54757585");

    Publisher aw = new Publisher();
    aw.setPublisherName("addison willey");
    aw.setAddress("4504 bevily drive");
    aw.setCity("The Colony");
    aw.setZip("75056");

    Author ericSaved = authorRepository.save(eric);
    Author rodSaved = authorRepository.save(rod);

    Book ddSaved = bookRepository.save(ddd);
    Book noEJBSaved = bookRepository.save(noEJB);

    Publisher savedPublisher = publisherRepository.save(aw);

    ericSaved.getBooks().add(ddSaved);
    rodSaved.getBooks().add(noEJBSaved);
    ddSaved.getAuthors().add(ericSaved);
    noEJBSaved.getAuthors().add(rodSaved);


    ddSaved.setPublisher(savedPublisher);
    noEJBSaved.setPublisher(savedPublisher);


    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(ddSaved);
    bookRepository.save(noEJBSaved);


    System.out.println("In BootStrap");

    System.out.println("Author Count " + authorRepository.count());
    System.out.println("publisher Count " + publisherRepository.count());


  }
}
