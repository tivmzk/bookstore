package com.hairou.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hairou.bookstore.model.Customer;
import com.hairou.bookstore.util.Pager;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Customer> list(Pager pager) {
		List<Customer> list = sql.selectList("customer.list", pager);
		return list;
	}

	@Override
	public void add(Customer item) {
		sql.insert("customer.add", item);
	}
	
	@Override
	public Customer get(int id) {
		Customer item = sql.selectOne("customer.get", id);
		return item;
	}
	
	@Override
	public void update(Customer item) {
		sql.update("customer.update", item);
	}
	
	@Override
	public void delete(int id) {
		sql.delete("customer.delete", id);
	}
	
	@Override
	public float total() {
		int total = sql.selectOne("customer.total");
		return total;
	}
}
