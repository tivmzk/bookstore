package com.hairou.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hairou.bookstore.dao.BookDao;
import com.hairou.bookstore.dao.CustomerDao;
import com.hairou.bookstore.model.Customer;
import com.hairou.bookstore.model.Orders;
import com.hairou.bookstore.service.BookService;
import com.hairou.bookstore.service.CustomerService;
import com.hairou.bookstore.service.OrdersService;
import com.hairou.bookstore.util.Pager;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	@Autowired
	BookService bookService;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Orders> list = ordersService.list(pager);
		model.addAttribute("list", list);
		return "orders/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		Pager bookPager = new Pager();
		BookDao bookDao = bookService.getDao();
		bookPager.setTotal(bookDao.total());
		bookPager.setPage(1);
		bookPager.setPerPage((int)bookPager.getTotal());
		
		Pager cusPager = new Pager();
		CustomerDao cusDao = customerService.getDao();
		cusPager.setTotal(cusDao.total());
		cusPager.setPage(1);
		cusPager.setPerPage((int)bookPager.getTotal());
		
		model.addAttribute("booklist", bookService.list(bookPager));
		model.addAttribute("cuslist", customerService.list(cusPager));
		
		return "orders/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Orders item) {
		ordersService.add(item);
		return "redirect:list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, int id) {
		Orders item = ordersService.get(id);
		Customer cus = customerService.get(item.getCusid());
		item.setCusname(cus.getName());
		model.addAttribute("item", item);
		
		Pager bookPager = new Pager();
		BookDao bookDao = bookService.getDao();
		bookPager.setTotal(bookDao.total());
		bookPager.setPage(1);
		bookPager.setPerPage((int)bookPager.getTotal());
		model.addAttribute("booklist", bookService.list(bookPager));
		
		return "orders/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Orders item) {
		ordersService.update(item);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		ordersService.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	public String init() {
		ordersService.init();
		return "redirect:list";
	}
}
