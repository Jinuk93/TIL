package chapter04_���ǹ����ݺ���;

public class Lotto {

	public static void main(String[] args) {
	 /* 
	 ���� ū for�� �ȿ� while���� �־� ���� �����̴�.
	 while�� �ȿ�
	 if������ 0�� ��� ��󳻱��
	 for������ ���� �ζǼ��ڿ� ���� ���� ��󳻱�
	 �� ����� �������.
	 */
	 
		//�ڵ� ����
		int Lotto[] = new int[6]; // �ζ� ��ȣ ���� �迭
		int Random = 0; // Random���� ���� ����
		
		//���� �ϼ��� �ζ� ��ȣ
		for(int i =0; i<6; i++) {
			
		//�ζ� ��ȣ ���� �ݺ���
		while(true) {
			Random = (int)(Math.random()*100 %45);
			System.out.printf("%d", Random); //���� Ȯ���� �־�״�
		
			if(Random ==0 ) { // ���� "0"�� ���� ���
				continue; // �ٽ���!
			}
			for(int j=0; j<5; j++) {
				if(Random == Lotto[i]) //�ߺ� ������ ���
					continue; // �ٽ���!
			}
			
		//��� ������ �����ߴٸ�
			break;
		}
		//��� �˻縦 ���ƴٸ� �ζǹ迭�� ����
			Lotto[i] = Random;
		}
		System.out.println("");
		for(int k=0; k<6; k++) 
			System.out.printf("%d", Lotto[k]);

	}
}
