package chapter06_Ŭ����.ch01_03_��ü_�ʵ�_������;

public class StudentExample {

	public static void main(String[] args) {
		
		//Ŭ�����κ��� ��ü�� ����
		//Ŭ���� ���� = new Ŭ��
		
		StudentExample s1 = new StudentExample(); //StudentExample�̶�� Ŭ�����κ��� s1 ��ü�� ����
		System.out.println("s1 ������ Student ��ü�� �����մϴ�");
		
		StudentExample s2 = new StudentExample(); //StudentExample�̶�� Ŭ�����κ��� s2 ��ü�� ����
		System.out.println("s2 ������ �� �ٸ� Student ��ü�� �����մϴ�");
	}
}
/*
 StudentExample  ��� Ŭ����(class)�� �ϳ�����, new �����ڸ� ����� ��ŭ�� "��ü"�� �����ȴ�
 �̷��� s1, s2���� StudentExample  Ŭ������ �ν��Ͻ���
 s1�� s2�� �����ϴ� StudentExample ��� ��ü�� ������ ������ ���δٸ� "��ü"�̴�
 */