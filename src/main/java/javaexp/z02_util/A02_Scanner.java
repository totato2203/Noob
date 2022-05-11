package javaexp.z02_util;

import java.util.Scanner;

public class A02_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ex) Scanner 생성하고,
		 구매할 과일명을 입력하세요
		 구매할 과일 개수를 입력하세요
		 
		 과일명 @@@, 개수 @@개 출력
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구매할 과일명을 입력하세요!");
		String fruName = sc.nextLine();
		System.out.println("구매할 과일 개수를 입력하세요!");
//		String fruCnt = sc.nextLine(); // 연산이 필요한 경우 숫자형으로 입력받아야 한다.
		int fruCnt = sc.nextInt();
		// sc.nextFloat(); 실수형 데이터 입력
		System.out.println("과일명 : " + fruName + ", 개수 : " + fruCnt);

	}

}
