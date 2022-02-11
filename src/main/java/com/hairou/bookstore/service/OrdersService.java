package com.hairou.bookstore.service;

import java.util.List;

import com.hairou.bookstore.model.Orders;
import com.hairou.bookstore.util.Pager;

public interface OrdersService {

	List<Orders> list(Pager pager);

	void add(Orders item);

	Orders get(int id);

	void update(Orders item);

	void delete(int id);

	void init();

}
