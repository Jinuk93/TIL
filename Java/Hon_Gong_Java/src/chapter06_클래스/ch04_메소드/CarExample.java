package chapter06_Ŭ����.ch04_�޼ҵ�;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5); //CarŬ������ setGase() �޼ҵ� ȣ��
						 
		boolean gasState = myCar.isLeftGas(); //Car Ŭ������ isLeftGas() �޼ҵ� ȣ��
		if(gasState) {
			System.out.println("����մϴ�. ");
			myCar.run(); //Car�� run() �޼ҵ� ȣ��
		}
		if(myCar.isLeftGas()) { //Car Ŭ������ isLeftGas() �޼ҵ� ȣ��
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		}else {
			System.out.println("gas�� �����ϼ���.");
		}
	}
}
