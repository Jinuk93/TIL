package chapter06;

public class KoreanExample {

	public static void main(String[] args) {
		
		Korean k1 = new Korean("±èÁø¿í", "010-1234-5678");
		System.out.println("k1.nation : " + k1.nation);
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		
		Korean k2 = new Korean("±è¹Ùº¸", "010-1111-2222");
		System.out.println("k2.nation : " + k1.nation);
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
	}
}
