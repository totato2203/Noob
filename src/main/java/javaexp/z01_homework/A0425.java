package javaexp.z01_homework;

public class A0425 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# 아래 과제 결과를 카톡 text 복사해서 메시지로 전달 : 양현수
1. 코드 처리
	1) 자바의 컴파일과 실행과정을 A0425.java를 통해서 설명하세요.
	2) 변수명을 아래와 같이 선언하고 출력하세요.
		문자열 선언 방법 : (찾아보기)
		정수형/실수형 선언과 할당
		이름, 나이, 키 변수를 선언하여 출력하세요.
2. ppt 자료 작성 : 파일로
	1) 자바 기본 환경 설정 ppt 자료로 작성하여 전달해주세요.
		c:\a02_javaexp
			jdk 설치
			workspace 설치
			eclipse



1) 자바의 컴파일과 실행과정

	자바 소스파일(*.java) --(컴파일러(javac.exe))-> 바이트코드 파일(*.class) --(자바 가상기계(java.exe))-> 기계어 -> 실행
*/

// 	2) 변수명 선언
		
		String name = "전장호";
		int age = 26;
		double height = 181.9;
		
		System.out.println("이름 : " + name + ", 나이 : " + age + "세, 키 : " + height + "cm");
	}

}
