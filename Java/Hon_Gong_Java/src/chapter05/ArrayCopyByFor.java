package chapter05;

public class ArrayCopyByFor {

	public static void main(String[] args) {
		
		int[] oldIntArray = { 1, 2, 3 }; //���� �����Ͱ� ������ִ� �迭
		int[] newIntArray = new int[5]; //���� �����͸� ���� �迭
		
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ", ");
		}
	}
}
/*
 * old(����) �迭�� ������ ����(��)�� 3���ε�, new(���Ӱ�) ���� �迭�� ���� �迭�� �����͸� �޾� 1,2,3�� �߰��Ǿ���.
 * ������, new �迭�� ���̸� 5���� �����Ǿ����Ƿ�, "0"�� �����Ͱ��� 2�� �� �߰��Ǿ���
 */