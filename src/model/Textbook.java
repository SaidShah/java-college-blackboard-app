package model;

import java.io.Serializable;

public class Textbook implements Serializable{
	private String title;
	private Name name;
	private String publisher;
	private String isbn;
	private double price;

	public Textbook(String title, Name name, String publisher, String isbn, double price) {
		super();
		this.title = title;
		this.name = name;
		this.publisher = publisher;
		this.isbn = isbn;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook title: " + title + ", author: " + name + ", publisher: " + publisher + ", isbn: " + isbn
				+ ", price: " + price;
	}

}
