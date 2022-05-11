package javaexp.a07_multiObj;

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
		System.out.println("a07_multiObj 패키지 클래스의 객체 : " + new A05_Person());
		javaexp.a07_multiObj.A05_Person pk01 = new javaexp.a07_multiObj.A05_Person(); 
		System.out.println("a08_access 패키지 클래스의 객체 : " + pk01);
		// a07_multiObj 패키지 클래스의 객체 : javaexp.a07_multiObj.A05_Person@5305068a
		// a08_access 패키지 클래스의 객체 : javaexp.a07_multiObj.A05_Person@1f32e575

	}

}
