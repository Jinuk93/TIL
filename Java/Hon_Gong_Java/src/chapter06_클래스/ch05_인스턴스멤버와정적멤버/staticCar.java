package chapter06_Ŭ����.ch05_�ν��Ͻ�������������;

public class staticCar {

	int speed;
	
	void run() {
		System.out.println(speed + "���� �޸��ϴ�");
	}
	
	public static void main(String[] args) {
		//static �޼ҵ� ������ (�ν��Ͻ�)�ʵ带 ����Ϸ���, ��ü�� �������Ѵ�
		Car myCar = new Car(null);
		myCar.speed = 60;
		myCar.run();
	}
}
