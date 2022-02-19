package chapter04;

//중첩for문을 이용한 "구구단"
public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		
		for(int x=2; x<=9; x++) { //바깥쪽 for문, 2부터시작해서 9까지 반복(2단부터 9단까지)
		
			 System.out.println("*** " + x + "단 ***" );
		
				for(int y=1; y<=9; y++) { //중첩 for문
				
					System.out.println(x + "x" + y + "=" + (x*y));
			}
		}
	}
}
/*
  설명 ** for(int x=2; x<=9; x++) 문이 한 번 돌 때 마다 (바깥쪽 for문이 한 번 실행될때마다) for(int
  y=1; y<=9; y++)의 중첩for문은 y가 1에서부터 9번까지 "9번 반복"을 합니다.
  
  즉 x=2일 때, y는 1~9까지를 반복하면서 
  *** 2단 *** 
  2x1=2
  2x2=4
  2x3=6
  2x4=8
  2x5=10
  2x6=12
  2x7=14
  2x8=16
  2x9=18
  이런식의 결과가 나타나게 됩니다.
 */