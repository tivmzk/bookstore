package com.hairou.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairou.bookstore.dao.OrdersDao;
import com.hairou.bookstore.model.Orders;
import com.hairou.bookstore.util.Pager;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao dao;
	
	@Override
	public List<Orders> list(Pager pager) {
		float total = dao.total(pager);
		pager.setTotal(total);
		List<Orders> list = dao.list(pager);
		return list;
	}
	
	@Override
	public void add(Orders item) {
		dao.add(item);
	}

	@Override
	public Orders get(int id) {
		Orders item = dao.get(id);
		return item;
	}

	@Override
	public void update(Orders item) {
		dao.update(item);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void init() {
		List<Orders> list = list(new Pager());
		
		while(list.size() != 0) {
			for(Orders item : list) {
				delete(item.getId());
			}
			
			list = list(new Pager());
		}
	}
	
	
}
