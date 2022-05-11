package javaexp.a03_calcu;

public class A07_Calcu_Triple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 삼항연산자
		1. 세 개의 피연산자를 필요로 하는 연산자
		2. 앞의 조건식 결과에 따라 콜론 앞, 뒤의 피연산자 선택
			==> 조건 연산기
		3. 형식
			(비교연산자, 논리연산자) ? true일때 : false일때
			
			cf) if else if else if ...
			조건1 ? 결과1 : (조건2 ? 결과2 : 그외결과)
		 */
		int point = 80;
		String result = (point>70) ? "합격" : "불합격";
		System.out.println("점수 : " + point);
		System.out.println("결과 : " + result);
		// ex1) 쇼핑몰에서 구매한 물건의 가격과 개수를 변수로 설정하여, 총비용이 30000 이상이면
		//		할인대상 고객, 그렇지 않으면 일반 고객으로 표시하세요.
		int price = 5000, cnt = 8, tot = price * cnt;
		String result1 = (tot >= 30000) ? "할인대상 고객" : "일반 고객";
		System.out.println("물건 가격 : " + price + ", 물건 개수 : " + cnt + ", 총비용 : " + tot + ", 할인대상 여부 : " + result1);
		// ex2) 위 문제에서 나이를 check 하여 나이가 20 미만이면 20% 할인,
		//		그렇지 않으면 할인 없이 처리할 때, 최종 금액을 출력하세요.
		//		hint) double discount (할인율은 20% ==> 0.2(실수)
		//				최종 금액 = 기본 금액 = (기본 금액 - 할인율)
		int age = 19;
		double discount = (age < 20) ? 0.2 : 0;
		int resultPay = tot - (int)(tot*discount);
		System.out.println("고객 나이 : " + age + ", 할인율 : " + (int)(discount * 100) + "%, 최종 금액 : " + resultPay);

	}

}
