package javaexp.a06_class;

public class A06_ConstructorInitData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자의 필드값 초기화
		1. 생성자의 가장 핵심 기능으로 필드값을 할당하여 처리할 수 있다.
		2. 기본 예제
			class Person{
				String name;
				int age;
				Person(String name, int age){
					this.name = name;
					// 입력된 매개변수명과 필드명이 같을 때는 this 키워드를 통해 구분해준다. this.필드명
				}
			}
		 */
		Person04 p01 = new Person04("홍길동", 25);
		System.out.println(p01.name);
		System.out.println(p01.age);
		// ex) 아래 내용으로 생성자의 필드값을 초기화하고 해당 필드를 출력하세요.
		//		1) Product05 : 물건명, 가격, 개수
		//		2) Calculator : 숫자1, 숫자2, 연산자
		//		3) Book : 도서명, 가격, 저자
		Product05 prd = new Product05("사과", 2000, 3);
		Calculator calc = new Calculator(1, 2, '+');
		Book bk = new Book("Zeze", 20000, "IU");
		System.out.println(prd.name);
		System.out.println(prd.price);
		System.out.println(prd.cnt);
		System.out.println(calc.num01);
		System.out.println(calc.num02);
		System.out.println(calc.con);
		System.out.println(bk.name);
		System.out.println(bk.price);
		System.out.println(bk.writer);

	}

}
class Product05{
	String name;
	int price;
	int cnt;
	Product05(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
}
class Calculator{
	int num01;
	int num02;
	char con;
	Calculator(int num01, int num02, char con){
		this.num01 = num01;
		this.num02 = num02;
		this.con = con;
	}
}
class Book{
	String name;
	int price;
	String writer;
	Book(String name, int price, String writer){
		this.name = name;
		this.price = price;
		this.writer = writer;
	}
}
class Person04{
	String name;
	int age;
	Person04(String name, int age){
		this.name = name;
		this.age = age;
	}
}