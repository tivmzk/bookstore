package com.hairou.bookstore.dao;

import java.util.List;

import com.hairou.bookstore.model.Orders;
import com.hairou.bookstore.util.Pager;

public interface OrdersDao {

	float total(Pager pager);

	List<Orders> list(Pager pager);

	void add(Orders item);

	Orders get(int id);

	void update(Orders item);

	void delete(int id);

}
