package javaexp.a06_class;

public class A02_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 클래스의 구성 멤버
		1. 필드(field)
			주로 데이터를 저장하는 역할을 한다.
			객체가 만들어졌을 때, 그 객체가 사용할 속성이 적절한 데이터를 할당할 때 활용된다.
			ex) 자동차의 배기량, 최고속도, 생산회사 등등
		2. 생성자(Constructor)
			객체 생성 시, 초기화 역할을 담당한다.
			객체를 처음 만들었을 때, 이 객체가 가지고 있어야 할 기본 데이터를 저장할 때 활용된다.
			매개변수를 통해서 전달 받는 경우도 있다.
			ex) 마트에서 계산하는 post의 경우, 이 마트가 다루는 상품 정보, 가격 정보, 연산 규칙 등은
				계산기가 초기에 가지고 있어야 할 정보이다. 이를 초기에 설정할 때 생성자를 통해서 선언하고,
				객체 생성 시 초기화된다.
		3. 메소드(Method)
			객체의 동작에 해당하는 실행 블록을 말한다. 입력을 통해 필드에 데이터를 저장하거나,
			저장된 데이터를 불러와서 연산하여 원하는 정보를 수집하는 등의 작업을 한다.
			주로 조건, 반복문을 통해서 원하는 정보로 만들어서 return 한다.
		 */
		Person01 p01 = new Person01(); // 객체의 생성
		p01.name = "홍길동";
		p01.age = 25;
		p01.loc = "서울 신림동";
		Person01 p02 = new Person01(); // 객체의 생성
		p02.name = "오길동";
		p02.age = 27;
		p02.loc = "경기 구리";
		System.out.println("p01 객체의 필드");
		// 참조변수.필드명
		System.out.println(p01.name);
		System.out.println(p01.age);
		System.out.println(p01.loc);
		
		System.out.println("p02 객체의 필드");
		// 참조변수.필드명
		System.out.println(p02.name);
		System.out.println(p02.age);
		System.out.println(p02.loc);
		// ex) class로 Product01을 선언하고 물건명과 가격 필드를 선언하고,
		//		Product01 객체를 생성하여 물건정보 3개를 물건명, 가격으로 선언하고 할당하세요. (객체 생성 3개)
		// 클래스명 참조변수 = new 클래스명();
		Product01 pr01 = new Product01();
		pr01.name = "사과";
		pr01.price = 2000;
		Product01 pr02 = new Product01();
		pr02.name = "바나나";
		pr02.price = 3000;
		Product01 pr03 = new Product01();
		pr03.name = "오렌지";
		pr03.price = 2500;
		System.out.println(pr01.name);
		System.out.println(pr01.price);
		System.out.println(pr02.name);
		System.out.println(pr02.price);
		System.out.println(pr03.name);
		System.out.println(pr03.price);
		/*
		# 필드의 초기값
		1. 초기값 지정되지 않은 필드
			- 필드는 객체 생성 시 자동으로 기본값으로 초기화된다.
			ex) 기본값
			정수형 byte/char(\u0000 - 빈 공백)/short/int/long ==> 0
			실수타입 float/double ==> 0.0f, 0.0
			논리값 boolean = false
			참조타입(객체형) - 배열, 클래스, 인터페이스 ==> null
		# 필드의 사용
		1. 필드 값을 일고, 변경하는 작업을 말한다.
		2. 필드 사용 위치
			1) 소속된 클래스 내부에서는 : 필드이름으로 바로 접근
			2) 외부에서 객체를 호출할 때는 : 참조변수.필드명으로 접근
		 */
		Product01 pr04 = new Product01();
		System.out.println("초기값");
		System.out.println("초기값 : " + pr04.name);
		System.out.println("초기값 : " + pr04.price);

	}

}
class Person01{	// 같은 package(package javaexp.a06_class;)에 동일한 클래스(Person)는 선언이 불가능하다.
	// 필드 선언.
	// 저장할 데이터를 바로 선언 및 할당도 가능하지만,
	// 일반적으로 외부에서 호출하여 데이터를 할당하는 경우가 많다.'
	// # 필드의 내용
	// 1. 객체의 고유 데이터
	// 2. 객체가 가져야 할 부품 객체
	// 3. 객체의 현재 상태 데이터
	String name;
	int age;
	String loc;
	
}
class Product01{
	String name; // String name = null; 기본이 객체 생성 시 선언된다.
	int price; // int price = 0;
	Product01(){
		price = 3000;
	}
}