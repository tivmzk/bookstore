package com.hairou.bookstore.model;

public class Book {
	private int id;
	private String name;
	private int price;
	private String publisher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return String.format("id: %d\nname: %s\nprice: %d\npublisher: %s", id, name, price, publisher);
	}
}
