package chapter06_클래스.ch01_03_객체_필드_생성자;

public class OverloadingCarExample {

	public static void main(String[] args) {
		System.out.println("시작");
		System.out.println();
		
		OverloadingCar car = new OverloadingCar();
		System.out.println("car.company : " + car.company);
		System.out.println();
		System.out.println("**************");
				
		OverloadingCar car1 = new OverloadingCar();
		System.out.println("car1.company : " + car1.company);
		System.out.println("car1.company : " + car1.model);
		System.out.println();
		System.out.println("**************");
		
		OverloadingCar car2 = new OverloadingCar();
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.company : " + car2.model);
		System.out.println("car2.company : " + car2.color);
		System.out.println();
		System.out.println("**************");
			
		OverloadingCar car3 = new OverloadingCar();
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.company : " + car3.model);
		System.out.println("car3.company : " + car3.color);
		System.out.println("car3.company : " + car3.maxspeed);
		System.out.println();
	}
}
