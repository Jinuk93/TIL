package chapter04;

//��øfor���� �̿��� "������"
public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		
		for(int x=2; x<=9; x++) { //�ٱ��� for��, 2���ͽ����ؼ� 9���� �ݺ�(2�ܺ��� 9�ܱ���)
		
			 System.out.println("*** " + x + "�� ***" );
		
				for(int y=1; y<=9; y++) { //��ø for��
				
					System.out.println(x + "x" + y + "=" + (x*y));
			}
		}
	}
}
/*
  ���� ** for(int x=2; x<=9; x++) ���� �� �� �� �� ���� (�ٱ��� for���� �� �� ����ɶ�����) for(int
  y=1; y<=9; y++)�� ��øfor���� y�� 1�������� 9������ "9�� �ݺ�"�� �մϴ�.
  
  �� x=2�� ��, y�� 1~9������ �ݺ��ϸ鼭 
  *** 2�� *** 
  2x1=2
  2x2=4
  2x3=6
  2x4=8
  2x5=10
  2x6=12
  2x7=14
  2x8=16
  2x9=18
  �̷����� ����� ��Ÿ���� �˴ϴ�.
 */