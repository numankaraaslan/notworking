package com.example.notworking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notworking.model.Book;
import com.example.notworking.repo.BookRepo;

@Service
public class BookService
{
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo)
	{
		this.bookRepo = bookRepo;
	}

	public List<Book> getAll()
	{
		return bookRepo.findAll();
	}

	public Book getById(Long id)
	{
		return bookRepo.findById(id).orElse(null);
	}

	public Book save(Book book)
	{
		return bookRepo.save(book);
	}

	public void deleteAll()
	{
		bookRepo.deleteAll();
	}
}
