package chapter05_����Ÿ��;

public class AdvancedFor {

	public static void main(String[] args) {
		
		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0;
		
	  //for(int i=0; i<scores.length; i++) �Ϲ����� for���� ����
		
		for(int score : scores) {
			//sum = sum + scores;
			//sum = sum + scores; // sum += scores; ���� �ջ�
		}
		//Ȯ��for������ ���� ���ϱ� 
		System.out.println("���� ���� = " + sum);
		
		//������ �������ϰ�, �׿� ���� ��հ� ���ϱ�
		double avg = (double) sum / scores.length;
		System.out.println("���� ��� = " + avg);
	}
}
