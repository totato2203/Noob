package javaexp.a03_calcu;

public class A02_Calcu02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 연산자의 종류
		1. 산술연산자
		2. 부호연산
			피연산자에 부호 기호(+, -)를 붙여 양수와 음수를 처리하는 것을 말한다.
		*/
		int num01 = 25;
		int num02 = 5;
		int num03 = -num02;
		int num04 = -num03;
		// num02에 부호 기호 -를 붙여 처리하였다.
		System.out.println(num01 + num02);
		System.out.println(num01 + num03);
		System.out.println("num03의 값 : " + num03);
		System.out.println("부호 기호 -(음수)에 다시 -(음수)를 붙인 경우 : " + num04);
		
		/*
		3. 문자열의 + 연산자
			+는 숫자형 데이터의 경우 합산을 처리하지만, 문자열 데이터인 경우 문자열과 문자열을 이어주는 역할을 한다.
			1) 문자열1 + 문자열2 ==> 문자열1문자열2
			2) 숫자1 + 숫자2 + 문자열 ==> 숫자합산문자열
			3) 문자열 + 숫자1 + 숫자2 ==> 문자열숫자1숫자2
		*/
		String str1 = "안녕하세요";
		String str2 = " 반갑습니다.";
		System.out.println(str1 + str2 + " 문자열을 이어줌");
		int num05 = 5, num06 = 7;
		// 출력처리나 연산식에서 숫자형 연산자가 먼저 나오면 연산을 처리해준다. 그 다음 문자열에 대한 처리로 연결 처리한다.
		System.out.println(num05 + num06 + str1 + str2);
		
		// 형변환 중에 숫자를 숫자형 문자열로 변환
		String chStr1 = "" + num05;
		String chStr2 = new Integer(num05).toString();
		// 형변환 중에 숫자형 문자열을 숫자로 변환
		int num07 = Integer.parseInt("25");
//		int num08 = Integer.parseInt("이십오"); // X 오류발생
		
		// 출력처리나 연산식에서 시작하는 데이터 유형이 문자열이면, 뒤에 나오는 데이터가 숫자형이라도
		// 모두 다 문자열로 자동형변환이 되어, 문자열로 취급되어 처리된다.
		// 5 ==> "5", 7 ==> "7", "5" + "7" ==> "57"
		System.out.println(str1 + str2 + num05 + num06);
		// 이 때, 정상적으로 문자열을 출력하면서, 숫자형 데이터를 연산하려면,
		// 최우선순위 연산식에서 사용하는 ()
		// cf) () : 소괄호, {} : 중괄호, [] : 대괄호
		System.out.println(str1 + str2 + (num05 + num06));
		
		/* 
		ex) 방어율 계산(9이닝(회)동안 피실점율) - 1이닝 동안 실점 5
			방어율 = (투수의 자책점 * 9)/이닝
		투수의 자책점 4점, 경기회수(이닝) 5, 방어율이 얼만지를 프로그램 상으로 출력하세요. (선언할 변수 : 자책점, 이닝, 방어율)
		 경기 회수(이닝수) : @@@
		 실점 : @@@
		 방어율 : @@@
		*/
		
		int inningCnt = 5, faultCnt = 4;
		double ERA = (faultCnt * 9) / (double)inningCnt;
		System.out.println("경기한 회수(이닝수) : " + inningCnt);
		System.out.println("실점 : " + faultCnt);
		System.out.println("방어율 : " + ERA);
	}

}
