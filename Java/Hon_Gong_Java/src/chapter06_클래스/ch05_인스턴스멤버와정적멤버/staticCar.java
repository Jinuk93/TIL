package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class staticCar {

	int speed;
	
	void run() {
		System.out.println(speed + "으로 달립니다");
	}
	
	public static void main(String[] args) {
		//static 메소드 내에서 (인스턴스)필드를 사용하려면, 객체를 만들어야한다
		Car myCar = new Car(null);
		myCar.speed = 60;
		myCar.run();
	}
}
