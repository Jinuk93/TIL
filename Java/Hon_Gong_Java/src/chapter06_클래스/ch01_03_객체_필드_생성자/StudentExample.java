package chapter06_클래스.ch01_03_객체_필드_생성자;

public class StudentExample {

	public static void main(String[] args) {
		
		//클래스로부터 객체를 생성
		//클래스 변수 = new 클래
		
		StudentExample s1 = new StudentExample(); //StudentExample이라는 클래스로부터 s1 객체를 생성
		System.out.println("s1 변수가 Student 객체를 참조합니다");
		
		StudentExample s2 = new StudentExample(); //StudentExample이라는 클래스로부터 s2 객체를 생성
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다");
	}
}
/*
 StudentExample  라는 클래스(class)는 하나지만, new 연산자를 사용한 만큼의 "객체"가 생성된다
 이러한 s1, s2들은 StudentExample  클래스의 인스턴스다
 s1과 s2가 참조하는 StudentExample 라는 객체는 완전히 독립된 서로다른 "객체"이다
 */