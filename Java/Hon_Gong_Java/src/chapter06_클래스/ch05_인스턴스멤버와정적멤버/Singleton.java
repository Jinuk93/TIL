package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class Singleton {
	private static Singleton singleton = new Singleton();
	//무언가 읽는방법이 헷갈리면 private static을 제외한, 문장을 보면 필드생성인것을 알 수 있다
	
	private Singleton() {
		
	}
	static Singleton getInstance() {
		return singleton;
	}
}
