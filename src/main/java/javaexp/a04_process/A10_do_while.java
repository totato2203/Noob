package javaexp.a04_process;

import java.util.Scanner;

public class A10_do_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# do while문
		1. while문 형식에서 반복 조건 상관없이 반드시 1번은 수행되어야 할 경우에 사용된다.
		2. 기본 형식
			do{
				1번 이상 반복할 구문
			}while(반복 조건);
		 */
		int cnt = 1;
		do {
			System.out.println("카운트 : " + cnt);
			cnt++;
		}while(cnt <= 10);
		System.out.println("반복문 종료");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("온라인 쇼핑몰에 오신 것을 환영합니다.");
		String chProd = "# 선택한 물건 #\n";
		String pname = "";
		do {
			// 일단, while 조건에 상관 없이 한 번은 출력 처리한다.
			chProd += pname + "\n";
			System.out.println("물건을 확인하시고 선택하세요! 완료 시 Q를 입력하세요");
			pname = sc.nextLine();
		}while(!pname.equals("Q")); // pname이 Q가 아닐 때 반복
		System.out.println(chProd);
		
		

	}

}
