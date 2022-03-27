package step1_입출력과_사칙계산;

import java.util.Scanner;
//이 문제는 답을 그대로 가져왔다. 차근차근 생각해보고 직접 쳐봅시다!
//우선 문제의 뜻이 무엇인지부터 생각해봅시다
public class A_multiply2_B_2588 {
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