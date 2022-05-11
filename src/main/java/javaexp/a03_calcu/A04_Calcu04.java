package javaexp.a03_calcu;

public class A04_Calcu04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 증감
		1. 증가 또는 감소를 처리할 때 활용된다.
			기본적으로 1씩 증가 또는 감소를 한다.
		2. 반복문에 주로 활용된다.
		3. 형식
			변수명++, 변수명--
			++변수명, --변수명
		*/
		int num01 = 1;
		int num02 = 10;
		System.out.println(num01++); // 증가는 했지만 다음 프로세스에 적용
		System.out.println(num01++);
		System.out.println(num01++);
		System.out.println(num01);
		System.out.println(++num01);
		System.out.println(++num01);
		System.out.println(++num01);
		System.out.println(++num01);
		System.out.println(num01);
		
		System.out.println(num02--);
		System.out.println(num02--);
		System.out.println(num02--);
		System.out.println(num02--);
		System.out.println(num02--);
		System.out.println(num02);
		System.out.println(--num02);
		System.out.println(--num02);
		System.out.println(--num02);
		
		// ex) 구매하는 김밥의 개수를 선언하고, 1씩 증가하여
		//		 김밥의 단가(2500)
		//		김밥 1개 구매 2500
		//		김밥 2개 구매 5000
		//		김밥 3개 구매 7500
		//		김밥 4개 구매 10000
		//		김밥 5개 구매 12500
		
		int cnt = 0;
		int price = 2500;
		System.out.println("김밥 " + ++cnt + "개 구매 " + cnt * price);
		System.out.println("김밥 " + ++cnt + "개 구매 " + cnt * price);
		System.out.println("김밥 " + ++cnt + "개 구매 " + cnt * price);
		System.out.println("김밥 " + ++cnt + "개 구매 " + cnt * price);
		System.out.println("김밥 " + ++cnt + "개 구매 " + cnt * price);
		
	}

}
