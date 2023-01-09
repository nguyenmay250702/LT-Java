package QLCB;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class Test_insertCB {

	public static void doInsertCB(Vector CB) {
		QLCB qlcb = new QLCB();
		try {
			qlcb.insertCB(CB);
			System.out.println("Them thanh cong");
		} catch (SQLException e) {
			System.out.println("Them khong thanh cong");
			e.printStackTrace();
		}
	}
	
	
	//nhập thong tin va them vao bang
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Vector data = new Vector();
		System.out.println("Nhap lan luot SoTK > Hoten > GT > Diachi > Luong"); 
		data.add(Integer.parseInt(input.nextLine()));
		data.add(input.nextLine());
		data.add(input.nextLine());
		data.add(input.nextLine());
		data.add(Float.parseFloat(input.nextLine()));

		doInsertCB(data);
	}

}
