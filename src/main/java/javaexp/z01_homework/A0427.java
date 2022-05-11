package javaexp.z01_homework;

public class A0427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-04-27
//[1단계:개념] 1. 증감연산식의 앞에 ++, 뒤에 ++의 차이점을 예제를 통하여 기술하세요.
		int n1 = 5;
		System.out.println(n1);
		System.out.println(n1++);
		System.out.println(n1++);
		System.out.println(n1++);
		System.out.println(n1); // n1++ 는 다음 프로세스부터 1 증가한다.
		n1 = 5;
		System.out.println(n1);
		System.out.println(++n1);
		System.out.println(++n1);
		System.out.println(++n1);
		System.out.println(n1); // ++n1 은 지금 프로세스부터 1 증가한다.
				
//[1단계:코드] 2. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
//      1~3, 1~5까지의 총비용을 출력하세요.
		int jjPrice = 5000, jbPrice = 6000;
		int jjCnt = 0, jbCnt = 0;
		int jjTot = jjPrice * jjCnt, jbTot = jbPrice * jbCnt;
		System.out.println("짜장면 개수 : " + ++jjCnt + ", 총비용 : " + jjPrice * jjCnt);
		System.out.println("짜장면 개수 : " + ++jjCnt + ", 총비용 : " + jjPrice * jjCnt);
		System.out.println("짜장면 개수 : " + ++jjCnt + ", 총비용 : " + jjPrice * jjCnt);
		System.out.println("짬뽕 개수 : " + ++jbCnt + ", 총비용 : " + jbPrice * jbCnt);
		System.out.println("짬뽕 개수 : " + ++jbCnt + ", 총비용 : " + jbPrice * jbCnt);
		System.out.println("짬뽕 개수 : " + ++jbCnt + ", 총비용 : " + jbPrice * jbCnt);
		System.out.println("짬뽕 개수 : " + ++jbCnt + ", 총비용 : " + jbPrice * jbCnt);
		System.out.println("짬뽕 개수 : " + ++jbCnt + ", 총비용 : " + jbPrice * jbCnt);
		
//[1단계:개념] 3. 비교연산식의 종류를 기술하고, 기본예제를 만들어 해당 내용에 대한 개념을 설명하세요.
		/*
		 개념 : 두 개의 피연산자가 같은지(==), 다른지(!=), 큰지(>, >=), 작은지(<,<=)에 따라 true/false 값으로 결과를 처리하는 연산자
		 종류 : ==, !=, >, >=, <, <=
		 */
//[1단계:코드] 4. 아래와 같이 비교 연산식을 이용하여 boolean(true/false) 처리하세요
//      1) 점수를 지정하여 A학점(90이상 경우) 여부를 출력하세요
		int point = 80, APoint = 90;
		boolean AResult = point >= APoint;
		System.out.println("A학점 여부 : " + AResult);
//      2) 4지선다 설문지에서 3번항목을 선택하지 않은 경우를 출력
		int numSulmoon = 2, num3beon = 3;
		boolean sulmoonResult = numSulmoon != num3beon;
		System.out.println("설문지에서 3번 항목을 선택하지 않았습니까? : " + sulmoonResult);
//      3) 점수를 지정하여 60점 미만인 경우 과락이면, 과락여부를 출력
		point = 70;
		int failPoint = 60;
		boolean failResult = point < failPoint;
		System.out.println("과락입니까? : " + failResult );
		
//[1단계:개념] 5. 비교연산식과 논리연산식의 차이점을 기술하세요.
//		비교연산식은 두 피연산자의 값을 비교하여 true/false 값으로 결과를 처리하고
//		논리연산식은 두 비교연산식의 결과값을 논리합이나 논리곱을 통해 true/false 값으로 결과를 처리한다.
//[1단계:개념] 6. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
		int n2 = 2, n3 = 3, n4 = 4;
		n2++; // 단항연산자는 항이 하나뿐이다.
		System.out.println(n2);
		n2 = n3 + n4; // 이항연산자는 항이 두 개이다.
		System.out.println(n2);
		n2 = (n2 >= n3 + n4) ? 100 : 0; // 삼항연산자는 항이 세 개 필요하고, 앞 뒤 조건식에 따라 피연산자가 정해진다.
		System.out.println(n2);
		
//[2단계:코드] 7. 삼항연산자를 이용하여 놀이공원에 입장료가 50000원 일 때, 나이가 6미만이거나 65세 이상일 때는 무료,
//               10~20일 때는 청소년 요금으로 20%할인이 된다. 나이에 따라 무료여부와, 청소년요금제 여부를
//          	처리하고, 총비용을 출력하세요
		int entPrice = 50000, age = 15;
		double discRate = 0.2;
		double notNoyakjaPrice = (age >= 10 && age <= 20) ? (entPrice - (entPrice * discRate)) : entPrice;
		double totPrice = (age < 6 || age >= 65) ? 0 : notNoyakjaPrice;
		String discPerson = "";
		if(age < 6 || age >= 65) {
			discPerson = "무료";
		}else if(age >= 10 && age <= 20) {
			discPerson = "청소년 요금";
		}
		String priceResult = (age >= 10 && age <= 20) || (age < 6 || age >= 65) ? discPerson : "할인 없음";
		System.out.println("나이가 " + age + "세이기 때문에 " + priceResult + ", 총비용 : " + totPrice);
		
//[1단계:개념] 8. main()에서 데이터의 기본 흐름 방향을 기술하고, 조건문이 처리되는 형식에 따른
//      플로우를 설명하세요.
		// 위에서 아래로, 왼쪽에서 오른쪽으로 진행된다. (단, 대입연산자는 오른쪽에서 왼쪽으로)
//[1단계:코드] 9. 조건문활용하여 1~10까지 출력하되 3/6/9게임과 같이, 
//      해당 번호에서는 짝이라고 문자열을 출력하게 하세요.
		int gameNum = 0;
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);
		System.out.println(++gameNum % 3 == 0 ? "짝" : gameNum);

//[1단계:코드] 10. if else문을 이용하여 점수에 따른 등급 A~F를 출력 처리하세요.
		int myPoint = 95;
		if(myPoint >= 90) {
			System.out.println("A학점");
		}else if(myPoint >= 80) {
			System.out.println("B학점");
		}else if(myPoint >= 70) {
			System.out.println("C학점");
		}else if(myPoint >= 60) {
			System.out.println("D학점");
		}else {
			System.out.println("F학점");
		}
		
//[1단계:코드] 11. switch case문을 활용하여 월별 날짜수를 출력하고 월이 아닌 범위는 월이 아니라고 출력하세요.
		int month = 2;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("날짜 수 : 31일");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("날짜 수 : 30일");
				break;
			case 2:
				System.out.println("날짜 수 : 28 or 29일");
				break;
			default:
				System.out.println("월이 아닌 범위 입니다.");
		}


	}

}
