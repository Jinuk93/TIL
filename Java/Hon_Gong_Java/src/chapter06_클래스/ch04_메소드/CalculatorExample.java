package chapter06_클래스.ch04_메소드;

public class CalculatorExample { //실행 클래스

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("결과1 : " + result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y); //윗줄에 byte x,y의 초기화를 함
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
	}
}
