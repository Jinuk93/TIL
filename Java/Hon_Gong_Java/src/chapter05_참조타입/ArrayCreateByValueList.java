package chapter05_����Ÿ��;

public class ArrayCreateByValueList {

	public static void main(String[] args) {

	//����1
/*	int[] scores;
	scores = new int[] { 83, 93, 87 };
	//Ȥ�� int[] scores = { 83, 93, 87 };
	
	int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
	System.out.println("���� : " + sum1);*/
	
	//����0
	int[] scores = {100, 200, 300};
	int sum3 = 0;
	for (int i=0; i<3; i++) {
		sum3 += scores[i];
	}
	System.out.println("����0�� ���� : " + sum3);
	
	//����2
	int sum2 = add ( new int[] {83, 90, 87} );
	System.out.println("���� : " + sum2);
	}

	private static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
	}
}
