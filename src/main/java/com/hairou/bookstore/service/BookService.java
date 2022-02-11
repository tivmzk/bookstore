package com.hairou.bookstore.service;

import java.util.List;

import com.hairou.bookstore.dao.BookDao;
import com.hairou.bookstore.model.Book;
import com.hairou.bookstore.util.Pager;

public interface BookService {
	List<Book> list(Pager pager);
	void add(Book item);
	Book get(int id);
	void update(Book item);
	void delete(int id);
	void dummy();
	void init();
	BookDao getDao();
}
