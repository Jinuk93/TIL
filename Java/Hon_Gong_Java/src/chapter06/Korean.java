package chapter06;

public class Korean {

	//필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	//생성자
	public Korean(String n, String s) {
		name = n;
		ssn = s;
	/*
	만약, 생성자가
	public Korean(String name, String ssn) {
	}
	이처럼 필드명들과 public Korean 안의 매개변수명들과 같을 경우
	
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		  /필드명/  /매개변수/
	}
	이렇게 this를 통해 "나 자신"을 알리는 this를 쓴다
	그리고 가독성을 위해, 일반적으로 필드와 동일한 매개변수(명)을 쓴다
	
	그리고 this를 필드명 앞에 'this.name = name'을 쓰는 이유는
	매개변수의 우선순위가 더 높기 때문에, 순위가 낮은 필드명 앞에 붙인다
	 */	
	
	}
}
