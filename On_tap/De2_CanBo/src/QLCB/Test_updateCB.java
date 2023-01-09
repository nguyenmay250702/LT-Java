package QLCB;

import java.sql.SQLException;
import java.util.Scanner;

public class Test_updateCB {
	public static void doUpdateCB(int SoTK_new, String HoTen_new, String GT_new, String DiaChi_new, float Luong_New, int SoTK_old) {
		QLCB qlcb = new QLCB();
		try {
			qlcb.updateCB(SoTK_new, HoTen_new, GT_new, DiaChi_new, Luong_New, SoTK_old);
			System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			System.out.println("Cap nhat khong thanh cong");
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap lan luot cac thong tin sau:");
		System.out.println("So tai khoan cu/ So tai khoan moi/ Ho ten/ Gioi Tinh/ Dia Chi/ Luong");
		int SoTK_old = Integer.parseInt(input.nextLine());
		int SoTK_new = Integer.parseInt(input.nextLine());
		String HoTen_new = input.nextLine();
		String GT_new = input.nextLine();
		String DiaChi_new = input.nextLine();
		float Luong_New = Float.parseFloat(input.nextLine());
		
		doUpdateCB(SoTK_new, HoTen_new, GT_new, DiaChi_new, Luong_New, SoTK_old);
	}

}
