package javaexp.a03_calcu;

public class A03_Calcu03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 대입연산자
		1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당이 된다.
		*/
		int num01 = 25;
		int num02; int num03; int num04; // 선언
		num02 = num03 = num04 = 5; // 동일한 데이터를 한 번에 할당
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		
		/*
		2. +=, -=, *=, /=, %=
		 기존 변수에서 누적하여 다시 데이터를 할당할 때 활용된다.
		 2 이상 증가하거나 감소하는 등 연산식을 처리할 때 활용된다.
		*/
		num01 = num01 + 5;
		System.out.println("기존 데이터에 합산한 값 : " + num01);
		num01 += 5;
		System.out.println("누적 합산값 : " + num01);
		num01 -= 5;
		System.out.println("누적 뺀값 : " + num01);
		
		/*
		ex) 변수 cnt01~cnt05에 데이터 5를 한 번에 선언과 할다을 하고,
			누적 증감연산자에 의해서 cnt01~cnt05, 2, 3, 4, 5, 6 증가 처리하여 출력하세요.
		*/
		
		int cnt01, cnt02, cnt03, cnt04, cnt05; // 정수형 데이터 선언
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 = 5;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 2;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 3;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 4;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 5;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 6;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 -= 6;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 -= 5;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 -= 4;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 -= 3;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 -= 2;
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
	}

}
