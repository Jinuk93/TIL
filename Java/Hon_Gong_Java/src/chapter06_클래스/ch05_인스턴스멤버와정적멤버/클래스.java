package chapter06_Ŭ����.ch05_�ν��Ͻ�������������;

public class Ŭ���� {

	//�����ʵ�
	private static Ŭ���� singleton = new Ŭ����();
	//Ŭ���� �ܺο��� ȣ������ ���ϵ��� private ���� ������ ���
	
	//������
	private Ŭ����() { 
	//Ŭ���� ���ο����� ���� new Ŭ������ ���� ���� Ŭ���� �����ڸ� ���� �� �ִ�
		
	}
	//�����޼ҵ�
	static Ŭ���� getInstance() {
		return singleton;
	}
}
