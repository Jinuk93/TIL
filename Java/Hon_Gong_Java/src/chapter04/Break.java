package chapter04;

public class Break {

	public static void main(String[] args) {
		
		while(true) { //true�� ���� ����ؼ� �ݺ��Ѵ�
			
			int num = (int)(Math.random() * 6) + 1; // (1)int(����)Ÿ���� ���ڸ� 6���� ������ �ϵ�,
			
			System.out.println(num);
			
				if(num == 6) {
					break; // (2)6�� ������ �ݺ����� �ߴܽ�Ų��
			}
		}
		
		System.out.println("���α׷� ����");
	}
}
