package author.book;

public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author anAuthor = new Author("Nguyễn Thị Mây", "nguyena308@gmail.com", 'm');
		Book aBook = new Book("Toán", anAuthor, 361.6);
		System.out.println(aBook.toString());
		
		System.out.println("\n- Lấy ra tên của tác giả và email thông qua phiên bản sách");
		System.out.println("\t+ Tên tác giả: " + aBook.getAuthor().getName());
		System.out.println("\t+ Email tác giả: " + aBook.getAuthor().getEmail());
		
		//sd phương thức lấy ra thông tin của tác giả của mỗi phiên bản sách
		System.out.println("\n- sd phương thức được định nghĩa lấy ra tên của tác giả và email thông qua phiên bản sách");
		System.out.println("\t+ Tên tác giả: "+ aBook.getAuthorName());
		System.out.println("\t+ Email tác giả: "+ aBook.getAuthorEmail());
		System.out.println("\t+ Giới tính : "+ aBook.getAuthorGender());
	}
}
