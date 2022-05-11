package javaexp.a06_class;

public class A14_ObjectFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoSeller au01 = new AutoSeller("음료", "콜라", 1200);
		AutoSeller au02 = new AutoSeller("제과", "토리토스", 1100);
		AutoSeller au03 = new AutoSeller("일상용품", "물티슈", 3000);
		au01.display();
		au01.input(100);
		au01.input(100);
		au01.input(500);
		au01.input(1000);
		au01.input(2000);
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("잔액 : " + au01.backMoney());
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		au02.display();
		au03.display();

	}

}
/*
# class의 모든 구성요소를 이용해서 객체 활용하기. (자동판매기) 
*/
class AutoSeller{
	String title;
	String prod;
	int price;
	int inputMoney;
	// 판매기의 종류, 판매물건과 가격
	AutoSeller(String title, String prod, int price){
		this.title = title;
		this.prod = prod;
		this.price = price;
	}
	void display() {
		System.out.println(title + " 자동 판매기!! (물건을 선택하세요)");
		System.out.println("1. " + prod + "(" + price + "원)");
	}
	void input(int inputMoney) {
		System.out.println("입금된 금액 : " + inputMoney + "원");
		// 입력된 금액을 누적 처리
		this.inputMoney += inputMoney;
		displayRestMoney(); // 정의된 기능메서드 호출
	}
	void displayRestMoney() {
		System.out.println(title + "자판기에 총 금액 : " + this.inputMoney + "원");

	}
	// 번호 선택과 최종 물건 리턴
	String choiceProd(int num) {
		String ret = "물건 없음!!";
		if(num == 1) {
			if(price <= inputMoney){	// 구매할 제품의 가격보다 잔액이 남아 있을 때..
				System.out.println("구매 제품이 나옵니다.");
				ret = prod; // 적절할 때, 해당 물건으로 리턴처리
				inputMoney -= price; // 잔액차감
				displayRestMoney();
			}else {
				System.out.println("잔액이 부족합니다!!");
			}
			
		}
		return ret;
	}
	// 잔액리턴
	int backMoney() {
		int reM = inputMoney; // 지역변수를 활용해서 잔액 0을 리턴 처리
		System.out.println("# 잔액 리턴 처리 #");
		inputMoney = 0;
		displayRestMoney();
		return inputMoney;
	}
}