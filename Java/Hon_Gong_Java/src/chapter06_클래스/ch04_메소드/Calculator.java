package chapter06_Ŭ����.ch04_�޼ҵ�;

public class Calculator {

	/*
	 <�޼ҵ� ����>
	  
	 ����Ÿ�� �żҵ��̸� (�Ű�����) { 
	 ��~~~��~~~��~~~��;
	 return (���Ϲ޴°�);
	 }
	*/
	
	//�޼ҵ�
	void powerOn() { //����Ÿ���� void
		System.out.println("������ �մϴ�");
	}
	//�޼ҵ�(?)
	int plus(int x, int y) { //���⼭ ���� Ÿ���� int, plus�� �żҵ��̸�, ()���� �Ű����� ����
		int result = x + y; //���� �Ʒ� ������ ������
		return result;
	}
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	void powerOff() {
		System.out.println("������ �մϴ�");
	}
}
