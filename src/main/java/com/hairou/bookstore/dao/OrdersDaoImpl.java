package com.hairou.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hairou.bookstore.model.Orders;
import com.hairou.bookstore.util.Pager;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	SqlSession sql;

	@Override
	public float total(Pager pager) {
		int total = sql.selectOne("orders.total");
		return total;
	}

	@Override
	public List<Orders> list(Pager pager) {
		List<Orders> list = sql.selectList("orders.list", pager);
		return list;
	}

	@Override
	public void add(Orders item) {
		sql.insert("orders.add", item);
	}

	@Override
	public Orders get(int id) {
		Orders item = sql.selectOne("orders.get", id);
		return item;
	}

	@Override
	public void update(Orders item) {
		sql.update("orders.update", item);
	}

	@Override
	public void delete(int id) {
		sql.update("orders.delete", id);
	}

}
