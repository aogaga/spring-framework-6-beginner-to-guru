package com.encray.spring6webapp.services;

import com.encray.spring6webapp.domain.Book;

public interface BookService {
  Iterable<Book> findAll();

}
