package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class Person {

	final String nation = "korea";
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
