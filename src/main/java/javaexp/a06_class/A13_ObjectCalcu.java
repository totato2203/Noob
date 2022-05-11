package javaexp.a06_class;

public class A13_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드를 통해서 기능 처리하는 반복문 예제
		1. 기능 메서드를 통해 반복 처리하는 로직 처리
		 */
		Counter ct = new Counter();
		ct.setData(100, 105);
		int sum = ct.showCount(); // 제목 + 반복문
		System.out.println(sum); // 615
		System.out.println(ct.showCount()); // 제목 + 반복문 + 615(리턴값 : tot)
		ct.setData(1, 100);
		int sum01 = ct.showCount();
		System.out.println(sum01);
		
		// ex) CalcuPay 필드 : 확인할구매개수최대값, 단가
		//				메서드 : inputData()
		//						searchLoop()
		//							단가 @@@ @@개 @@@
		//							단가 @@@ @@개 @@@
		//							단가 @@@ @@개 @@@
		CalcuPay cp = new CalcuPay();
		cp.inputData(10, 2000);
		cp.searchLoop();
		
	}
	

}
class CalcuPay{
	int max;
	int price;
	void inputData(int max, int price) {
		this.max = max;
		this.price = price;
		System.out.println("기본 데이터 입력");
		System.out.println("최대 개수 : " + max);
		System.out.println("구매 단가 : " + price);
	}
	void searchLoop() {
		System.out.println("# 어떤 물건 1~" + max + "개에 대한 총 구매액 #");
		for(int cnt = 1; cnt <= max; cnt++) {
			System.out.println("단가 : " + price + "원 " + cnt + "개, 총 구매액 : " + (price * cnt));
		}
	}
}
class Counter{
	int from;
	int to;
	void setData(int from, int to){
		this.from = from;
		this.to = to;
	}
	int showCount() {
		int tot = 0;
		System.out.println("# " + from + "에서부터 " + to + "까지 #");
		for(int cnt = from; cnt <= to; cnt++) {
			System.out.print(cnt + ", ");
			tot += cnt;
		}
		System.out.println();
		return tot;
	}
}