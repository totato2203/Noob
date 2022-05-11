package javaexp.a04_process;

public class A02_if_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 분기 조건문 처리
		1. 기본 형식
			if(조건식){
				조건식이 true일 때,
			}else{
				조건식이 false일 때..
			}
		2. 여러가지 분기 조건
			if(조건1){
			
			}else if(조건2){
			
			}else if(조건3){
			
			}else if(조건4){
			
			}else{
			
			}
			
			ex)
			if(point >= 90){
				A학점 처리
			}else if(point < 90 && point >= 80){
				// else if 중 else를 통해서 상위에 선언된 조건을
				// 제외하고 라는 것을 포함하고 있기에
				// "point < 90 &&"은 불필요하다.
				B학점 처리
			}else if(point >= 70){
				C학점 처리
			}..
			..
			}else{
				//위에 기술한 조건 이외일 때, 처리할 내용
			}
			
			if(point >= 90){
			
			}
			if(point < 90 && point >= 80){
				// else가 없기 때문에 "point < 90 &&"가 필요하다.
			}
			
		 */
		/*
		# java에서 문자열의 비교 처리
		1. 문자열1 == 문자열2 로 비교하면 예외가 발생한다. (== 로 비교 X)
		2. 문자열1.equals(문자열2)
		 */
		String name01 = "홍길동";
		String name02 = "홍길동";
		String name03 = "신길동";
		System.out.println("문자열 비교 : " + name01.equals(name02));
		System.out.println("문자열 비교 : " + name01.equals(name03));
		
		String inputId = "himan";
		String inputPwd = "9999";
		if(inputId.equals("himan") && inputPwd.equals("9999")) {
			System.out.println(inputId + "님 로그인 성공입니다!!!");
		}else {
			System.out.println("로그인 실패입니다!!");
		}
		// ex) age를 임의의 숫자로 할당하고, 10~20까지일 때는 청소년 요금제 입니다.
		// 		그 외는 청소년 요금제가 아닙니다. 출력하게 하세요.
		int age = 25;
		if(age <= 20 && age >= 10) {
			System.out.println("청소년 요금제 입니다.");
		}else {
			System.out.println("청소년 요금제가 아닙니다.");
		}
		// 구매비용을 기준으로 MVP, VIP, 보통고객
		int buyPrice = 5200;
		int buyCnt = 15;
		int tot = buyPrice * buyCnt;
		System.out.println("구매 비용이 " + tot + "원 이므로, ");
		if(tot >= 100000) {
			System.out.println("MVP 고객입니다.");
		}else if(tot >= 50000) {
			System.out.println("VIP 고객입니다.");
		}else {
			System.out.println("보통 고객입니다.");
		}
		// ex) 타율 : 안타 수 / 타석 입력 받아서
		//		0.350 이상은 최고타자
		//		0.3 ~ 0.35 미만은 우수타자
		//		0.25 ~ 0.3 미만은 일반타자
		//		0.25 미만은 2군준비타자
		int anta = 5, taseok = 20;
		double rate = anta / (double)taseok;
		if(rate >= 0.350) {
			System.out.println("타율이 "+ rate + "인 최고타자");
		}else if(rate >= 0.3) {
			System.out.println("타율이 "+ rate + "인 우수타자");
		}else if(rate >= 0.25) {
			System.out.println("타율이 "+ rate + "인 일반타자");
		}else {
			System.out.println("타율이 "+ rate + "인 2군준비타자");
		}
		
		// # 중첩 조건문 : 조건문 안에 조건문이 계층적으로 처리될 때 활용된다.
		boolean isMale = true;
		int ckAge = 26;
		if(isMale) {
			if(ckAge>=20) {
				System.out.println("신사");
			}else {
				System.out.println("소년");
			}
		}else {
			if(ckAge>=20) {
				System.out.println("숙녀");
			}else {
				System.out.println("소녀");
			}
		}
		
		
	}

}
