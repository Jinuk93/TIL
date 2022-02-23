package chapter05_참조타입;

public class ArrayCreateByValueList2 {

	public static void main(String[] args) {
		
		int[] scores; 
		scores = new int[] {83, 90, 87}; 
		
		int sum1 = 0;
		
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("sum1 : " +sum1);
				
		
		int sum2 = add( new int[] {83,90,87});
		System.out.println("sum2 : " +sum2);
	}
		//add라는 메소드를 알아두기
	    private static int add(int[] scores) {
	    	int sum = 0;
	    	for(int i=0; i<3; i++) {
				sum += scores[i];
	    	}
	    	return sum;
	}
}
