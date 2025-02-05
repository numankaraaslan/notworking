package com.example.notworking.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notworking.model.Author;
import com.example.notworking.service.AuthorService;

@RestController
@RequestMapping(path = "author")
public class AuthorController
{
	private AuthorService authorService;

	public AuthorController(AuthorService authorService)
	{
		this.authorService = authorService;
	}

	@PostMapping(path = "save")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<String> save(@RequestBody Author author)
	{
		// localhost:8080/author/save
		// {"name":"numan"}
		authorService.save(author);
		return ResponseEntity.created(URI.create("http://localhost:8080/author/" + author.getId())).body("Successfuly saved");
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Author> getMethodName(@PathVariable(name = "id") Long id)
	{
		// localhost:8080/book/1
		return ResponseEntity.ok(authorService.getById(id));
	}
}