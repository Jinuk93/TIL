package chapter06_Ŭ����.ch05_�ν��Ͻ�������������;

public class Singleton {
	private static Singleton singleton = new Singleton();
	//���� �д¹���� �򰥸��� private static�� ������, ������ ���� �ʵ�����ΰ��� �� �� �ִ�
	
	private Singleton() {
		
	}
	static Singleton getInstance() {
		return singleton;
	}
}
