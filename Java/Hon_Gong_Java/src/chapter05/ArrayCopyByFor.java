package chapter05;

public class ArrayCopyByFor {

	public static void main(String[] args) {
		
		int[] oldIntArray = { 1, 2, 3 }; //기존 데이터가 저장되있는 배열
		int[] newIntArray = new int[5]; //새로 데이터를 넣을 배열
		
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ", ");
		}
	}
}
/*
 * old(기존) 배열은 데이터 길이(값)이 3개인데, new(새롭게) 만든 배열은 기존 배열의 데이터를 받아 1,2,3이 추가되었다.
 * 하지만, new 배열은 길이를 5개로 지정되었으므로, "0"의 데이터값이 2개 더 추가되었다
 */