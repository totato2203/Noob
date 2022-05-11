package javaexp.z02_util;

import java.util.Scanner;

public class A03_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// # Random 데이터란?
		// 1. 임의의 데이터를 말하는 것으로 프로그램이나 빅데이터 처리 시 많이 활용된다.
		// 2. 자바에서는 기본적으로 Math.random()을 통해 0.0~1.0 사이에 실수로 임의의 데이터가 지원되고 있다.
		// 3. 0.0 <= Math.random() < 1.0
		// 4. 0.0 * 10 <= Math.random() * 10 < 1.0 * 10
		// 5. 0 <= (int)(Math.random() * 10) < 10
		// 6. 1 <= (int)(Math.random() * 10 + 1) < 11
		// # 공식 : (int)(Math.random() * 경우의 수 + 시작수)
		System.out.println(Math.random());
		System.out.println(Math.random() * 10);
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10 + 1));
		
		// 주사위를 굴리려고 한다.
		// 주사위의 수 : 6, 시작수 : 1
		int dice1 = (int)(Math.random() * 6 + 1);
		int dice2 = (int)(Math.random() * 6 + 1);
		System.out.println("주사위 : " + dice1);
		System.out.println("주사위 : " + dice2);
		
		// 동전 앞/뒤 처리.
		// 경우의 수 : 2 ==> 0, 1
		int game01 = (int)(Math.random()*2);
		if(game01 == 0) {
			System.out.println("동전 앞면");
		}else {
			System.out.println("동전 뒷면");
		}
		// ex1) 국어점수(0~100)를 임의로 처리하여 출력하세요
				// 경우의 수 : 101(0점도 포함하기 때문에), 시작 : 0
		int korPoint = (int)(Math.random() * 101);
		System.out.println("국어점수 : " + korPoint);
		// ex2) 가위/바위/보 게임을 하여 두 명이 게임한 결과를 출력하세요.
		int rsp1P = (int)(Math.random() * 3);
		int rsp2P = (int)(Math.random() * 3);
		if(rsp1P == 0) System.out.println("1P : 가위");
		if(rsp1P == 1) System.out.println("1P : 바위");
		if(rsp1P == 2) System.out.println("1P : 보");
		if(rsp2P == 0) System.out.println("2P : 가위");
		if(rsp2P == 1) System.out.println("2P : 바위");
		if(rsp2P == 2) System.out.println("2P : 보");

		// ex3) 홀짝 게임을 하여 홀/짝을 출력하세요.
		// 컴퓨터가 제시하는 홀/짝, 내가 제시한 홀/짝, 맞히면 승, 아니면 패.
		int gameIdx = (int)(Math.random()*2);
		String result = "짝";
		if(gameIdx == 1) result = "홀";
		Scanner sc = new Scanner(System.in);
		System.out.print("홀/짝 선택하세요 : ");
		String inputCh = sc.nextLine();
		System.out.println("# 결과 #");
		System.out.println("컴퓨터가 제시한 내용 : " + result);
		System.out.println("내가 제시한 내용 : " + inputCh);
		if(result.equals(inputCh)) {
			System.out.println("게임 승!!");
		}else{
			System.out.println("게임 패!!");
		}
		
	}

}
