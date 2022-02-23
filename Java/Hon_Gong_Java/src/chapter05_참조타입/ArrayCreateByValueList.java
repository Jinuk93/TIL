package chapter05_참조타입;

public class ArrayCreateByValueList {

	public static void main(String[] args) {

	//예제1
/*	int[] scores;
	scores = new int[] { 83, 93, 87 };
	//혹은 int[] scores = { 83, 93, 87 };
	
	int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
	System.out.println("총합 : " + sum1);*/
	
	//예제0
	int[] scores = {100, 200, 300};
	int sum3 = 0;
	for (int i=0; i<3; i++) {
		sum3 += scores[i];
	}
	System.out.println("예제0번 총합 : " + sum3);
	
	//예제2
	int sum2 = add ( new int[] {83, 90, 87} );
	System.out.println("총합 : " + sum2);
	}

	private static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
	}
}
