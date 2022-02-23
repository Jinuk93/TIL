package chapter05_참조타입;

public class Null_GarbageCollector {

	public static void main(String[] args) {
		
		String hobby = null;
		
		String name = "김진욱";
		name = null;
		// String 타입의 name이란 변수에 "김진욱"의 객체를 생성했다
		//하지만 String타입의 name이란 객체를 null값을 줌으로써, 무효화 시켜버렸다
		//따라서, 자바에선 이 친구를 쓰레기로 생각해서 가비지컬렉터(Garbage Collector)를 통해
		//메모리에서 자동으로 삭제시킨다
		
		//따라서, 메모리에서 삭제를 시키고 싶으면 "객체에 null값을 저장시키면 된다"
	}
}
