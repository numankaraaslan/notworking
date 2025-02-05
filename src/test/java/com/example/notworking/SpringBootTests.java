package com.example.notworking;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.RestTemplate;

import com.example.notworking.model.Author;
import com.example.notworking.model.Book;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(value = MethodOrderer.MethodName.class)
class SpringBootTests
{
	@Test
	@Order(value = 2)
	void getbyidtest()
	{
		RestTemplate template = new RestTemplate();
		String url = "http://127.0.1.1:8080/book/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 1);
		Author author = new Author();
		author.setName("numan");
		Book book = new Book();
		book.setName("book1");
		book.setYear(2022);
		book.setAuthor(author);
		book.setId(1L);
		ResponseEntity<Book> response = template.getForEntity(url, Book.class, uriVariables);
		Assertions.assertEquals(book, response.getBody(), "wrong data !!!");
	}

	@Test
	@Order(value = 1)
	void saveTest()
	{
		RestTemplate template = new RestTemplate();
		String url = "http://127.0.0.1:8080/author/save";
		Author author = new Author();
		author.setName("numan");
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("user-1234");
		HttpEntity<Author> request = new HttpEntity<Author>(author, headers);
		ResponseEntity<String> result = template.postForEntity(url, request, String.class);
		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
		url = "http://127.0.0.1:8080/author/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 1);
		author = template.getForEntity(url, Author.class, uriVariables).getBody();
		url = "http://127.0.0.1:8080/nook/save";
		Book book = new Book();
		book.setName("book1");
		book.setYear(2022);
		result = template.postForEntity(url, book, String.class);
		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
}