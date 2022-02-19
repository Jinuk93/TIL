package chapter04;

public class Swtich {

	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 6) + 1; //주사위 번호 하나뽑기
		
		//Math.random() 메소드의 특징
		//0<=x<1 사이의 난수(소숫점자리까지있는수)를 생성한다
		//정수로 변환하기 위해, 강제타입변환 (int)를 한다
		// *6을 하면 미만으로 인해 5까지 출력되므로, +1을 통해 6까지 출력되게끔 한다
		
		switch(num) {
			case 1:
				System.out.println("1번이 나왔습니다");
				break;
			case 2:
				System.out.println("2번이 나왔습니다");
				break;
			case 3:
				System.out.println("3번이 나왔습니다");
				break;
			case 4:
				System.out.println("4번이 나왔습니다");
				break;
			case 5:
				System.out.println("5번이 나왔습니다");
				break;
			case 6:
				System.out.println("6번이 나왔습니다");
				break;
				
		}
	}
}
