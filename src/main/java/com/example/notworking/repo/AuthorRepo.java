package com.example.notworking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notworking.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>
{
	Author getAuthorByName(String name);
}