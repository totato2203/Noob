package javaexp.a04_process;

public class A07_break_continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 반복문에서 조건과 함께하는 break와 continue문
		1. 반복문 안에서 특정 조건일 때, break를 처리하면 반복문의 범위와 상관없이 중단이 된다.
			(for문, while문, do while문 다 활용된다.)
		 */
		for(int cnt = 1; cnt < 100; cnt++) {
			if(cnt == 20) break;
			System.out.println(cnt); // cnt == 20일 때, 윗줄의 break로 인해 중단되어서 20은 출력되지 않음
		}
		/*
		2. 반복문 안에서 특정 조건일 때, continue를 쓰며 해당 반복 step을
			pass by(넘어가고) 처리되고 그 다음 반복을 수행하게 된다.
		 */
		for(int cnt = 2; cnt <= 9; cnt++) {
			if(cnt == 5) continue;
			System.out.println(cnt + "단"); // cnt == 5일 때, 윗줄의 continue로 인해 pass by 되어서 5단은 출력되지 않음
		}
		// ex1) 구구단의 단수를 전역변수로 선언하여 해당 단수의 1~9까지 곱한 값을 처리하되
		//		X7일 때, 프로세스가 중단되게 처리하세요
		int danNum = 5;
		for(int cnt = 1; cnt <= 9; cnt++) {
			if(cnt == 7) break;
			System.out.println(danNum + " * " + cnt + " = " + (danNum * cnt));
		}
		// ex2) 매월 인터넷 요금이 32000 정도 나온다. 1~12월까지 요금 내용을 출력하되
		//		5월은 출장을 가서 정지를 시켰다. 아래의 형식으로 출력하세요
		//		월	요금		누적요금
		//		1월	32000	32000
		//		2월	32000	64000
		//		... // 5월은 정지
		//		12월	32000	...
		int price = 32000, tot = 0;
		System.out.println("월\t요금\t누적요금");
		for(int cnt = 1; cnt <= 12; cnt++) {
			if(cnt == 5) continue;
			tot += price;
			System.out.println(cnt + "월\t" + price + "\t" + tot);
		}

	}

}
