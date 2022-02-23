package chapter04_조건문과반복문;

public class Lotto {

	public static void main(String[] args) {
	 /* 
	 가장 큰 for문 안에 while문을 넣어 놓은 형태이다.
	 while문 안에
	 if문으로 0인 경우 골라내기와
	 for문으로 이전 로또숫자와 같은 숫자 골라내기
	 의 기능을 만들었다.
	 */
	 
		//코드 시작
		int Lotto[] = new int[6]; // 로또 번호 받을 배열
		int Random = 0; // Random숫자 담을 변수
		
		//최종 완성된 로또 번호
		for(int i =0; i<6; i++) {
			
		//로또 번호 생성 반복문
		while(true) {
			Random = (int)(Math.random()*100 %45);
			System.out.printf("%d", Random); //숫자 확인차 넣어뒀다
		
			if(Random ==0 ) { // 숫자 "0"이 나올 경우
				continue; // 다시해!
			}
			for(int j=0; j<5; j++) {
				if(Random == Lotto[i]) //중복 숫자일 경우
					continue; // 다시해!
			}
			
		//모든 조건을 만족했다면
			break;
		}
		//모든 검사를 마쳤다면 로또배열에 넣자
			Lotto[i] = Random;
		}
		System.out.println("");
		for(int k=0; k<6; k++) 
			System.out.printf("%d", Lotto[k]);

	}
}
