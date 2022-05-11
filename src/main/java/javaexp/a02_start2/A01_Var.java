package javaexp.a02_start2;

public class A01_Var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 변수란?
		1. 하나의 값을 저장할 수 있는 메모리 공간
		2. 변수의 선언
			타입 변수이름;
		ctrl + m (옆 창 열고 닫기)
		 */
		int age; // 정수형 데이터를 할당할 수 있는 age라는 변수 선언
		double height; // 실수형 데이터 height라는 변수 선언

		/*
		# 변수명 선언의 규칙
		1. 특수문자는 $, _만 허용된다. 
		 */
		int $name = 25; // $는 사용 가능
//		int #num01 = 30; // 특수문자 사용 불가 ctrl + / (주석 단축키)
//		2. 숫자로 시작할 수 없다.
//		int 25num01 = 30; // 불가능
		int n25 = 40;
		int num02 = 50;
//		3. 대소문자는 구분한다.
		int N01 = 25;
		int n01 = 30; // N01과 n01은 다른 변수
		// ex) 객체지향 프로그램의 가독성을 위한 규칙(에러는 발생하지 않지만 변경과 코드 해석에서 지켜야할 규칙)
		//		1. 클래스명 / 객체명 대문자로 시작해서 선언하여야 한다.
		//		2. 참조변수, 일반변수, 메서드명은 소문자로 시작한다.
		//		3. 합성어로 된 변수는 구분자를 대문자나 _로 설정한다.
		//			setName(), getName(), prg_name
		//		4. 상수나 static 변수는 전체 대문자로 선언한다.
//		4. 자바 예약어는 사용할 수 없다.
//			break, for, if, class 등 내부적으로 예약되어 있는 키워드를 변수로 사용할 수 없다.
//		int break = 50;
//		int for = 50;
		int break10 = 34; //예약어 뒤에 접미어로 숫자나 다른 문자를 사용하는 것은 가능
	}

}
