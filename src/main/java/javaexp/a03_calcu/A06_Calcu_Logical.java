package javaexp.a03_calcu;

public class A06_Calcu_Logical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 논리연산자
		1. 비교연산자나 boolean(true/false)값이 나오면 그것에 의해서
		and(논리합), or(논리곱)에 의해 결과를 혼합하여 처리할 때 필요한 연산자를 말한다.
		2. 형식
			비교연산자1 && 비교연산자2
				두 개의 비교연산식이 모두 다 true 일 때, true로 처리되는 것을 말한다.
				ex) 국어점수와 영어점수가 모두 80점 이상일 때 합격의 경우를 처리할 때 활용된다.
				kor>=80 && eng>=80
			비교연산자1 || 비교연산자2
				두 개의 비교연산식 중 하나라도 true 일 때, true이고,
				모두 다 false일 때는 false일 경우에 필요한 논리연산자이다.
				ex) 국어, 영어, 수학 점수가 하나라도 80점 이상이면 합격인 경우를 처리할 때 활용된다.
				kor>=80 || eng>=80 || math>=80
			cf) &, &&
				|, ||
				차이는 두 개가 있으면 논리식이 합당치 않으면 두번째 비교연산식의 처리를 방지해준다.
				비교연산식1 && 비교연산식2 의 경우, 비교연산식1이 false이면
				비교연산식2로 프로세스를 처리하는 것을 방지한다.
				비교연산식1 || 비교연산식2 의 경우 비교연산식1이 true이면
				비교연산식2로 프로세스를 처리하는 것을 방지한다.
				(&&, || 가 더 효율이 좋으니 &, |는 알고만 있자)
		*/
		
		int kor = 80;
		int eng = 70;
		int math = 90;
		System.out.print("모두가 80점 이상일 때 합격 : ");
		System.out.println(kor>=80 && eng>=80 && math >=80);
		System.out.print("하나라도 80 이상이면 합격 : ");
		System.out.println(kor>=80 || eng>=80 || math >=80);
		
		// ex1) 구매한 물건(사과, 바나나, 딸기)가 모두 2000원 이상이면 vip 고객여부를 true
		// ex2) 위 구매물건에서 개수를 각각 처리하여 총비용이 5000 이상인 것이 있으면 할인대상 고객여부 true
		int applePrice, bananaPrice, berryPrice;
		int appleCnt = 1, bananaCnt =2, berryCnt = 5;
		applePrice = appleCnt * 1000; bananaPrice = bananaCnt * 1000; berryPrice = berryCnt * 1000;
		System.out.println("각 물건 구매 개수 - 사과 : " + appleCnt + ", 바나나 : " + bananaCnt + ", 딸기 : " + berryCnt);

		boolean isVip = applePrice >= 2000 && bananaPrice >= 2000 && berryPrice >= 2000;
		System.out.println("vip 고객 여부 : " + isVip);
		
		boolean isDC = applePrice >= 5000 || bananaPrice >= 5000 || berryPrice >= 5000;
		System.out.println("할인대상 고객 여부 : " + isDC);
		
		/*
			논리 부정 연산자 : !
				논리 결과값이 true이면 false로, false이면 true로 처리하는 논리연산자이다.
		 */
		System.out.println("할인대상 고객이 아닌지 여부 : " + !isDC); // 할인대상 고객이 아닌가요? false ==> 할인대상 고객이다.

	}

}
