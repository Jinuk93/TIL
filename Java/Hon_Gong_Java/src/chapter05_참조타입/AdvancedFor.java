package chapter05_참조타입;

public class AdvancedFor {

	public static void main(String[] args) {
		
		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0;
		
	  //for(int i=0; i<scores.length; i++) 일반적인 for문의 형식
		
		for(int score : scores) {
			//sum = sum + scores;
			//sum = sum + scores; // sum += scores; 누적 합산
		}
		//확장for문으로 총합 구하기 
		System.out.println("점수 총합 = " + sum);
		
		//총합을 먼저구하고, 그에 따른 평균값 구하기
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균 = " + avg);
	}
}
