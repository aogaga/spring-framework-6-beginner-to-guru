package com.encray.spring6webapp.services;

import com.encray.spring6webapp.domain.Author;
import com.encray.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorServiceImpl implements AuthorService{

  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Iterable<Author> findaAll() {
    return authorRepository.findAll();
  }
}
