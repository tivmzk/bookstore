package com.hairou.bookstore.service;

import java.util.List;

import com.hairou.bookstore.dao.CustomerDao;
import com.hairou.bookstore.model.Customer;
import com.hairou.bookstore.util.Pager;

public interface CustomerService {

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer get(int id);

	void update(Customer item);

	void delete(int id);

	void dummy();

	void init();

	CustomerDao getDao();

}
