package com.example.notworking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.notworking.controller.BookController;
import com.example.notworking.model.Author;
import com.example.notworking.model.Book;
import com.example.notworking.service.AuthorService;
import com.example.notworking.service.BookService;

@WebMvcTest(controllers = BookController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ControllerTests
{
	@Autowired
	MockMvc mock;

	@MockitoBean
	BookService bookService;

	@MockitoBean
	AuthorService authorService;

	@Test
	public void save() throws Exception
	{
		Author author = new Author();
		author.setName("numan");
		Book book = new Book();
		book.setName("book1");
		book.setYear(2022);
		book.setAuthor(author);
		Mockito.when(bookService.save(book)).thenReturn(book);
		RequestBuilder request = MockMvcRequestBuilders.post("/book/save").content("{\"name\":\"book1\", \"year\":2022, \"author\":{\"id\":1}}").contentType(MediaType.APPLICATION_JSON_VALUE);
		ResultMatcher okMatcer = MockMvcResultMatchers.status().isCreated();
		mock.perform(request).andExpect(okMatcer);
	}
}