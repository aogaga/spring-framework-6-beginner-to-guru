package com.encray.spring6webapp.services;

import com.encray.spring6webapp.domain.Book;
import com.encray.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }
}
