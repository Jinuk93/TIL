package chapter04;

public class WhileSumFrom1To100Example {

	public static void main(String[] args) {
		
		int sum = 0;
		int i = 1;
		
		while(i<100) { //i�� 100���� �϶�����, �ݺ��ض�
			sum += i; //sum �������ٰ� i�� ���� ����(+)���� ������Ų��
			i++; //i�� �������� �ʼ�
		}
		
		System.out.println("1~" + (i-1) + "������ �� : " + sum);
	}
}
