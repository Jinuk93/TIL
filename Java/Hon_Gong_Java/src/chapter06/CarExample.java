package chapter06;

public class CarExample {

	public static void main(String[] args) {
		
		//Car 클래스에있는 Car객체생성
		//같은 패키지라서 가능한 듯 싶다(?)
		Car myCar = new Car(); //!!Car라는 클래스를 myCar라는 클래스명으로 참조하겠다!!
		
		//필드값 읽기
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색상 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.maxSpeed);
		System.out.println("현재속도 : " + myCar.speed);
		
		//필드값 변경
		myCar.speed = 60; //Car 클래스에서는 int speed로 필드에 생성만 했다
		System.out.println("수정된 속도 : " +myCar.speed);
	}
}
