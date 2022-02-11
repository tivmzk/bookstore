package com.hairou.bookstore.dao;

import java.util.List;

import com.hairou.bookstore.model.Book;
import com.hairou.bookstore.util.Pager;

public interface BookDao {

	List<Book> list(Pager pager);

	void add(Book item);

	Book get(int id);

	void update(Book item);

	void delete(int id);

	int total();

}
