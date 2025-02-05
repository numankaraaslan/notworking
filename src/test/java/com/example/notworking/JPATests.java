package com.example.notworking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.notworking.model.Author;
import com.example.notworking.model.Book;
import com.example.notworking.repo.AuthorRepo;
import com.example.notworking.repo.BookRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JPATests
{
	@Autowired
	BookRepo bookRepo;

	@Autowired
	AuthorRepo authorRepo;

	@Test
	@Rollback(value = true)
	public void save()
	{
		Author author = new Author();
		author.setName("numan");
		author = authorRepo.save(author);
		Book book = new Book();
		book.setAuthor(author);
		book.setName("book1");
		book.setYear(2022);
		Book actual = bookRepo.save(book);
		Assertions.assertEquals(actual.getName(), "book1");
		Assertions.assertEquals(actual.getAuthor().getName(), "numan");
	}
}