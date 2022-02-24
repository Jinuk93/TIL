package chapter06_클래스.ch04_메소드;

public class Car {

	//필드
	int gas;
	
	//생성자
	
	//메소드
	void setGas(int gas) {
		this.gas = gas; //필드에 있는 명과 메소드 괄호()안의 매개변수명이 같으므로, this 작성
	}
	
	
	boolean isLeftGas() { //boolean형의 리턴타입 truen/false를 리턴값을 갖기 위해함
		if(gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
			// false를 return => 가스가 0이라면 여기에서 종료된다
		}
			System.out.println("gas가 있습니다");
			return true; //true를 return
		}//return값이 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 return

		void run() {
			while(true) {
				if(gas > 0) {
					System.out.println("달립니다.(gas잔량 : " + gas + ")");
					gas -= 1;
				}else {
					System.out.println("멈춥니다. (gas잔량 : " + gas + ")");
					return; //메소드 강제종료
				}
			}
		}
}
