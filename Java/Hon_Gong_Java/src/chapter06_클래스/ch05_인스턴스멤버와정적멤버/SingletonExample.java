package chapter06_클래스.ch05_인스턴스멤버와정적멤버;

public class SingletonExample {

	public static void main(String[] args) {
	/*
	 Singleton obj1 = new Singleton(); 
	 Singleton obj2 = new Singleton();
	 둘 다 컴파일 에러
	 */
	
	Singleton obj1 = Singleton.getInstance();
	Singleton obj2 = Singleton.getInstance();
	
	if(obj1 == obj2) { // == 는 번지를 비교하는 것이므로~
		System.out.println("같은 Singleton 객체입니다");
	}else {
		System.out.println("다른 Singleton 객체입니다");
		}
	}
}
