package chapter06_Ŭ����.ch04_�޼ҵ�;

public class Car {

	//�ʵ�
	int gas;
	
	//������
	
	//�޼ҵ�
	void setGas(int gas) {
		this.gas = gas; //�ʵ忡 �ִ� ��� �޼ҵ� ��ȣ()���� �Ű��������� �����Ƿ�, this �ۼ�
	}
	
	
	boolean isLeftGas() { //boolean���� ����Ÿ�� truen/false�� ���ϰ��� ���� ������
		if(gas == 0) {
			System.out.println("gas�� �����ϴ�");
			return false;
			// false�� return => ������ 0�̶�� ���⿡�� ����ȴ�
		}
			System.out.println("gas�� �ֽ��ϴ�");
			return true; //true�� return
		}//return���� boolean�� �޼ҵ�� gas �ʵ尪�� 0�̸� false��, 0�� �ƴϸ� true�� return

		void run() {
			while(true) {
				if(gas > 0) {
					System.out.println("�޸��ϴ�.(gas�ܷ� : " + gas + ")");
					gas -= 1;
				}else {
					System.out.println("����ϴ�. (gas�ܷ� : " + gas + ")");
					return; //�޼ҵ� ��������
				}
			}
		}
}
