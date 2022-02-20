package chapter05;

public class MainStringArray2 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("값의 수가 부족합니다");
			
			System.exit(0); // 프로그램 강제종료
		}
		
		String sTrNum1 = args[0]; //첫번째 데이터 얻기
		String sTrNum2 = args[1]; //두번째 데이터 얻기
		
		int num1 = Integer.parseInt(sTrNum1);
		int num2 = Integer.parseInt(sTrNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
