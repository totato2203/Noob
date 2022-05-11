package javaexp.z01_homework;

public class A0426 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	[1단계:개념] 1. 변수의 초기화에 대하여, 예제를 통하여 기술하세요
		int a1 = 0; // 변수 a에 데이터 0을 할당하여 초기화
//	[1단계:개념] 2. 기본데이터유형이 할당되는 jvm 메모리와 해당 유형 종류를 크기에 따라 기술하세요.
		// 정수형-문자(문자열 아님, 정수형에 포함), 실수형, 문자(문자열 X), 논리(boolean)의 데이터 유형이 있고,
		// 정수형은 byte(1byte), short(2byte), int(4byte), long(8byte)와 문자열을 다타내는 char(2byte)로 크기에 따라 나눌 수 있다.

		// stack(기본데이터유형, 객체의 heap주소값), heap(객체가 할당)
		
//	[1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
		int b1 = 2100000000, b2 = 1500000000;
		long b3 = (long)b1 + (long)b2;
		System.out.println("b1 + b2 = " + b3);
//	[1단계:개념] 4. 150라는 데이터를 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
		// short부터 할당이 가능하다. short보다 작은 byte는 1byte로 128 미만의 데이터까지만 할당할 수 있기 때문이다.
//	[2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
				// 0 : 숫자, '0' : 문자, "0" : 문자열
		char a = 'a', A = 'A', z = 'z', Z = 'Z', c1 = '0', c2 = '9';
		System.out.println(a + "의 유니코드 : " + (int)a);
		System.out.println(A + "의 유니코드 : " + (int)A);
		System.out.println(z + "의 유니코드 : " + (int)z);
		System.out.println(Z + "의 유니코드 : " + (int)Z);
		// 알파벳의 코드값 범위는 대문자 65~90, 소문자 97~122이다.
		System.out.println(c1 + "의 코드값 : " + (int)c1);
		System.out.println(c2 + "의 코드값 : " + (int)c2);
		// 문자 0부터 9까지 범위의 코드값 범위는 48~57이다.
//	[1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
//			자동(묵시적)타입변환 : promotion
		byte d1 = 25;
		double d2 = d1;
		System.out.println("자동타입변환 전 : " + d1);
		System.out.println("자동타입변환 후 : " + d2);
		// 작은 데이터형에서 큰 데이터형으로 변환될 때는 추가 코드 없이 자동으로 변환된다.
		
//			강제(명시적)타입변환 : casting
		double d3 = 25.38;
		byte d4 = (byte)d3;
		System.out.println("강제타입변환(큰 데이터형에서 작은 데이터형으로) : " + d4);
		int d5 = 10, d6 = 3;
		double d7 = d5 / (double)d6;
		System.out.println("강제타입변환(작은 데이터형에서 큰 데이터형으로) : " + d7);
		// ()을 활용하여 특정한 데이터 유형으로 변경이 명시적으로 필요할 때 사용한다.
		// 큰 데이터형에서 작은 데이터형으로 변환되는 경우, 작은 데이터형으로 변환되는 경우로 나뉜다.

//	[1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
//      소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
		int juice = 500, glass = 3;
		int result1 = juice / glass;
		System.out.println("소수점 이하 처리된 경우 : " + result1);
		double result2 = juice / (double)glass;
		System.out.println("소수점 이하 처리되지 않은 경우 : " + result2);
//	[1단계:개념] 8. 연산자, 피연산자, 연산식의 개념을 기본예제를 통해서 구분하여, 설명하세요.
		// 연산자 : 연산에 사용되는 표시나 기호 (+, -, *, /, %, ...)
		// 피연산자 : 연산 대상이 되는 데이터(리터럴, 변수) (num01, 24, num02)
		// 연산식 : 연산자와 피연산자를 이용하여 연산의 과정을 기술하는 것
		/*
			sum = num01 * num02
			연산자 : =, *
			피연산자 : sum, num01, num02
			연산식 : 연산자와 피연산자를 혼합하여 식을 만들어가는 것
		*/
		
//	[1단계:코드] 9. 일일 가계부 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요
//      날짜   지출구분   내용  입금액    출금액  잔액
//      4/1   입금     용돈   30000         30000
//      4/1   출금     점심           6000  24000
		int deposit = 30000, withdraw = 6000, balance = 0;
		balance += 30000;
		System.out.println("날짜	지출구분	내용	입금액	출금액	잔액");
		System.out.println("4/1	입금	용돈	" + deposit + "\t\t" + balance);
		balance -= 6000;
		System.out.println("4/1	출금	점심	" + "\t" + withdraw + "\t" + balance);
		// System.out.print() : 줄바꿈 없이 처리
		// \t : 탭간격, \n : 줄바꿈 처리
		
//	[1단계:코드] 10. 변수 선언하고 이를 이용하여 타율(안타/타석)을 계산하여 출력하세요.
		int hit = 3, taseok = 7;
		double tayul = hit / (double)taseok;
		System.out.println("타율 : " + tayul);
		
//	[1단계:코드] 11. 삼각형의 면적을 구하는 공식을 이용하여 밑면과 높이로 출력하세요.
		int baseline = 5, height = 7;
		System.out.println("삼각형의 면적 = " + (double)(baseline * height)/2);
		
//	[1단계:코드] 12. 대입연산자와 연산자의 진행방향의 차이점을 기본 예제를 통해 설명하세요.
		// 대입연산자는 오른쪽의 데이터를 왼쪽에 대입하여 할당하는 연산자이고, 모든 연산자의 연산이 끝난 마지막에 진행된다.
		int cnt01, cnt02, cnt03, cnt04, cnt05;
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 = 5; // 대입연산자는 오른쪽의 데이터를 왼쪽에 대입하여 할당한다.
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 += 3; // 연산자의 연산(+)이 끝난 마지막에 데이터를 대입하여 할당한다.
		System.out.println(cnt01 + " " + cnt02 + " " + cnt03 + " " + cnt04 + " " + cnt05);
	}

}
