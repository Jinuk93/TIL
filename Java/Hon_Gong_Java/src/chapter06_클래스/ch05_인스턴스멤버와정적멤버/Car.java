package chapter06_Ŭ����.ch05_�ν��Ͻ�������������;

public class Car {

	//�ʵ�
	String model;
	int speed;
	
	//������
	Car(String model) {
		this.model = model;
	}
	
	void run() {
		for(int i=0; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "�� �޸��ϴ�.(�ü� :" + this + "km/h)");
		}
	}

	private void setSpeed(int i) {
		// TODO Auto-generated method stub
		
	}
}
