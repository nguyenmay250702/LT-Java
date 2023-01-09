package Lab07;

public class Book {
	private String name;
	private Author[] authors = new Author[5];
	private int numAuthors = 0;
	private double price;
	private int qtyInStock =0;
	
	public Book(String name, Author[] authors, double price) {
		super();
		this.name = name;
		this.authors = authors;
		this.price = price;
	}

	public Book(String name, double price, int qtyInStock) {
		super();
		this.name = name;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName() {
		return name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	@Override
	public String toString() {
		return "tên sách: '" + name + "' của " + numAuthors + " tác giả";
	}
	
	public void printAuthor() {
		for(int i=0; i<numAuthors; i++) {
			System.out.println("\t+ " + this.authors[i].getName());
		}
	}
	
	public void addAuthor(Author author) {
		this.authors[numAuthors] = author;
		numAuthors++;
	}
	
	//xóa tác giả ra khỏi sách
	public boolean removeAuthorByName(String authorName) {
		for(int i=0; i< numAuthors; i++) {
			if(authorName == this.authors[i].getName()) {
				if(i==numAuthors) numAuthors--;
				else {
					this.authors[i] = this.authors[i+1];
					numAuthors--;
				}
				return true;
			}
		}
		return false;
	}
}
