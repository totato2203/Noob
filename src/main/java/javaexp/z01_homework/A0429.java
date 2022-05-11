package javaexp.z01_homework;

import java.util.Scanner;

public class A0429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-04-29
//		[1단계:개념] 1. Math.radom() 기능의 기본 임의 데이터 처리 공식을 예제를 통해 기술하세요.
		// 공식 : (int)(Math.random() * 경우의 수 + 시작수)
		// ex) 주사위 경우의 수 : 6, 시작수 : 1
		int dice = (int)(Math.random() * 6 + 1);
		System.out.println(dice);
		
//		[1단계:응용] 2. 학생 30명의 반에 영어점수(1~100)가 반복문으로 통해 임의로 처리되게 하세요.
//		      예) 번호 점수, 최하단에 반전체 평균을 출력하세요.
		int stdNum = 1;
		int tot = 0;
		for(;stdNum <= 30; stdNum++) {
			System.out.print(stdNum + "번 :\t");
			int engPoint = (int)(Math.random() * 101);
			System.out.print(engPoint + "\n");
			tot += engPoint;
		}
		double avg = tot / (double)stdNum;
		System.out.println("반 전체 평균 : " + avg);
		
//		[2단계:응용] 3. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여, 
//		       다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
		int player1 = (int)(Math.random() * 11), player2 = (int)(Math.random() * 11);
		String result1 = (player1 % 2 == 0) ? "짝" : "홀" ;
		String result2 = (player2 % 2 == 0) ? "짝" : "홀" ;
		System.out.println("1P의 홀짝 : " + result1);
		System.out.println("2P의 홀짝 : " + result2);
		System.out.println("승패 여부 : " + ((result1 == result2) ? "승" : "패"));

//		[1단계:응용] 4. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
		int red = (int)(Math.random() * 6 + 1);
		int blue = (int)(Math.random() * 6 + 1);
		String redResult;
		if(red > blue) {
			redResult = "승";
		}else if(red < blue) {
			redResult = "패";
		}else {
			redResult = "무";
		}
		System.out.println("홍팀 주사위 : " + red);
		System.out.println("청팀 주사위 : " + blue);
		System.out.println("홍팀의 결과 : " + redResult);
		
//		[1단계:개념] 5. while문의 기본 형식을 예제를 통해 설명하세요.
		int cnt = 1;
		System.out.println("# while문 시작 #");
		while(cnt <= 10) {	// 반복 조건
			System.out.println(cnt);
			cnt++;	// 반복 수행할 내용
		}
		System.out.println("# cnt가 10을 넘어가서 중단 #");
		System.out.println("cnt = : " + cnt); // cnt가 11이 되어서 중단
		
//		[1단계:응용] 6. while문을 이용해서 학생의 국어,영어,수학점수를 등록하고 총점과 평균을 
//		   출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
		Scanner sc = new Scanner(System.in);
		/*
		cnt = 0;
		int totPoint = 0;
		while(true) {
			System.out.print("국어 / 영어 / 수학 점수를 입력하세요 : ");
			int point = sc.nextInt();
			if(point == -1) break;
			System.out.println("국어 / 영어 / 수학 점수 : " + point + "점");
			totPoint += point;
			cnt++;
		}
		double avgPoint = totPoint / (double)cnt;
		System.out.println("총점 : " + totPoint + "점, 평균 : " + avgPoint);
		*/
		
//		[2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
//		   while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
//		   보다크다/보다 작다라는 hint로 맞추기를 진행할 수 있도록 한다. 최종적으로 몇번만에 맞추었는지 표기
		/*
		int randNum = (int)(Math.random() * 100 + 1);
		int cnt01 = 0;
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			int myAns = sc.nextInt();
			if(myAns > randNum) {
				cnt01++;
				System.out.println("정답이 입력값보다 작습니다.");
			}else if(myAns < randNum) {
				cnt01++;
				System.out.println("정답이 입력값보다 큽니다.");
			}else {
				cnt01++;
				System.out.println(cnt01 + "번 만에 정답입니다. 정답 : " + randNum);
				break;
			}
		}
		*/
		
//		[1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
//		      기본 예제를 통해서 설명하세요.
		/*
		자바에서 가장 많이 활용되는 메모리는 stack 영역과 heap 영역이 있다.
		stack 영역에는 기본 타입 유형이 바로 할당되고,
		heap 영역에는 배열, 열거, 객체, 인터페이스 유형이 할당된다.
		stack 영역에 heap 영역의 주소값을 할당하는 식으로 사용한다.
		객체 유형은 heap 영역을 참조한다는 개념으로 참조타입을 사용하는데
		이렇게 사용되는 변수를 참조변수라고 한다.
		 */
		int num01 = 10;
		Hello hi = new Hello();
		System.out.println("stack 영역에 할당된 기본 타입 유형 데이터 : " + num01);
		System.out.println("stack 영역에 할당된 참조 변수의 데이터 : " + hi); // javaexp.z01_homework.Hello@6e8cf4c6
		
//		[1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.
		Music m01 = new Music();
		Music m02 = new Music();
		System.out.println("m01 : " + m01);
		System.out.println("m02 : " + m02);
		System.out.println("m01 == m02 : " + (m01 == m02));
		m01 = m02;
		System.out.println("m01 : " + m01);
		System.out.println("m02 : " + m02);
		System.out.println("m01 == m02 : " + (m01 == m02));
		
//		[1단계:개념] 10. String 객체의 주소 활용방식을 ==, .equals()를 통하여 기본예제로 기술하세요. 
		// 문자열을 바로 할당하면 ==로 비교하면 같은 heap 영역 메모리를 사용하기 때문에 true가 나온다.
		String name01 = "홍길동";
		String name02 = "홍길동";
		System.out.println(name01 == name02); // true
		// 하지만 문자열의 일반적인 데이터 생성 형태는 내부적으로 new String()으로 사용되고
		// 이 경우 ==로 비교하면 false가 나온다.
		String name03 = new String("홍길동");
		String name04 = new String("홍길동");
		System.out.println(name03 == name04); // false
		// 이 경우 .eqauls()로 비교하면 true가 나온다. (문장 자체는 같기 때문)
		System.out.println(name03.equals(name04)); // true

	}

}

class Hello{}
class Music{}
