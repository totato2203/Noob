package javaexp.a06_class;

public class A09_MethodParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드의 매개변수 처리
		1. 메서드는 매개변수의 유형에 따라 데이터를 객체에 전달하고,
			전달된 데이터에 따라 데이터를 처리할 수 있다.
		2. 유형
			리턴타입 메서드명(매개변수1, 매개변수2, ...){
				매개변수로 전달된 데이터 처리..
			}
		3. 메서드 오버로딩 규칙
			1) 외부에서 호출할 때, 식별이 가능하게 호출하면 선언이 가능하다.
			2) 기준 : 
				- 매개변수 개수
				- 타입이 다르면 개수가 동일하여도 가능하다.
				- 개수가 동일하고 타입이
		 */
		MethodParamExp mp = new MethodParamExp();
		mp.call();
		mp.call(25);
		mp.call("문자열");
		mp.call(25, 30);
		mp.call("ㅇㄹ", 30);
		mp.call(25, "ㅇㄹ");
		// ex) GoTravel 클래스를 선언하고 오버로딩의 원칙에 따라 메서드를 선언하되 리턴유형 : void
		//		1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
		//		2) setTarget : 비용을 선언하는 내용 처리
		//		3) setTarget : 목적지와 비용을 순서를 다르게 선언하여 출력
		GoTravel gt = new GoTravel();
		gt.setTarget("서울");
		gt.setTarget("경기", "서울");
		gt.setTarget("경기", "강원", "서울");
		gt.setTarget(100000);
		gt.setTarget("서울", 1000);
		gt.setTarget(10000, "경기");

	}

}
class GoTravel{
	void setTarget(String dst01) {
		System.out.println("목적지 1 : " + dst01);
	}
	void setTarget(String dst01, String dst02) {
		System.out.println("목적지 1 : " + dst01 + ", 목적지 2 : " + dst02);
	}
	void setTarget(String dst01, String dst02, String dst03) {
		System.out.println("목적지 1 : " + dst01 + ", 목적지 2 : " + dst02 + ", 목적지 3 : " + dst03);
	}
	void setTarget(int price) {
		System.out.println("비용 : " + price + "원");
	}
	void setTarget(String dst, int price) {
		System.out.println("목적지 : " + dst + ", 비용 : " + price + "원");
	}
	void setTarget(int price, String dst) {
		System.out.println("비용 : " + price + "원, 목적지 : " + dst);
	}
}
class MethodParamExp{
	void call() {
		System.out.println("매개변수 없는 메서드");
	}
	void call(int num01) {
		System.out.println("매개변수 1개 메서드(숫자)");
	}
	void call(String str) {
		System.out.println("매개변수 1개 메서드(문자열)");
	}
	void call(int num01, int num02) {
		System.out.println("매개변수 2개 메서드(숫자, 숫자)");
	}
	void call(String str, int num02) {
		System.out.println("매개변수 2개 메서드(순서 : 문자열, 숫자)");
	}
	void call(int num02, String str) {
		System.out.println("매개변수 2개 메서드(순서 : 숫자, 문자열)");
	}
}