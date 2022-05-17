package javaexp.z01_homework;

public class A0516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-16
//		[1단계:개념] 1. api 클래스의 주요기능과 java.lang.* 패키지의 특징을 기술하세요
		
		// api 클래스는 자바에서 기본적으로 제공하는 라이브러리로, 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음이다.
		// // 쉽게 api를 찾아 이용할 수 있도록 문서화하여 웹 브라우저로 볼 수 있게 html 페이지로 작성되었다.
		
		// java.lang.* 패키지는 자바프로그램의 기본적인 클래스를 담은 패키지로서
		// 여기 포함된 클래스와 인터페이스는 import 없이 사용할 수 있다.
		
//		[1단계:활용] 2. charAt() 활용 - 알파벳A~Z까지 있는 문자열 배열에서 임의의 문자 4개를 추출하여 출력하세요.
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int cnt = 1; cnt <= 4; cnt++) {
			System.out.print(abc.charAt((int)(Math.random() * 26)));
		}
		System.out.println();
		
		// 다른 방법
		System.out.println((int)'A');
		System.out.println((int)'Z'); // 65~90 : 코드 범위
		char c[] = new char[26];
		int idx = 0;
		for(int code = 65; code <= 90; code++) {
			c[idx++] = (char)code;
		}
		// char[] 배열을 String 생성자에 할당하면 문자열이 만들어진다.
		String str = new String(c);
		System.out.println(str);
		for(int cnt = 1; cnt <= 4; cnt++) {
			int rIdx = (int)(Math.random() * 26); // 0~25
			System.out.println(str.charAt(rIdx));
		}
		
//		[1단계:활용] 3. 과일명 5개가 나열된 문자열에서 해당 특정 과일명의 index위치를 추출하여 출력하세요.
		String fruit = "apple banana orange kiwi melon";
		System.out.println(fruit.indexOf("apple"));
		System.out.println(fruit.indexOf("banana"));
		System.out.println(fruit.indexOf("orange"));
		System.out.println(fruit.indexOf("kiwi"));
		System.out.println(fruit.indexOf("melon"));
		
//		[1단계:활용] 4. 좋아하는 운동선수 3명이 나열된 문자열에서 length()와 charAt() 반복문을 활용하여, 한글자씩을 탭간격으로
//		      출력하세요.
		String player = "박지성 안정환 손흥민";
		System.out.println(player.length());
		for(int cnt = 0; cnt <= player.length() - 1; cnt++) {
			if(cnt % 4 == 3) {
				System.out.print(player.charAt(cnt) + "\n");
			}else {
				System.out.print(player.charAt(cnt) + "\t");
			}
		}
		System.out.println();
		
//		[1단계:활용] 5. 회원명단을 ^로 구분하여 나열한 문자열을 선언하고, 이것을 배열로 처리한 후,
//		      특정회원이 있는지 여부를 확인하는 처리를 해보자. // ^로 구분이 안 돼서 @로 바꿨습니다.
		String names = "홍길동@김길동@최길동@박길동@이길동";
		String[] nArry = names.split("@");
		for(String na : nArry) {
			System.out.println(na);
		}
		for(int cnt = 0; cnt <= nArry.length - 1; cnt++) { // "홍길동" 여부 확인
			System.out.println(nArry[cnt].indexOf("홍길동"));
			if(nArry[cnt].indexOf("홍길동") != -1) {
				System.out.println("nArry[" + cnt + "]에 홍길동 존재");
			}
		}
		for(int cnt = 0; cnt <= nArry.length - 1; cnt++) { // "최길동" 여부 확인
			System.out.println(nArry[cnt].indexOf("최길동"));
			if(nArry[cnt].indexOf("최길동") != -1) {
				System.out.println("nArry[" + cnt + "]에 최길동 존재");
			}
		}
		
//		[3단계:설치] 6. 오늘 진행한 DB설치 내용을 ppt로 작성하여 캡쳐한 내용을 과제와 함께 전달하세요.

	}

}
