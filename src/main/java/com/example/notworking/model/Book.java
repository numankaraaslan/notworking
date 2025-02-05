package com.example.notworking.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(length = 50)
	String name;

	@Column
	int year;

	@JoinColumn(foreignKey = @ForeignKey(name = "FK_AUTHOR"), nullable = true)
	Author author;

	public Book()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}
}
