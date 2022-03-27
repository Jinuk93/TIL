/*
문제
두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 

입력
두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)

출력
첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
*/
package step1_입출력과_사칙계산;

import java.util.Scanner;

public class 사칙연산_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
//int타입을 쓴 이유는 문제의 '출력결과'를 보면, int타입이기 때문이다
//문제와 출력해야되는 값을 잘 봐두어야한다
		System.out.println(A+B);
		System.out.println(A-B);
		System.out.println(A*B);
		System.out.println(A/B);
		System.out.println(A%B);
// '%'는 '모듈러'라고 읽는다
	}
}
