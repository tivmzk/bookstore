package com.hairou.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hairou.bookstore.model.Book;
import com.hairou.bookstore.service.BookService;
import com.hairou.bookstore.util.Pager;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Book> item = service.list(pager);
		model.addAttribute("list", item);
		return "book/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "book/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Book item) {
		service.add(item);
		return "redirect:list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, int id) {
		Book item = service.get(id);
		model.addAttribute("item", item);
		return "book/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Book item) {
		service.update(item);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("/dummy")
	public String dummy() {
		service.dummy();		
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	public String init() {
		service.init();
		return "redirect:list";
	}
}
