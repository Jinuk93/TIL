package chapter06_클래스.ch04_메소드;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5); //Car클래스의 setGase() 메소드 호출
						 
		boolean gasState = myCar.isLeftGas(); //Car 클래스의 isLeftGas() 메소드 호출
		if(gasState) {
			System.out.println("출발합니다. ");
			myCar.run(); //Car의 run() 메소드 호출
		}
		if(myCar.isLeftGas()) { //Car 클래스의 isLeftGas() 메소드 호출
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요.");
		}
	}
}
