package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class CarExample {
	
	public static void main(String[] args) {
		Car myCar = new Car("볼보");
		Car yourCar = new Car("붕붕이");
		
		myCar.run();
		yourCar.run();
	}
}
