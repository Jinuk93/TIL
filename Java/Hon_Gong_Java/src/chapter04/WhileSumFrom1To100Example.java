package chapter04;

public class WhileSumFrom1To100Example {

	public static void main(String[] args) {
		
		int sum = 0;
		int i = 1;
		
		while(i<100) { //i가 100이하 일때까지, 반복해라
			sum += i; //sum 변수에다가 i의 값을 더한(+)값을 누적시킨다
			i++; //i의 증감식은 필수
		}
		
		System.out.println("1~" + (i-1) + "까지의 합 : " + sum);
	}
}
