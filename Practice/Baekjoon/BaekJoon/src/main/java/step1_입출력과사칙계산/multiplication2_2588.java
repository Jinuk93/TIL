/*
제목
곱셈

문제
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.

(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

출력
첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다. 
*/

package step1_입출력과사칙계산;

import java.util.Scanner;

//이 문제는 답을 그대로 가져왔다. 차근차근 생각해보고 직접 쳐봅시다!
//우선 문제의 뜻이 무엇인지부터 생각해봅시다

public class multiplication2_2588 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String one = sc.nextLine();
        String two = sc.nextLine();
 
        int t1 = Integer.parseInt(two.substring(2));
        int t10 = Integer.parseInt(two.substring(1,2));
        int t100 = Integer.parseInt(two.substring(0,1));        
        
        int o = Integer.parseInt(one);        
        
        System.out.println(o*t1);
        System.out.println(o*t10);
        System.out.println(o*t100);
 
        System.out.println(((o*t100)*100)+((o*t10)*10)+(o*t1));
    }
}