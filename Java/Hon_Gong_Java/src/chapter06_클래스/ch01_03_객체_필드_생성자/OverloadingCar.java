package chapter06_Ŭ����.ch01_03_��ü_�ʵ�_������;

public class OverloadingCar {

	//�ʵ�
	String company = "�����ڵ���";
	String model = "�ƹݶ�";
	String color = "�����̽��׷���";
	int maxspeed = 350;
	
	//������
	 
	//�ǹ��� : Ŭ������ public�� �پ, �����ڸ� �����ε� �Ҷ����� public�� �Ⱥ��̴°�?
	////public OverloadingCar() { �̷��� ���̴�. ������ å�� '������ �����ε�'�� ������ public�� ������ �ʴ´�
	OverloadingCar() {
	}
	OverloadingCar(String model) {
		this.model = model; 
		//���⼭ this�� ���̴� ������ ���� �ʵ忡�� model�̶� �ʵ�� ������() ��ȣ���� model�� Ÿ�԰� �̸��� ���� �����̴� 
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
