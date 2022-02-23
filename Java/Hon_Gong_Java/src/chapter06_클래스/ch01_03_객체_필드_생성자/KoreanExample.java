package chapter06_클래스.ch01_03_객체_필드_생성자;

public class KoreanExample {

	public static void main(String[] args) {
		
		Korean k1 = new Korean("김진욱", "010-1234-5678");
		System.out.println("k1.nation : " + k1.nation);
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		
		Korean k2 = new Korean("김바보", "010-1111-2222");
		System.out.println("k2.nation : " + k1.nation);
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
	}
}
