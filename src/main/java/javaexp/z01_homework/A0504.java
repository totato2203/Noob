package javaexp.z01_homework;

public class A0504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-04
//		[1단계:개념] 1. 메서드의 기능을 기본 예제를 통해서 설명하세요
		// 메소드는 객체의 동작(기능)을 처리하고 호출해서 실행할 수 있는 중괄호 블럭을 사용한다.
		// 메소드 호출 시 중괄호 블럭에 있는 모든 코드들이 일괄 실행된다.
		Person06 p06 = new Person06();
		p06.getNum(); // 출력 : num01
		
//		[1단계:확인] 2. [리턴유형연습] 쇼핑몰에서 구매한 물건, 가격, 갯수, 배송지를 리턴값으로 선언하는 메서드와, 
//		      리턴값이 없이 위 정보를 출력하는 메서드를 선언하세요
		Shopping sp = new Shopping();
		System.out.println("# 리턴값으로 출력 #");
		System.out.println(sp.getProdName());
		System.out.println(sp.getPrice());
		System.out.println(sp.getCnt());
		System.out.println(sp.getDelv());
		sp.prt();
		
//		[1단계:확인] 3. [매개변수연습] driving메서드에 매개변수로 1~3개를 각각 선언하되,
//		      차량명, 목적지, 거리를 선언하여 출력하되 오버로딩 규칙에 따라 처리하세요.
		Car02 c02 = new Car02();
		c02.driving("소나타");
		c02.driving("소나타", "서울");
		c02.driving("소나타", "서울", 100);
		
//		[1단계:확인] 4. [매개변수+리턴] Student 클래스
//		      tot() 매개변수:국어,영어,수학점수 리턴값:총점수(정수)
//		      avg() 매개변수:국어,영어,수학점수 리턴값:평균값(실수)
//		      reg() 매개변수:번호,이름  리턴값:@@번 @@@(문자열)
//		      show() 매개변수:이름,국어,영어,수학  리턴값:없음, 출력:매개변수값
		Student st = new Student();
		System.out.println(st.tot(100, 70, 50));
		System.out.println(st.avg(100, 70, 50));
		System.out.println(st.reg("2", "홍길동"));
		st.show("홍길동", 20, 54, 80);
		
//		[1단계:확인] 5. [매개변수+리턴] Member 클래스 선언하고, regdate()메서드로
//		      회원명, 아이디, 패스워드 매개변수로 입력과 String으로 등록 내용을 리턴
//		      usePoint()메서드로 사용한 포인트를 입력받아 10%적립포인트 리턴(실수)
//		      addPoint()메서드로 추가할포인트를 입력받아 지역변수로 있는 point=1000
//		      에 추가하여 리턴처리하세요.
		Member01 mb = new Member01();
		System.out.println(mb.regdate("김춘삼", "ajtwoddlrlacnstka", "rnldyalcnstkadl"));
		mb.addPoint((int)mb.usePoint(500));
		System.out.println(mb.point); // 1000 + (500/10) = 1050
		
//		[1단계:확인] 6. [매개변수+필드] Coffee 클래스 선언, 
//		      필드 : 주문커피종류, 주문 가격, 주문 갯수
//		      메서드 : orderName - 주문커피종류 저장
//		             orderCoffee - 주문커피종류, 가격, 갯수 저장
//		             getPay - 총비용(가격*갯수) 리턴
//		             getName() - 주문커피종류 리턴
//		             showAll() - 저장된 주문커피종류,가격,갯수,총액 문자열리턴
		Coffee cf = new Coffee();
		cf.orderCoffee("아메리카노", 3000, 2);
		System.out.println(cf.getPay());
		System.out.println(cf.getName());
		System.out.println(cf.showAll());
		
//		[1단계:확인] 7. [필드+로직처리] Gugu 클래스 선언
//		      필드 : 단수, 시작단수, 마지막단수
//		      메서드 : schGrade - 단수지정
//		      showResult - 해당 단수의 1~9까지 연산 출력
//		      setFromTo - 시작단수,마지막단수 지정
//		      showResult2 - 범위가 있는 단수 출력
		Gugu gg = new Gugu();
		gg.schGrade(3);
		gg.showResult();
		gg.setFromTo(2, 5);
		gg.showResult2();
		
//		[1단계:확인] 8. [필드+로직처리] Bus 클래스 선언
//		      필드 : 버스번호, 구간, 비용
//		      메서드 : basicInfo - 입력 버스번호, 구간, 비용
//		             takeBus - 입력 : 인원수 리턴:비용*인원수
//		                 화면 출력 : 구간 @@ 인  @@번 @@명 탑승
		Bus b01 = new Bus();
		b01.basicInfo(101, "서울 - 강릉", 1000);
		System.out.println("총비용 : " + b01.takeBus(15));

	}

}
class Bus{
	int busNum;
	String googan;
	int price;
	void basicInfo(int busNum, String googan, int price) {
		this.busNum = busNum;
		this.googan = googan;
		this.price = price;
	}
	int takeBus(int head) {
		System.out.println("구간 : " + googan + "인 " + busNum + "번 " + head + "명 탑승");
		return price * head;
	}
}
class Gugu{
	int grade;
	int startGrade;
	int endGrade;
	void schGrade(int grade) {
		this.grade = grade;
	}
	void showResult() {
		for(int cnt = 1; cnt <= 9; cnt++) {
			System.out.println(grade + " * " + cnt + " = " + (grade * cnt));
		}
	}
	void setFromTo(int startGrade, int endGrade) {
		this.startGrade = startGrade;
		this.endGrade = endGrade;
	}
	void showResult2() {
		for(; startGrade <= endGrade; startGrade++) {
			for(int cnt = 1; cnt <= 9; cnt++) {
				System.out.println(startGrade + " * " + cnt + " = " + (startGrade * cnt));
			}
		}
	}
}
class Coffee{
	String cofKind;
	int price;
	int ordCnt;
	void orderName(String cofKind) {
		this.cofKind = cofKind;
	}
	void orderCoffee(String cofKind, int price, int ordCnt) {
		this.cofKind = cofKind;
		this.price = price;
		this.ordCnt = ordCnt;
	}
	int getPay() {
		return price * ordCnt;
	}
	String getName() {
		return cofKind;
	}
	String showAll() {
		return "커피종류 : " + cofKind + ", 가격 : " + price + ", 개수 : " + ordCnt + ", 총액 : " + getPay();
	}
}
class Member01{
	String name, id, pw;
	int point = 1000;
	String regdate(String name, String id, String pw){
		return "회원명 : " + name + ", ID : " + id + ", PW : " + pw;
	}
	double usePoint(int pt) {
		return pt / (double)10;
	}
	int addPoint(int pt) {
		return point += pt;
	}
}
class Student{
	int kor, eng, math;
	String num, name;
	int tot(int kor, int eng, int math) {
		return kor + eng + math;
	}
	double avg(int kor, int eng, int math) {
		return (kor + eng + math) / (double)3;
	}
	String reg(String num, String name) {
		return num + "번 " + name;
	}
	void show(String name, int kor, int eng, int math) {
		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + kor + "점");
		System.out.println("영어 점수 : " + eng + "점");
		System.out.println("수학 점수 : " + math + "점");
	}
}
class Car02{
	String model;
	String arrv;
	int spd;
	void driving(String model) {
		System.out.println("모델명 : " + model);
	}
	void driving(String model, String arrv) {
		System.out.println("모델명 : " + model + ", 목적지 : " + arrv);
	}
	void driving(String model, String arrv, int spd) {
		System.out.println("모델명 : " + model + ", 목적지 : " + arrv + ", 속도 : " + spd);
	}
}
class Shopping{
	String prodName = "사과";
	int price = 2000;
	int cnt = 5;
	String delv = "서울";
	String getProdName() {
		return prodName;
	}
	int getPrice() {
		return price;
	}
	int getCnt() {
		return cnt;
	}
	String getDelv() {
		return delv;
	}
	void prt() {
		System.out.println("# 리턴 없이 출력 #");
		System.out.println(prodName);
		System.out.println(price);
		System.out.println(cnt);
		System.out.println(delv);
	}
}
class Person06{
	int num01 = 1;
	void getNum(){
		System.out.println(num01);
	}
}