package chapter06;

public class CarExample {

	public static void main(String[] args) {
		
		//Car Ŭ�������ִ� Car��ü����
		//���� ��Ű���� ������ �� �ʹ�(?)
		Car myCar = new Car(); //!!Car��� Ŭ������ myCar��� Ŭ���������� �����ϰڴ�!!
		
		//�ʵ尪 �б�
		System.out.println("����ȸ�� : " + myCar.company);
		System.out.println("�𵨸� : " + myCar.model);
		System.out.println("���� : " + myCar.color);
		System.out.println("�ְ�ӵ� : " + myCar.maxSpeed);
		System.out.println("����ӵ� : " + myCar.speed);
		
		//�ʵ尪 ����
		myCar.speed = 60; //Car Ŭ���������� int speed�� �ʵ忡 ������ �ߴ�
		System.out.println("������ �ӵ� : " +myCar.speed);
	}
}
