package javaexp.a02_start2;

public class A07_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 데이터의 형변환
		1. 데이터 타입을 다른 타입으로 변환하는 것을 말한다.
			byte ==> int, int ==> double
		2. 종류
			자동(묵시적)타입변환 : promotion
			강제(명시적)타입변환 : casting
		3. 자동(묵시적)타입변환
			작은 데이터 유형에서 큰 데이터 유형으로 변환할 때는
			추가 코드 없이 자동으로 할당이 된다.
		*/
		
		byte num01 = 25;
		int num02 = 25 + num01;
		int num03 = 30;
		double num04 = num03;
		System.out.println("# 묵시적 형변환 결과 #");
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		int num = 25;
		String nameCode = "홍길동" + 25 + num;
		System.out.println(nameCode);
		// 앞에 문자열에 영향을 받아서 묵시적으로 숫자가 문자열로 변환되어 25 ==> "25"
		// 출력 : 홍길동2525
		
		/*
		4. 명시적 형변환
			1) ()을 활용하여 특정한 데이터 유형으로 변경이 명시적으로 필요할 때 사용한다.
			2) 유형
				큰 데이터형 ==> 작은 데이터형
					int num01 = (int)25.27;
				작은 데이터형 ==> 큰 데이터형
					int num02 = 10;
					int num03 = 3;
					double result = num02 / num03;   3
					double result = num02 / (double)num03;   3.3333
				cf) 자바에서는 정수형과 정수형의 나눗셈은 정수형으로만 나온다.
				실수형까지 처리하려면 연산하는 피연산자가 하나는 실수여야 한다.
		*/
		double db1Num = 25.27;
		int num05 = (int)db1Num;
		System.out.println("casting한 결과 : " + num05);
		int num06 = 10;
		int num07 = 3;
		// 정수형/정수형 ==> 정수형 : 소숫점 이하의 값이 나오지 않는다.
		// 정수형/실수형 ==> 실수형 : 소숫점 이하의 값이 처리가 된다.
		double result = num06 / num07;
		System.out.println("연산결과값 : " + result);
		double result2 = num06 / (double)num07;
		System.out.println("연산결과값 : " + result2);
		
		/*
		ex1) byte형으로 구매한 사과의 개수와 바나나의 개수를 합산하여 특정한 데이터 유형에 할당하세요!
		ex2) 소고기 600g을 7등분을 하되 소수점 이하의 결과까지 출력 처리하세요.
		*/
		
		byte apple = 100, banana = 100;
		// +(연산자)가 들어가면 결과값이 int 유형이 필요로 한다.
		int sum1 = apple + banana;
		// 합산 결과를 해당 유형에 맞게 casting하여 int ==> byte로 처리되게 한다.
		byte sum2 = (byte)(apple + banana);
		System.out.println("결과값1 : " + apple + ", " + banana + ", " + sum1);
		System.out.println("결과값2 : " + apple + ", " + banana + ", " + sum2);
		
		int beef = 600, div = 7;
		double result0 = beef / (double)div;
		System.out.println(beef + "g 소고기를 " + div + "등분 하면 : " + result0 + "g이 됩니다.");

	}

}
