package com.api.book.bootrestapibook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestapibook.entities.Book;

@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12, "Java Programmer", "ABC"));
		list.add(new Book(24, "Python Programmer", "DEF"));
		list.add(new Book(36, "Cpp Programmer", "PQR"));
	}
	
	//get all books
	public List<Book> getAllBooks() {
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		
		Book book = null;
		try {
			book = list.stream().filter(e->e.getId()==id).findFirst().get();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Book requested not present in the list");
		}
		return book;
	}
	
	//adding book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	//delete book
	public void deleteBook(int id) {
		
		list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
		
	}
	
	//update book
	public void updateBook(Book book, int bookId) {
		
		list = list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
	}

}
