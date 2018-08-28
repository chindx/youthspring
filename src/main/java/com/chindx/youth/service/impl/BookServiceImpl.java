package com.chindx.youth.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chindx.youth.dao.BookRepository;
import com.chindx.youth.entity.Book;
import com.chindx.youth.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookDao;
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book insertByBook(Book book) {		
		return bookDao.save(book);
	}

	@Override
	public Book update(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book delete(Long id) {
		Book book = bookDao.findById(id).get();
		bookDao.delete(book);
		return book;		
	}

	@Override
	public Book findById(Long id) {
		return bookDao.findById(id).get();
	}

}
