/*
주차장 관리프로그램

[실행결과]
******************
1. 입차
2. 출차
3. 리스트
4. 종료
******************
메뉴 : 4
프로그램을 종료합니다.

1번인 경우
위치 입력 : 3 *배열 2번방에 위치해있다는것
=> sysout : 3위치에 입차 or 이미 주차되어있습니다(if문)

2번인 경우
위치 입력 : 4
4위치에 출차 / 주차되어 있지 않습니다

3번인 경우
1위치 : false
2위치 : false
3위치 : false
4위치 : false
5위치 : false
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		boolean[] ar = new boolean[5];
		int index;
		
		//4번 종료 입력전까지 계속 반복해야하므로, while문 사용
		//while문안에 계속 돌아가는(종료직전까지 출력되는) 프린트물을 작성
		while(true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("	1. 입차");
			System.out.println("	2. 출차");
			System.out.println("	3. 리스트");
			System.out.println("	4. 종료");
			System.out.println("********************");
			System.out.println(" 메뉴 : ");
			num = Integer.parseInt(br.readLine());
			if(num == 4) break;

			if(num == 1) { //입차
				System.out.println("위치 입력 : ");
				index = Integer.parseInt(br.readLine());
				
				if(ar[index-1] == true)  //if(ar[index-1]) 이렇게 쓴다
					System.out.println("이미 주차되어있습니다.");
				else
					System.out.println(index + "위치에 입차");
					ar[index-1] = true;
			}
			else if(num == 2) { //출차
				System.out.println("위치 입력 : ");
				index = Integer.parseInt(br.readLine());
				
				if(ar[index-1] == true) {
					System.out.println(index + "위치에 출차");
					ar[index-1] = false;
				}else {
					System.out.println("주차되어 있지않습니다");
				}
			
			}else if(num == 3) { //위치
				for(int i=0; i<ar.length; i++) {
					System.out.println((i+1) + "위치 : " + ar[i]);
				}//for
			}else System.out.println("1~4번까지만 입력하세요.");
		
		}//while
		System.out.println("프로그램을 종료합니다");
		
	}
}

