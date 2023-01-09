package Lab07;

public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author author1= new Author("Tan An Teck", "AhTeck@somewhere.com", 'm');
		Author author2= new Author("Paul Tan", "Paul@nowhere.com", 'm');
		
		Book toan = new Book("Giải tích hàm 1 biến", 5.5, 99);
		toan.addAuthor(author1);
		toan.addAuthor(author2);
		System.out.println(toan);
		toan.printAuthor();
		
		if(toan.removeAuthorByName("Tan An Teck")) System.out.println("- Xóa tác giả thành công");
		else System.out.println("- Xóa không thành công, do tên tác giả cần xóa không có trong sách");
	}
}
