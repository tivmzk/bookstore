package com.hairou.bookstore.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private float total;
	private int perGroup = 10;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getPerGroup() {
		return perGroup;
	}
	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	
	public List<Integer> getList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int startPage = ((page - 1) / perGroup) * perGroup + 1;
		
		for(int idx = startPage; idx < (startPage + perGroup) && idx <= getLast(); idx++) {
			list.add(idx);
		}
		
		if(list.isEmpty()) {
			list.add(1);
		}
		
		return list;
	}
	public int getLast() {
		return (int)Math.ceil(total / perPage);
	}
	
	public int getPrev() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
	}
	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		return next < last ? next : last;
	}
}
