package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array01 {

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�迭 ũ�� �Է� : ");
		int size = Integer.parseInt(br.readLine());
		int[] ar = new int[size];
		int sum = 0;
		int max;
		
		for(int i=0; i<ar.length; i++) {
			System.out.println("ar["+i+"]  �Է� : ");
			ar[i] = Integer.parseInt(br.readLine());
			
			sum += ar[i];
		}//for��
		
		//�ִ밪
		max = ar[0];
		for(int i=1; i<ar.length; i++) {
			if(ar[i] > max) max = ar[i];
		}
	
		for(int a : ar) { //Ȯ���� for��
			System.out.print(a+" ");
		}//for��
		System.out.println();
		System.out.println("�� = " + sum);
	}
}
