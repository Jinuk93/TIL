package chapter04;

public class Swtich {

	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 6) + 1; //�ֻ��� ��ȣ �ϳ��̱�
		
		//Math.random() �޼ҵ��� Ư¡
		//0<=x<1 ������ ����(�Ҽ����ڸ������ִ¼�)�� �����Ѵ�
		//������ ��ȯ�ϱ� ����, ����Ÿ�Ժ�ȯ (int)�� �Ѵ�
		// *6�� �ϸ� �̸����� ���� 5���� ��µǹǷ�, +1�� ���� 6���� ��µǰԲ� �Ѵ�
		
		switch(num) {
			case 1:
				System.out.println("1���� ���Խ��ϴ�");
				break;
			case 2:
				System.out.println("2���� ���Խ��ϴ�");
				break;
			case 3:
				System.out.println("3���� ���Խ��ϴ�");
				break;
			case 4:
				System.out.println("4���� ���Խ��ϴ�");
				break;
			case 5:
				System.out.println("5���� ���Խ��ϴ�");
				break;
			case 6:
				System.out.println("6���� ���Խ��ϴ�");
				break;
				
		}
	}
}
