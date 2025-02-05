package com.example.notworking.service;

import org.springframework.stereotype.Service;

import com.example.notworking.model.Author;
import com.example.notworking.repo.AuthorRepo;

@Service
public class AuthorService
{
	private AuthorRepo authorRepo;

	public AuthorService(AuthorRepo authorRepo)
	{
		this.authorRepo = authorRepo;
	}

	public Author save(Author author)
	{
		return authorRepo.save(author);
	}

	public Author getAuthorByName(String name)
	{
		return authorRepo.getAuthorByName(name);
	}

	public Author getById(Long id)
	{
		return authorRepo.findById(id).orElse(null);
	}
}
