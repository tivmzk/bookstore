package com.hairou.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootContoller {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
