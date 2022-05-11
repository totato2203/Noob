package javaexp.a04_process;

public class A08_For_Double {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 이중 반복문
		1. 반복문 안에 반복을 처리하여 효과적인 로직과 화면을 구성할 때 활용된다.
		2. 형식
			for(;;){	// 상위 단계의 반복문
				for(;;){	// 하위 단계의 반복문
				
				}
			}
		 */
		// 구구단의 경우 2~9단, 1~9
		// 단수는 외부 for 처리
		// 1~9는 내부 for 처리
		for(int grade = 2; grade <= 9; grade++) {
			System.out.println("# " + grade + "단 #");
			for(int cnt = 1; cnt <= 9; cnt++) {
				System.out.println(grade + " X " + cnt + " = " + grade * cnt);
			}
		}
		// * 개수 늘어가기
		for(int ocnt = 1; ocnt <= 5; ocnt++) {
			// icnt <= ocnt : 상위에 있는 for의 개수만큼 반복 시행
			for(int icnt = 1; icnt <= ocnt; icnt++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
