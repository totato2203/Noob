package javaexp.z01_homework;

import java.util.Scanner;

public class A0428 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-04-28
//		[1단계:개념]1. 반복문 for, while, do while의 차이점을 기술하세요.
		// for문은 반복 step에 변수를 활용할 수 있을 때 사용한다.
		// while문은 특정 입력데이터에 의해 변경되어 반복을 중단할 때 사용한다.
		// do while문은 반복할 블럭을 일단 한 번 진행하는 while문이다.
		
//		[1단계:개념]2. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
		for(int cnt = 1; cnt <= 3; cnt++) { // (초기화식; 조건식; 증감식)
			// 초기화식은 사용할 변수를 초기화 하고, 조건식은 반복할 조건을 정하고, 증감식은 반복할 때마다 몇 씩 증가 혹은 감소할지 정한다.
			System.out.println(cnt); // 실행문 
		}
		
//		[1단계:개념]3. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
		for(int cnt = 200; cnt >= 100; cnt -= 3) {
			System.out.println(cnt);
		}
		
//		[1단계:개념]4. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
//		            # 출력 형식
//		            1일차 2개 2개
//		            2일차 4개 6개
//		            3일차 6개 10개
		int tot = 0;
		for(int cnt = 1; cnt <= 10; cnt++) {
			int breadDay = cnt * 2;
			tot += breadDay;
			System.out.println(cnt + "일차\t" + breadDay + "개\t" + tot + "개");
		}
		
//		[1단계:코드]5. 3/6/9게임 2단계 1~20까지 해당 게임과 같이 출력처리하세요(모두 출력해주세요)
//		            1) 1단계 : 3의 배수에 짝이라 표기
//		            2) 2단계 : 1 2 짝 4 ... 10 11 12 짝 14 15 16 짝...
		// 1단계
		for(int cnt = 1; cnt <= 20; cnt++) {
			System.out.println((cnt % 3 == 0) ? (cnt + "(짝)") : (cnt));
		}
		// 2단계 : 마지막에 3, 6, 9가 되려면 십의 자리를 빼면 된다.
		// 변수 % 10 ==> 모든 0, 1, 2, ... , 8, 9
		// 위 결과값에 % 3 ==> 뒷자리가 3, 6, 9가 처리된다.
		for(int cnt = 1; cnt <= 20; cnt++) {
			if(cnt % 10 != 0 && cnt % 10 % 3 == 0) {
				System.out.println(cnt + "(짝)");
			}else {
				System.out.println(cnt);
			}
		}
		
//		[1단계:코드]6. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
//		           초기데이터 100
//		           1회  25 
//		           2회  6.2..
//		           3회  1.54...
//		           4회  0.38..
		double num01 = 100;
		System.out.println("초기데이터\t" + num01);
		for(int cnt = 1; cnt <= 4; cnt++) {
			System.out.println(cnt + "회\t" + (num01 /= 4));
		}
		
//		[1단계:개념]7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
		for(int cnt = 1; cnt <= 5; cnt++) {
			if(cnt == 4) break;
			System.out.println(cnt);
		} // cnt의 값이 4가 되면 반복을 중단함.
		
		for(int cnt = 1; cnt <= 5; cnt++) {
			if(cnt == 4) continue;
			System.out.println(cnt);
		} // cnt의 값이 4가 되면 cnt == 4일 때의 반복은 실행하지 않고 다음 반복(cnt == 5)을 실행함.
		
//		[2단계:코드]8. [continue 활용]1~12월까지 마지막일수*10으로 월급여 산정하되, 31일만 있는 월만 산정해서 출력하고 나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요
//		                월  일수   월급여 누적연봉      
//		                1월 31일  310만 310만원
//		                3월 31일  310만 620만원
//		                5월 31일  310만 930만원
//		                ..
//		                12 31일  .. 
		int day = 31, monthPay = day * 10, totPay = 0;
		System.out.println("월\t일수\t월급여\t누적연봉");
		for(int month = 1; month <= 12; month++) {
			// 해당 월은 배제 처리
			if(month == 2 || month == 4 || month == 6 || month == 9 || month == 11) continue;
			totPay += monthPay;
			System.out.println(month + "월\t" + day + "일\t" + monthPay + "만\t" + totPay + "만원");
		}
		
//		[1단계:개념]9. Scanner 객체 선언과 사용법을 기술하세요.
		Scanner sc = new Scanner(System.in); // 이후 에러 메세지 목록에서 import 클릭
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine(); // 이후 콘솔창에서 이름 입력
		System.out.println("당신의 이름은 " + name + " 입니다.");
		
//		[1단계:확인]10. Scanner 객체를 통해서 국어, 영어, 수학 점수를 숫자로 입력받아 합산과 평균을 출력하세요.
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		int sum = kor + eng + math;
		double avg = (kor + eng + math) / (double)3;
		System.out.printf("국어 : %d\n", kor); // %d : 정수형 데이터 표시
		System.out.printf("영어 : %d\n", eng);
		System.out.printf("수학 : %d\n", math);
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", avg); // %.(소수점 이하 자리수)f : 실수형 데이터 표시

	}

}
