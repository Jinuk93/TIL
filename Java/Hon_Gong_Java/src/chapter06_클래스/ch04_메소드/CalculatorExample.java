package chapter06_Ŭ����.ch04_�޼ҵ�;

public class CalculatorExample { //���� Ŭ����

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("���1 : " + result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y); //���ٿ� byte x,y�� �ʱ�ȭ�� ��
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
	}
}
