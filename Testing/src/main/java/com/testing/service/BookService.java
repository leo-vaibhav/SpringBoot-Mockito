package com.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.entity.Book;
import com.testing.repository.BookRepository;

@Service
public class BookService {
	
	//@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks() {
		List<Book> allBooks = (List<Book>) bookRepo.findAll();
		allBooks.forEach(b -> b.setName(b.getName() + "-b"));
		allBooks.forEach(b -> b.setAuthor(b.getAuthor() + "-a"));
		return allBooks;
	}
}