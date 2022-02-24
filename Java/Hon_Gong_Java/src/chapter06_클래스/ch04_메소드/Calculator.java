package chapter06_클래스.ch04_메소드;

public class Calculator {

	/*
	 <메소드 구성>
	  
	 리턴타입 매소드이름 (매개변수) { 
	 실~~~행~~~블~~~록;
	 return (리턴받는곳);
	 }
	*/
	
	//메소드
	void powerOn() { //리턴타입은 void
		System.out.println("전원을 켭니다");
	}
	//메소드(?)
	int plus(int x, int y) { //여기서 리턴 타입은 int, plus는 매소드이름, ()안은 매개변수 선언
		int result = x + y; //여기 아래 두줄은 실행블록
		return result;
	}
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	void powerOff() {
		System.out.println("전원을 켭니다");
	}
}
