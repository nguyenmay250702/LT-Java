package Lab06;

public class MyTime {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	public MyTime(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}
	
	public void setTime(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public void setHour(int hour) {
		if(hour>=0 && hour<=23) this.hour = hour;
		else System.out.println("Giờ không hợp lệ");
	}

	public void setMinute(int minute) {
		if(minute>=0 && minute<=59) this.minute = minute;
		else System.out.println("phút không hợp lệ");
	}

	public void setSecond(int second) {
		if(second>=0 && second<=59) this.second = second;
		else System.out.println("Giây không hợp lệ");
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	
	public MyTime nextSecond() {
		if(this.second + 1==60) {
			this.second = 0;
			nextMinute();
		}
		else this.second +=1;
		return new MyTime(this.hour, this.minute, this.second);
	}
	
	public MyTime nextMinute() {
		if(this.minute + 1 == 60) {
			this.minute=0;
			nextHour();
		}
		else this.minute = this.minute+1;
		return new MyTime(this.hour,this.minute,this.second);
	}
	
	public MyTime nextHour() {
		this.hour = (this.hour+1 == 24)? 0:this.hour+1;
		return new MyTime(this.hour,this.minute,this.second);
	}
	
	
	public MyTime previousSecond() {
		if(this.second == 0) {
			this.second = 59;
			previousMinute();
		}
		else this.second -= 1;
		return new MyTime(this.hour, this.minute, this.second);
	}
	
	public MyTime previousMinute() {
		if(this.minute == 0) {
			this.minute = 59;
			previousHour();
		}
		else this.minute -= 1;
		return new MyTime(this.hour, this.minute, this.second);
	}
	
	public MyTime previousHour() {
		if(this.hour == 0) this.hour = 23;
		else this.hour -= 1;
		return new MyTime(this.hour, this.minute, this.second);
	}
}
