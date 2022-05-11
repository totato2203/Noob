package javaexp.a03_calcu;

public class A01_CalcuStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 연산자와 연산식
		1. 연산이란?
			데이터를 처리하여 결과를 산출하는 것을 말한다.
		2. 연산자(operations)
			연산에 사용되는 표시나 기호를 말한다.
			+, -, *(곱), /, %(나머지), =, ...
		3. 피연산자(operand)
			연산 대상이 되는 데이터(리터럴, 변수)
			num01, 25, num02
		4. 연산식
			연산자와 피연산자를 이용하여 연산의 과정을 기술하는 것
			num01 + num02
			sum = num01 * num02
			연산자 : =, *
			피연산자 : sum, num01, num02
			연산식 : 연산자와 피연산자를 혼합하여 식을 만들어가는 것
		*/
		
		int num01 = 25; // 연산자 =(대입), 피연산자 num01에 리터럴 데이터 25를 할당
		int num02 = 5;
		System.out.println(num01 + " + " + num02 + " = " + (num01 + num02));
		System.out.println(num01 + " - " + num02 + " = " + (num01 - num02));
		System.out.println(num01 + " * " + num02 + " = " + (num01 * num02));
		System.out.println(num01 + " / " + num02 + " = " + (num01 / num02));
		System.out.println(num01 + " % " + num02 + " = " + (num01 % num02));
		
		/*
		ex) 사칙연산자 처리 연습예제
		1. 사과와 바나나의 가격을 설정해서 총 비용을 연산자, 피연산자를 통한 연산식으로 결과를 출력하세요.
		2. 사과의 가격에 구매한 개수를 처리하여 결과를 출력
		3. 바나나의 구매 개수를 설정하고, 사과의 총비용과 바나나의 총비용과의 차이를 구하세요.
		4. 곰돌이 3마리가 빵 20개를 똑같이 먹고 남은 나머지 개수를 위 연산식을 통해 출력하세요.
		*/
		
		int applePrice = 2000, bananaPrice = 1000;
		System.out.println("사과값 + 바나나값 : " + applePrice + " + " + bananaPrice + " = " + (applePrice + bananaPrice));

		int appleNum = 5;
		System.out.println("사과값 * 개수 : " + applePrice + " * " + appleNum + " = " + (applePrice * appleNum));
		
		int bananaNum = 8;
		System.out.println("사과 총비용 - 바나나 총비용 : " + (applePrice * appleNum) + " - " + (bananaPrice * bananaNum) + " = " + ((applePrice * appleNum) - (bananaPrice * bananaNum)));
		
		int bearNum = 3, breadNum = 20;
		System.out.println("나머지 빵 개수 : " + breadNum + " % " + bearNum + " = " + (breadNum%bearNum));
	}

}
