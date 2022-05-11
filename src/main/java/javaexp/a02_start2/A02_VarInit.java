package javaexp.a02_start2;

public class A02_VarInit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 변수의 선언
		int num01;
		// 2. 변수의 초기화
		num01 = 0; // 숫자형 데이터는 초기값을 0으로 설정한다.
		System.out.println("숫자 num01 : " + num01);
		// 3. 초기화되지 않은 변수 사용
		int num02;
//		System.out.println("숫자 num02 : " + num02);
		num02 = 25;
		num01 = num02;
		System.out.println("숫자 num02 : " + num02);
		/*
		# 프로그래밍 수업 시 주의사항.
		1. 수업 중 에러나는 부분은 일단, pass 하고 수업에 집중한다.
		 - 절대 에러를 잡느라 수업을 듣지 않는 비효율적인 진행을 하지 말자.
		 - 수업 끝나거나 쉬는 시간에 처리를 하자.
		2. 에러는 일단 본인이 해결하려고 노력해야 한다.
		 - 1시간 이상 걸릴 시에는 옆 동료나 담임에게 요청한다.
		3. 연습은 과제 이외에 찾아보기도 하면서 충분히 연습한다.
		 */

	}

}
