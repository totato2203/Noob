package javaexp.a06_class;

public class A08_MethodReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드의 리턴값 처리
		1. 메서드의 기본 구성
			리턴유형, 메서드명(매개변수){
				return 리턴값;
			}
		2. 리턴유형을 실제 리턴값의 데이터유형을 선언하고,
			해당 메서드가 호출되었을 때, 다르 변수에 할당 할 수 있는 데이터 유형을 말한다.
		3. 리턴값이 없는 기능메서드의 경우, 리턴유형을 void로 선언한다.
			ex) void setNumber(){
			
			}
			void printInfo(){
			System.out.println("출력처리(리턴값 필요 없음)")};
		 */
		MethodReturn mr = new MethodReturn();
		System.out.println("리턴한 값 : " + mr.callStr());
		String name = mr.callStr(); // 문자열을 리턴했기에 다른 합당한 유형으로 선언하면 할당할 수 있다.
		System.out.println("리턴한 값2 : " + mr.callInt());
		System.out.println("리턴한 값3 : " + (mr.callInt() + 30));
		int num01 = mr.callInt2();
		System.out.println("리턴한 값4 : " + num01);
		mr.printData();
//		String str01 = mr.printData(); 리턴 유형이 없는 void는 다른 데이터에 할당할 수 없다.
		// ex) BuyProduct 클래스를 선언하고,
		//		getProdName(), getProdPrice(), getProdCnt()를 메서드를 통해서
		//		물건명, 가격(정수), 개수(정수)를 리턴하여 main()에서 출력되고 변수에 할당되게 하세요.
		BuyProduct bp = new BuyProduct();
		System.out.println(bp.getProdName());
		System.out.println(bp.getProdPrice());
		System.out.println(bp.getProdCnt());
		System.out.println((bp.getProdPrice() * bp.getProdCnt()));

	}

}
class MethodReturn{
	String callStr() {
		return "홍길동";
	}
	int callInt() {
		return 25;
	}
	int callInt2() {
		int num01 = 30;
		return num01;
	}
	void printData() {
		System.out.println("출력 처리 시 리턴값이 필요 없음(void)");
	}
}
class BuyProduct{
	String getProdName(){
		return "사과";
	}
	int getProdPrice() {
		return 2000;
	}
	int getProdCnt() {
		return 3;
	}
}