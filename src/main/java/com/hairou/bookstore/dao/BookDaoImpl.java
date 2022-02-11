package com.hairou.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hairou.bookstore.model.Book;
import com.hairou.bookstore.util.Pager;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	SqlSession sql;

	@Override
	public List<Book> list(Pager pager) {
		return sql.selectList("book.list", pager);
	}

	@Override
	public void add(Book item) {
		sql.insert("book.add", item);
	}
	
	@Override
	public Book get(int id) {
		Book item = sql.selectOne("book.get", id);
		return item;
	}
	
	@Override
	public void update(Book item) {
		sql.update("book.update", item);
	}
	
	@Override
	public void delete(int id) {
		sql.delete("book.delete", id);
	}
	
	@Override
	public int total() {
		return sql.selectOne("book.total");
	}
}
