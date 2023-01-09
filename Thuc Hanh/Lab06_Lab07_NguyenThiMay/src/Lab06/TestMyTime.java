package Lab06;

public class TestMyTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTime T1 = new MyTime(23,58,59);
		System.out.println("Thời gian ban đầu: " + T1.toString());
		System.out.println("Thời gian khi tăng giây lên 1s: "+ T1.nextSecond());
		System.out.println("Thời gian khi tăng phút lên 1m: "+ T1.nextMinute());
		System.out.println("Thời gian khi tăng giờ lên 1h: "+ T1.nextHour());
		System.out.println("Thời gian khi tăng giờ lên 1h: "+ T1.previousHour().previousSecond());
	}
}
