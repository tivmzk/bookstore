package com.hairou.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairou.bookstore.dao.CustomerDao;
import com.hairou.bookstore.model.Customer;
import com.hairou.bookstore.util.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao dao;
	
	@Override
	public CustomerDao getDao() {
		return dao;
	}
	
	@Override
	public List<Customer> list(Pager pager) {
		float total = dao.total();
		pager.setTotal(total);
		List<Customer> list = dao.list(pager);
		
		return list;
	}

	@Override
	public void add(Customer item) {
		dao.add(item);
	}
	
	@Override
	public Customer get(int id) {
		Customer item = dao.get(id);
		return item;
	}
	
	@Override
	public void update(Customer item) {
		dao.update(item);
	}
	
	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	
	@Override
	public void dummy() {
		for (int i = 1; i <= 100; i++) {
			Customer item = new Customer();
			item.setName("dummy " + i);
			item.setAddress("dummy's address" + i);
			add(item);
		}
	}
	
	@Override
	public void init() {
		List<Customer> list = list(new Pager());
		
		while(list.size() != 0)
		{
			for(Customer item : list) {
				delete(item.getId());
			}
			list = list(new Pager());
		}
		
	}
}
