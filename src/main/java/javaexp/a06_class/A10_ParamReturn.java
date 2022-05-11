package javaexp.a06_class;

public class A10_ParamReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드의 매개변수와 리턴값 처리 연습
		1. 객체의 기능메서드는 매개변수를 통해 입력되고,
			리턴값을 통해서 데이터의 최종결과를 받을 수 있다.
		2. 두 개의 구성요소에 대한 입/출력에 대한 종합 예제를 해보자.
		 */
		Calcu c1 = new Calcu();
		System.out.println();
		System.out.println(c1.plus(25, 30));
		System.out.println();
		int tot = c1.plus(40, 30);
		System.out.println();
		System.out.println("변수할당 : " + tot);
		// ex) Product05 클래스를 선언하고, buy() 메서드를 통해서 물건 가격과 물건 개수를
		//		입력받아서 내용을 출력하고 총계를 리턴하여 출력하세요.
		//		메서드는 2번 호출하여 결과값을 출력
		Product06 pd = new Product06();
		int pay = pd.buy(2000, 3);
		System.out.println("총계 : " + pay);
		String buyInfo = pd.buy("사과", 2000, 3);
		System.out.println(buyInfo);
		Calcu c2 = new Calcu();
		String plusResult = c2.calc("+", 5, 7);
		System.out.println(plusResult);
		String minusResult = c2.calc01("-", 100, 8);
		System.out.println(minusResult);
		String result = c2.calc01("+", 20,  12);
		System.out.println(result);

	}

}
//	같은 패키지 안에 동일한 클래스 있을 시 에러 나니, 클래스명 변경해주세요
class Product06{
	int buy(int price, int cnt) {
		System.out.println("가격 : " + price + ", 개수 : " + cnt);
		return price * cnt;
	}
	String buy(String name, int price, int cnt) {
		// 입력받은 내용을 선언된 메서드를 통해서 전달하고, 그 결과를 받아서 처리
		int tot = buy(price, cnt);
		return "구매 정보 : " + name + ", 총비용 : " + tot;
	}
}
class Calcu{
	int plus(int num01, int num02) {
		System.out.println("입력값 num01 : " + num01);
		System.out.println("입력값 num02 : " + num02);
		return num01 + num02;
	}
	int minus(int num01, int num02) {
		System.out.println("입력값 num01 : " + num01);
		System.out.println("입력값 num02 : " + num02);
		return num01 - num02;
	}
	// ex) plus의 매개변수 연산자(+, -, ..), 첫번째숫자, 두번째숫자
	//		리턴 유형으로 문자열로 처리하여 변수에 할당하여 출력하세요
	String calc(String icon, int num01, int num02) {
		int result = plus(num01, num02);
		return num01 + icon + (num02) + "=" + result;
	}
	String calc01(String cal, int num01, int num02) {
		String ret = "";
		ret = num01 + cal + num02;
		if(cal.equals("+")) {
			ret += "=" + plus(num01, num02);
		}
		if(cal.equals("-")) {
			ret += "=" + minus(num01, num02);
		}
		return ret;
	}
}