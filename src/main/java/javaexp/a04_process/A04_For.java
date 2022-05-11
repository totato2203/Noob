package javaexp.a04_process;

public class A04_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 반복문
		1. 중괄호 블록 내용을 반복적으로 실행할 때, 사용된다.
		2. 종류
			for문 : 반복 step에 변수를 사용할 필요가 있을 때 사용된다.
				cf) 배열 데이터에서 단위 데이터를 반복적으로 사용할 때 활용된다.
			while문 : 반복 블럭에서 특정 입력데이터에 의해 변경이 되어 반복을 중단할 때 주로 사용된다.
			do{}while문 : 반복할 내용을 일단 한 번은 수행하고 입력 데이터에 의해
						반복 여부를 처리할 때 주로 사용된다.
						
			# for문
			1. 반복 횟수를 알고 있을 때, 주로 사용한다.
				1) 기본 형식
					for(초기화식1; 조건식2; 증감식4){
						실행문 3
					}
					초기화식1: 생략해도 되는데, 주로 초기값을 설정할 때 사용한다.
						해당 반복문 block에서 사용할 초기값을 선언한다.
						이 초기화식은 한 번만 호출되어 사용한다.
						ex) for(int cnt = 1;;){} // 지역변수로 초기값 선언
						ex) int cnt = 1; // 전역변수로 초기값 선언
							for(;cnt <= 10; cnt++){}
							System.out.println("현재 카운트변수 : " + cnt);
							
					조건식2 : 반복 block을 다시 수행시켜줄 조건을 설정한다.
						보통 boolean(true/false)을 설정하는 것이 일반적이다.
						ex) for(;cnt <= 25;){} // 반복을 수행할 조건
					실행문3 : 실제 반복이 일어나는 구문을 말한다.
						조건문(break, continue), 반복문
					증감식4 : 초기화식에 의해 초기화된 변수를 증가/감소 시켜준다.
						ex) for(;;cnt++){} for(;;cnt += 3){}
							for(;;cnt--){} for(;;cnt -= 5){}
				처리 프로세스 순서 : 초기화식 ==> 조건식 ==> 실행문 ==> 증감식
											조건식 ==> 실행문 ==> 증감식
				cf) for(;;) {} : 생략하면 while문과 동일하다.
					
		 */
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println("카운트 : " + cnt);
		}
		// ex1) 5~25까지 출력
		for(int cnt = 5; cnt <= 25; cnt++) {
			System.out.println(cnt);
		}
		// ex2) 100~120까지 출력
		for(int cnt = 100; cnt <= 120; cnt++) {
			System.out.println(cnt);
		}
		/*
		# 반복문 처리 연습 단계
		1. 기본 구성요소 연습
			1) 초기값, 반복 조건 연습
			2) 증감연산자 연습
				cnt++, cnt--, cnt+=2, cnt-=3
			3) 출력할 내용에 대한 연습(반복 중괄호 블럭에서 처리 연습 1단계
				System.out.println() : 줄바꿈 없이 처리
				System.out.print() : 줄바꿈 없이 처리
				System.out.print("\t") : 탭간격 처리
				System.out.print("\n") : 줄바꿈 처리
				// cf) System.out.printf("") : 특정 데이터의 형식(크기)
				* 특정한 형식으로 데이터 출력하세요
		2. 반복문 밖의 외부 변수를 통한 처리(전역변수/지역변수)
			1) 지정된 변수 설정과 반복문의 변수와 혼합하여 출력하기
				ex) 구구단의 단수, 1~10까지의 반복변수, 혼합하여 구구단 출력
			2) 누적 데이터 처리
				합산할 변수 선언
				변수를 통해 누적 처리 데이터 출력
			cf) 개체변수, 메서드변수에 영향을 미쳐서 지역/전역변수로 처리할 수 있다.
		3. 반복문과 조건문을 혼합하여 처리하기
			1) 반복문 안에 조건을 넣어 특정한 경우에 출력 또는 연산 처리하기
				산술연산자(+, -, *, /, %) 특히 %(나머지값)을 활용하면
				프로그램을 보다 효율적으로 조건처리 할 수 있다.
				ex) 1~10 출력 내용 중에 짝수만 출력하기
				ex) 합산된 값이 20일 때 출력하기
				ex) 1~100 출력하되 5단위로 줄바꿈 처리하기
				ex) 1~20까지 합산을 하되 마지막에는 =을 표기하기
					1 + 2 + 3 + ... + 20 = @@@
			2) 조건문으로 특정한 경우 break와 continue를 통해서 프로세스를 제어하기
				ex) 구구단에서 5인 경우에 중단 처리하기
		4. 반복문에서 반복문을 활용하기
		 */
		System.out.println("# 5씩 증가 #");
		for(int cnt = 1; cnt <= 100; cnt += 5) {
			System.out.println(cnt);
		}
		System.out.println("# 2씩 감소 #"); // 감소는 큰 데이터가 작은 데이터로 변해가는 과정
		for(int cnt = 10; cnt > 0; cnt--) {
			System.out.println(cnt);
		}
		// * 증가와 감소에 따라서 반복 조건의 부호를 변경시켜야 한다.(주의)
		// ex1) 10~50까지 3씩 증가 처리 출력하세요
		for(int cnt = 10; cnt <= 50; cnt += 3) {
			System.out.println(cnt);
		}
		// ex2) 10부터 0까지 카운트다운 처리하세요
		for(int cnt = 10; cnt >= 0; cnt--) {
			System.out.println(cnt);
		}
		// ex3) 100부터 70까지 5씩 감소 처리 출력하세요
		for(int cnt = 100; cnt >= 70; cnt -= 5) {
			System.out.println(cnt);
		}
		// ex4) 50부터 -20까지 4씩 감소 처리 출력하세요
		for(int cnt = 50; cnt >= -20; cnt -= 4) {
			System.out.println(cnt);
		}

	}

}
