package com.example.notworking.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notworking.model.Book;
import com.example.notworking.service.BookService;

@RestController
@RequestMapping(path = "book")
public class BookController
{
	private BookService bookService;

	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	@GetMapping(path = { "", "/" })
	public ResponseEntity<List<Book>> getMethodName()
	{
		// localhost:8080/book
		return ResponseEntity.ok(bookService.getAll());
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Book> getMethodName(@PathVariable(name = "id") Long id)
	{
		// localhost:8080/book/1
		return ResponseEntity.ok(bookService.getById(id));
	}

	@PostMapping(path = "save")
	public ResponseEntity<String> save(@RequestBody Book book)
	{
		// localhost:8080/book/save
		// {"name":"book1", "year":2022, "author":{"id":1}}
		bookService.save(book);
		return ResponseEntity.created(URI.create("http://localhost:8080/book/" + book.getId())).body("Successfuly saved");
	}

	@DeleteMapping(path = "delete")
	public ResponseEntity<String> delete()
	{
		// localhost:8080/book/delete
		bookService.deleteAll();
		return ResponseEntity.ok("Deleted all books");
	}
}