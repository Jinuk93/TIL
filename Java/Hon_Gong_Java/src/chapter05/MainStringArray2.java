package chapter05;

public class MainStringArray2 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("���� ���� �����մϴ�");
			
			System.exit(0); // ���α׷� ��������
		}
		
		String sTrNum1 = args[0]; //ù��° ������ ���
		String sTrNum2 = args[1]; //�ι�° ������ ���
		
		int num1 = Integer.parseInt(sTrNum1);
		int num2 = Integer.parseInt(sTrNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
