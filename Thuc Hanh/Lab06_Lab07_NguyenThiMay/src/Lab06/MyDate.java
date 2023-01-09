package Lab06;

public class MyDate {
	private int year, month, day;
	
	private static String[] strMonths() {
		String [] str = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return str;
	}
	
	private static String[] strDay() {
		String [] str = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		return str;
	}
	
	private static int[] daysInMonths() {
		int [] str = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return str;
	}
	
	public static boolean isLeapYear(int year) {
		return ((year%4==0 && year%100!=0) || year%400==0)? true:false;
	}
	
	//kiểm tra hợp lệ của ngày tháng năm
	public static boolean isValidDate(int year, int month, int day) {
		if(isLeapYear(year) && month==2 && day>=1 && day<=29) return true;
		else if(year>=1 && year <=9999) {
			if(month>=1 && month<=12) {
				if(day>=1 && day <= daysInMonths()[month]) return true;
				return false;
			}
			return false;
		}
		return false;
	} 
	
	//in ra thứ tương ứng với ngày nhập vào
	//public static int getDayOfWeek(int year, int month, int day) {
		
	//}
	
	public MyDate(int year, int month, int day) {
		setDate(year, month, day);
	}
	
	public void setDate(int year, int month, int day) {
		if(isValidDate(year, month, day)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else System.out.println("Ngày, tháng hoặc năm không hợp lệ");
	}
	
	public void setYear(int year) {
		if(year>=1 && year<=9999) this.year = year;
		else System.out.println("năm không hợp lệ");
	}
	
	public void setMonth(int month) {
		if(month>=1 && month<=12) this.month = month;
		else System.out.println("tháng không hợp lệ");
	}
	
	public void setDay(int day) {
		if(isLeapYear(this.year) && this.month==2 && day>=1 && day<=29) this.day = day;
		else if(this.month!=2 && day>=1 && day<=daysInMonths()[this.month]) this.day = day;
		else System.out.println("ngày không hợp lệ");
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	//thiếu
	@Override
	public String toString() {
		return this.day +" "+ strMonths()[this.month] + " " + this.year;
	}
	
	/*
	public MyDate nextDay() {
		
	}
	
	public MyDate nextMonth() {
		if(this.month+1 == 2) {
			if(this.day>=29 && isLeapYear(this.year)==false) return new MyDate(28,this.month+1,this.year);
			
		}
	}
	
	public MyDate nextYear() {
		if(this.day==29 && this.month==2 && isLeapYear(this.year) && isLeapYear(this.year+1)==false) {
			return new MyDate(28,2,this.year+1);
		}
		return new MyDate(this.day, this.month, this.year+1);
	}
	*/
	
}
