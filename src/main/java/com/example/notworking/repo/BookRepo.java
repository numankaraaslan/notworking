package com.example.notworking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notworking.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>
{
}