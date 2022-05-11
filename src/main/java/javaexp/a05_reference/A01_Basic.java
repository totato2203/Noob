package javaexp.a05_reference;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 참조변수
		1. 자바에서 가장 많이 활용되는 메모리는 stack 영역과 heap 영역이 있다.
		cf) 기본 데이터 유형을 stack에 선언과 할당.
			객체(배열, 객체, 인터페이스..)를 사용하는 메모리 비유
				도서관의 책을 찾는 단말기 - stack, 실제 책이 있는 곳은 heap 영역
					책이 있는 위치를 가리켜준다.
		2. stack 영역에는 기본 타입 유형이 바로 할당되는데,
			그 외 배열, 열거, 객체, 인터페이스 유형은 heap 영역에 할당되고,
			stack 영역에 heap 영역의 주소값을 할당하여 사용한다.
		3. 이 때, 객체 유형은 heap 영역을 참조한다는 개념으로 참조타입을 사용한다.
			이러한 변수를 참조변수라고 한다.
		#데이터 타입의 분류
		1. 기본타입
			정수, 실수, 논리 타입
		2. 참조타입
			배열, 열거, 클래스, 인터페이스
		
		# 변수의 메모리 사용
		1. 기본 타입
			할당할 데이터를 변수 안에 저장한다.
			stack 영역에 데이터를 바로 저장.
		2. 참조 타입 변수
			할당할 데이터를 변수 안에 주소로 저장한다.
			heap 영역의 데이터를 주소값으로 stack 영역에 할당 저장.
		 */
		int num01 = 25;
		int num02 = 25;
		System.out.println("stack 영역에 할당된 데이터 : " + num01);
		Person p01 = new Person(); // p01 참조변수
		Person p02 = new Person(); // p02 참조변수
		System.out.println("stack 영역에 할당된 참조변수의 데이터 : " + p01);
		System.out.println("stack 영역에 할당된 참조변수의 데이터 : " + p02);
		System.out.println(num01 == num02);
		// 특정 객체는 참조변수를 통해서 해당 객체의 위치를 찾아가서
		// 가지고 있는 속성값으로 접근하여 데이터를 활용한다.
		System.out.println("객체의 데이터 활용 : " + p02.name);
		// p02라는 참조변수를 통해서 해당 객체의 heap 영역의 위치를 찾아가서
		// p02.name 이라는 객체에 소속된 속성에 접근하여 그 속성이 
		System.out.println("객체의 데이터 활용 : " + p02.age);
		System.out.println(p01 == p02);
		Person p03 = p01; // p03이라는 stack 영역 메모리에 p01 주소값을 할당.
		System.out.println(p01 == p03);
		
		// javaexp.a05_reference.Person@2f92e0f4
		// 패키지명.객체명@heap영역의주소값(16진수)
		
		// ex1) Product를 통해 prod01과 prod02 객체를 생성하고 주소값을 비교
		Product prod01 = new Product();
		Product prod02 = new Product();
		System.out.println(prod01 == prod02);
		// ex2) prod03을 선언하여 prod01을 할당하고, prod01과 prod03를 비교
		Product prod03 = prod01;
		System.out.println(prod01 == prod03);
		// ex3) prod01, prod02, prod03의 heap 영역의 주소값을 출력
		System.out.println("stack 영역에 할당된 참조변수의 데이터 : " + prod01);
		System.out.println("stack 영역에 할당된 참조변수의 데이터 : " + prod02);
		System.out.println("stack 영역에 할당된 참조변수의 데이터 : " + prod03);

	}

}
class Product{}
class Person{
	String name = "홍길동";
	int age = 25;
	
}	// 객체를 만들기 위한 코드(클래스)
// 클래스는 도면, 객체는 이 도면을 통해서 jvm에서 실제 메모리를 할당하고 만들어서 사용할 수 있는 것을 말한다.