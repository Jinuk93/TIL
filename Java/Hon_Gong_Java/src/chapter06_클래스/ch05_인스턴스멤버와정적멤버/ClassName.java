package chapter06_Ŭ����.ch05_�ν��Ͻ�������������;

//���� �޼ҵ� �����, ��������
public class ClassName {

	//�ν��Ͻ� �ʵ�� �޼ҵ�
	int field;
	void method() {	
	}
	//���� �ʵ�� �޼ҵ�
	static int field2;
	static void method2() {	
	}
	//���� �޼ҵ�
	static void method3() {
	
	/*
	this.field1 = 10; //������ ���� 
	this.method(); //������ ����
	��������1 : ���� �޼ҵ� �������� this�� ����� �� ����
	*/	
	// field1 = 10;
	// method1();
	// ��������2:  ���� �޼ҵ� �������� �ν��Ͻ� �ʵ� �� �޼ҵ带 ����� �� ����
		
	field2 = 10;
	method2();	
	}
}
