package chapter04;

public class Break {

	public static void main(String[] args) {
		
		while(true) { //true일 때만 계속해서 반복한다
			
			int num = (int)(Math.random() * 6) + 1; // (1)int(정수)타입의 숫자를 6까지 나오게 하되,
			
			System.out.println(num);
			
				if(num == 6) {
					break; // (2)6이 나오면 반복문을 중단시킨다
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
