package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

//정적 메소드 선언시, 주의할점
public class ClassName {

	//인스턴스 필드와 메소드
	int field;
	void method() {	
	}
	//정적 필드와 메소드
	static int field2;
	static void method2() {	
	}
	//정적 메소드
	static void method3() {
	
	/*
	this.field1 = 10; //컴파일 에러 
	this.method(); //컴파일 에러
	주의할점1 : 정적 메소드 내에서는 this를 사용할 수 없다
	*/	
	// field1 = 10;
	// method1();
	// 주의할점2:  정적 메소드 내에서는 인스턴스 필드 및 메소드를 사용할 수 없다
		
	field2 = 10;
	method2();	
	}
}
