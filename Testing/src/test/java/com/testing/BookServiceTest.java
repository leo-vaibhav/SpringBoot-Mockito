package com.testing;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.testing.TestingApplication;
import com.testing.entity.Book;
import com.testing.repository.BookRepository;
import com.testing.service.BookService;

@SpringBootTest(classes=TestingApplication.class)
public class BookServiceTest {
	
	@Mock 
	BookRepository bookRepo;
	
	@InjectMocks
	BookService bookService = new BookService();
	
	@Test
	public void testGetAllBooks() {
		
		List<Book> books = new ArrayList<>();
		Book b = new Book(1, "Learn Java", "Abc", 100, "borrowed");
		books.add(b);
		Book b1 = new Book(2, "Learn Python", "Abcd", 1000, "borrowed");
		books.add(b1);
		
		when(bookRepo.findAll()).thenReturn(books);
		List<Book> result = bookService.getAllBooks();
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertTrue(result.get(0).getAuthor().endsWith("-a"));
		Assertions.assertTrue(result.get(1).getAuthor().endsWith("-a"));
		Assertions.assertEquals("Learn Java-b", result.get(0).getName());
		Assertions.assertEquals("Learn Python-b", result.get(1).getName());
	}
}
