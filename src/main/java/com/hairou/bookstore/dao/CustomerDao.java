package com.hairou.bookstore.dao;

import java.util.List;

import com.hairou.bookstore.model.Customer;
import com.hairou.bookstore.util.Pager;

public interface CustomerDao {

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer get(int id);

	void update(Customer item);

	void delete(int id);

	float total();

}
