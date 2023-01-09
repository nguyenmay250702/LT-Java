package GKH;

import java.sql.SQLException;
import java.util.Scanner;

public class Test_deIeteKH {

	public static void doDelKH(String DiaChi, String GioiTinh) {
		XLKH xlkh = new XLKH();
		try {
			xlkh.delKH(DiaChi, GioiTinh);
			System.out.println("Xoa Thanh Cong");
		} catch (SQLException e) {
			System.out.println("Xoa Khong Thanh Cong");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap vao lan luot: Dia Chi va Gioi Tinh");
		doDelKH(input.nextLine(), input.nextLine());
	}

}
