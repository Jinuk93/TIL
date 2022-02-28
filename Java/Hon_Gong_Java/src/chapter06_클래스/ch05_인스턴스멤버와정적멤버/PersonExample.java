package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class PersonExample {

	public static void main(String[] args) {
		Person p1 = new Person("123456-123456", "홍길동");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.name = "홍길동";
	}
}
