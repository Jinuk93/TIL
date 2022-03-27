package step1_입출력과_사칙계산;
/*
문제
두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다. 
*/
import java.util.Scanner;

public class A_div_B_1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); //오답구간
		int B = sc.nextInt(); //오답구간
		
		System.out.println(A/B);
	}
}
