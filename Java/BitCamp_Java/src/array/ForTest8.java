package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 x�� y���� ���Ͻÿ�
 ��, x�� ���� 0�� �ԷµǸ� ���α׷��� �����Ͻÿ�
 */
public class ForTest8 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int x,y;
	
		for(;;) {
			System.out.println("x�� �Է� : ");
			x = Integer.parseInt(br.readLine());
			if(x == 0 ) break;  
			
			System.out.println("y�� �Է� : ");
			y = Integer.parseInt(br.readLine());
		}//for
		System.out.println("���α׷��� �����մϴ�");
		
	
	}
}
