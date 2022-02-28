package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 x의 y승을 구하시오
 단, x의 값이 0이 입력되면 프로그램을 종료하시오
 */
public class ForTest8 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int x,y;
	
		for(;;) {
			System.out.println("x값 입력 : ");
			x = Integer.parseInt(br.readLine());
			if(x == 0 ) break;  
			
			System.out.println("y값 입력 : ");
			y = Integer.parseInt(br.readLine());
		}//for
		System.out.println("프로그램을 종료합니다");
		
	
	}
}
