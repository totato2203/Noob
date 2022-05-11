package javaexp.a04_process;

public class A05_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			# 출력할 내용에 대한 연습
				System.out.println() : 줄바꿈 없이 처리
				System.out.print() : 줄바꿈 없이 처리
				System.out.print("\t") : 탭간격 처리
				System.out.print("\n") : 줄바꿈 처리
				* 특정한 형식으로 데이터 출력하세요
		 */
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println("안녕하세요!" + cnt);
		}
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println(cnt + ", ");
		}
		System.out.println();
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println(cnt + "\t");
		}
		System.out.println();
		

//		# 아래와 같이 여러가지 형식으로 화면에 출력하세요
//		ex1) 1 + 2 + ... + 10 + 를 출력하세요
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.print(cnt + " + ");
		}
		System.out.println();

//		ex2) ^^ 100 ^^ 99 ^^ ... ^^ 90 을 출력하세요
		for(int cnt = 100; cnt >= 90; cnt--) {
			System.out.print("^^ " + cnt);
		}
		System.out.println();
		
//		ex3) 구구단에서 숫자 5를 활용하여 다음과 같이 나타내세요
//			5	*	1	=	5
//			5	*	2	=	10
//			5	*	3	=	15
//			...
//			5	*	9	=	45
		for(int cnt = 1; cnt <= 9; cnt++) {
			System.out.println(5 + " * " + cnt + " = " + (cnt*5));
		}
//		ex4) 1) I love you ! ♥ ♥ 2) I love you ! ♥ ♥ 3) I love you ! ♥ ♥ 4) I love you ! ♥ ♥
		for(int cnt = 1; cnt <= 4; cnt++) {
			System.out.print(cnt + ") I love you ! ♥ ♥ ");
		}
		System.out.println();

//		ex5) 100 - 90 - 80 - 70 - 60 - 50
		for(int cnt = 100; cnt >= 50; cnt -= 10) {
			System.out.print(cnt + " - ");
		}
		System.out.println();

		/*
		# 반복문 밖의 외부 변수를 통한 처리
			1) 지정된 변수 설정과 반복문의 변수와 혼합하여 출력하기
				ex) 구구단의 단수, 1~10까지의 반복변수, 혼합하여 구구단 출력
			2) 누적 데이터 처리
				합산할 변수 선언
				변수를 통해 누적 처리 데이터 출력
		 */
		int sum = 0; // 반복문 밖의 전역변수 설정
		// cf) 지역변수는 {} 안에서 선언한 변수를 말한다.
		for(int cnt=1; cnt<=10; cnt++) {
			int sum01 = 0; // 반복문 안에서 선언되어 초기화가 되는 지역변수
			sum01 += cnt;
			sum += cnt;
			System.out.print("합산1 : " + sum01 + "\t\t");
			System.out.println("합산2 : " + sum);
		}
		int grade = 8;
		for(int cnt = 1; cnt<=9; cnt++) {
			System.out.println(grade + " X " + cnt + " = " + (grade * cnt));
		}
		// 김밥 한 개당 2500으로 첫 번째 날 째는 1개를 판매, 두 번째 날짜는 2개를 판매... 10일 동안 판매된 김밥을 출력하고 판매액을 프로그램적으로 구하세요
		int kimbap = 2500;
		int totSell = 0;
		for(int date = 1; date<=10; date++) {
			int dateTot = kimbap * date;
			System.out.println(date + "째날 판매 금액 : " + dateTot);
			totSell += dateTot;
		}
		System.out.println("총 판매 금액 : " + totSell);
		// 지역 변수 : 반복문 안에 선언 초기화되는 변수 - date, dateTot
		// 전역 변수 : 반복문 밖에서 반복문 안에 데이터를 처리할 수 있는 변수 - kimbap, totSell
		// # 아래 내용을 지역 변수와 전역 변수를 활용하여 처리하세요
		// ex1) 1~20까지 합을 출력하세요
		int sum1 = 0;
		for(int cnt = 1; cnt<=20; cnt++) {
			sum1 += cnt;
		}
		System.out.println("1~20까지 합 : " + sum1);
		// ex2) 2 + 4 + 6 + ... + 10 + 의 합을 출력하세요
		int sum02 = 0;
		for(int cnt = 2; cnt <= 10; cnt += 2) {
			System.out.print(cnt + " + ");
			sum02 += cnt;
		}
		System.out.println("의 합 : " + sum02);
		// ex3) 짜장면의 가격이 5000일 때, 1~10 그릇까지 가격을 출력하세요
		//		@@그릇 @@@원
		int jjPrice = 5000;
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println(cnt + "그릇 " + (jjPrice * cnt) + "원");
		}
		
	}

}
