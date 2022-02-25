package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class Car {

	//필드
	String model;
	int speed;
	
	//생성자
	Car(String model) {
		this.model = model;
	}
	
	void run() {
		for(int i=0; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속 :" + this + "km/h)");
		}
	}

	private void setSpeed(int i) {
		// TODO Auto-generated method stub
		
	}
}
