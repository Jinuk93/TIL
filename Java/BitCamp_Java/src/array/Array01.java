package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array01 {

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("배열 크기 입력 : ");
		int size = Integer.parseInt(br.readLine());
		int[] ar = new int[size];
		int sum = 0;
		int max;
		
		for(int i=0; i<ar.length; i++) {
			System.out.println("ar["+i+"]  입력 : ");
			ar[i] = Integer.parseInt(br.readLine());
			
			sum += ar[i];
		}//for문
		
		//최대값
		max = ar[0];
		for(int i=1; i<ar.length; i++) {
			if(ar[i] > max) max = ar[i];
		}
	
		for(int a : ar) { //확장형 for문
			System.out.print(a+" ");
		}//for문
		System.out.println();
		System.out.println("합 = " + sum);
	}
}
