package chapter06_클래스.ch01_03_객체_필드_생성자;

public class OverloadingCar {

	//필드
	String company = "현대자동차";
	String model = "아반떼";
	String color = "스페이스그레이";
	int maxspeed = 350;
	
	//생성자
	 
	//의문점 : 클래스에 public이 붙어도, 생성자를 오버로딩 할때에는 public을 안붙이는가?
	////public OverloadingCar() { 이렇게 말이다. 하지만 책은 '생성자 오버로딩'할 때에는 public을 붙이지 않는다
	OverloadingCar() {
	}
	OverloadingCar(String model) {
		this.model = model; 
		//여기서 this를 붙이는 이유는 위의 필드에서 model이란 필드와 생성자() 괄호안의 model의 타입과 이름이 같기 때문이다 
	}
	OverloadingCar(String model, String color) {
		this.model = model;
		this.color = color;
	}
	OverloadingCar(String model, String color, int maxspeed) {
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;
	}
}
