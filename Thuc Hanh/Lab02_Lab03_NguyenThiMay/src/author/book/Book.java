package author.book;

public class Book {
	private String name;
	private Author author;
	private double price;
	private int ptyInStock=0;
	
	public Book(String name, Author author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book(String name, Author author, double price, int ptyInStock) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.ptyInStock = ptyInStock;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public String getAuthorName() {
		return this.author.getName();
	}
	
	public String getAuthorEmail() {
		return this.author.getEmail();
	}
	
	public char getAuthorGender() {
		return this.author.getGender();
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQtyInStock() {
		return this.ptyInStock;
	}
	
	public void setQtyInStock(int ptyInStock) {
		this.ptyInStock = ptyInStock;
	}
	
	public String toString() {
		return "'" + this.name + "' của tác giả " + author.toString();
	}
	
}
