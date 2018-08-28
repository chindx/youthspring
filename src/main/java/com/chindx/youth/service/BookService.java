package com.chindx.youth.service;

import java.util.List;

import com.chindx.youth.entity.Book;

public interface BookService {
	
	List<Book> findAll();
	
	Book insertByBook(Book book);
	
	Book update(Book book);
	
	Book delete(Long id);
	
	Book findById(Long id);
}
