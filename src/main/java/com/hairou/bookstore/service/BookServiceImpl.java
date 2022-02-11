package com.hairou.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairou.bookstore.dao.BookDao;
import com.hairou.bookstore.model.Book;
import com.hairou.bookstore.util.Pager;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;
	
	@Override
	public BookDao getDao() {
		return dao;
	}
	@Override
	public List<Book> list(Pager pager) {
		float total = dao.total();
		pager.setTotal(total);
		List<Book> item = dao.list(pager);
		
		return item;
	}

	@Override
	public void add(Book item) {
		dao.add(item);
	}
	
	@Override
	public Book get(int id) {
		Book item = dao.get(id);
		return item;
	}
	
	@Override
	public void update(Book item) {
		dao.update(item);
	}
	
	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	
	@Override
	public void dummy() {
		for (int i = 1; i <= 100; i++) {
			Book item = new Book();
			item.setName("dummy " + i);
			item.setPrice((int)(Math.random() * 10000));
			item.setPublisher("dummy publisher " + i);
			
			add(item);
		}
	}
	
	@Override
	public void init() {
		Pager pager = new Pager();
		List<Book> list = list(pager);
		
		while(list.size() != 0) {
			for(Book item : list) {
				delete(item.getId());
			}
			list = list(pager);
		}
		
	}
}
