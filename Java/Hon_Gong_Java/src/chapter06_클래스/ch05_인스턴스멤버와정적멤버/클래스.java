package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class 클래스 {

	//정적필드
	private static 클래스 singleton = new 클래스();
	//클래스 외부에서 호출하지 못하도록 private 접근 제한자 사용
	
	//생성자
	private 클래스() { 
	//클래스 내부에서는 위의 new 클래스를 통해 만든 클래스 생성자를 만들 수 있다
		
	}
	//정적메소드
	static 클래스 getInstance() {
		return singleton;
	}
}
