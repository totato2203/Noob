package javaexp.a08_access;

import javaexp.a07_multiObj.A06_Food;
import javaexp.a07_multiObj.A07_Bus;

public class A01_Package {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 패키지란?
		1. 클래스를 기능별로 묶어서 그룹 이름을 붙여놓은 것을 말한다.
			1) 파일들을 관리하기 위해 사용하는 폴드(디렉토리)와 비슷한 개념이다.
			2) 패키지의 물리적인 형태는 파일 시스템의 폴드이다.
		2. 클래스 이름의 일부
			1) 클래스를 유일하게 만들어 주는 식별자
			2) 전체 클래스 이름 = 상위패키지.하위패키지.클래스
				ex) 현재 클래스명 : java.a08_access.A01_Package
			3) 클래스명이 같아도 패키지명이 다르면 다른 클래스로 취급한다.
				ex) 같은 클래스명이지만 다른 클래스로 취급
				javaexp.a07_multiObj.A01_Package
		3. 클래스 선언할 때, 패키지 결정
			1) 클래스 선언할 때 포함될 패키지 선언.
				package 패키지명
				class 클래스명
				ex)
					package javaexp.a08_access;
					public class A01_Package {
					
					}
			2) 클래스 파일(.class) 선언된 패키지와 동일한 폴더 안에서 동작
			3) 클래스 파일(.class) 다른 폴더 안에 넣으면 동작하지 않음.
		 */
		System.out.println("현재 패키지 클래스의 객체 : " + new A01_Package());
		// javaexp.a08_access.A01_Package@372f7a8d
		// 패키지명.클래스명@주소값
		// 동일한 클래스의 다른 패키지의 클래스를 객체로 사용할 때는 패키지명을 지정하여 호출한다.
		javaexp.a07_multiObj.A01_Package pk = new javaexp.a07_multiObj.A01_Package();
		System.out.println("다른 패키지 클래스의 객체 : " + pk);
		// ex) javaexp.a07_multiObj 안에 A05_Person.java 선언하고
		//		현재 패키지(javaexp.a08_access)에서 A05_Person.java 선언하여
		//		두 객체를 생성하고, 참조 변수의 주소값을 확인하세요.
		A05_Person p01 = new A05_Person();
		System.out.println(p01);
		System.out.println(p01.name);
		// 다른 패키지에 있는 클래스는 패키지명.클래스명으로 호출하여 사용할 수 있다.
		// # 같은 클래스명을 호출하는 곳(main()이나 다른 클래스 내부에서) 사용할 때
		// 반드시 패키지명으로 구분해서 사용하여야 한다.
		javaexp.a07_multiObj.A05_Person p02 = new javaexp.a07_multiObj.A05_Person();
		System.out.println(p02);
		System.out.println(p02.name);
		/*
		# 클래스명이 한 곳에서 동일한 것이 호출되지 않을 때는 패키지명을 생략가능하다.
		1. import 패키지명.클래스명으로 상단에 선언하고,
		2. public 접근제어자 범위 안에 있으면 객체를 사용할 수 있다.
		 */
		// import 하면 패키지명 없이도 사용 가능하다.
		// import javaexp.a07_multiObj.A06_Food;
		A06_Food f01 = new A06_Food();
		System.out.println(f01.name);
		
		// ex) 외부 패키지 javaexp.a07_multiObj에 A07_Bus를 선언하고
		//		import를 이용해서 객체의 참조값으로 호출하고,
		//		다시 필드값을 public을 선언하여 번호를 할당하고, 호출하여 출력하세요.
		// import javaexp.a07_multiObj.*;
		// 해당 패키지에 소속되어 있는 모든 클래스를 import하여 사용할 수 있다.
		
		A07_Bus b01 = new A07_Bus(); // import javaexp.a07_multiObj.A07_Bus;
		System.out.println(b01);
		System.out.println(b01.num);

	}

}
