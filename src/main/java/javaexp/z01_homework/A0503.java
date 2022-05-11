package javaexp.z01_homework;

public class A0503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-03
//		[1단계:개념] 1. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
		Person05 p01 = new Person05(3); // 객체 nm에는 Normal 클래스의 주소값이 할당.
		System.out.println(p01); //javaexp.z01_homework.Normal@2f92e0f4 // Person05 클래스의 주소값
		
//		[1단계:개념] 2. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
		// 객체를 출력하면 객체가 참조하는 클래스의 주소값이 출력되고, 일반 primitive 데이터는 그 자체가 출력된다.
		
//		[1단계:개념] 3. 클래스의 구성요소 3가지를 예제를 통해서 특징을 기술하세요.
		// 필드, 생성자, 메소드
		Person05 p02 = new Person05(5); // 생성자 : 객체 생성 시 초기화 역할, 객체 생성 시 가지고 있어야할 기본 데이터를 저장할 때 활용
		p02.name = "홍길동";
		System.out.println(p02.name); // 메소드 : 객체의 동작에 해당하는 실행 블럭,
		// 입력을 통해 필드에 데이터를 저장하거나 저장된 데이터를 불러와서 연산하여 원하는 정보를 수집하는 역할
		
//		[1단계:개념] 4. 매개변수를 통하여 생성자나 메서드에 데이터를 할당 처리할 수 있다. 그 기준이 되는 유형, 갯수 선언
//		              규칙(오버로딩)을 예제를 통하여 설명하세요.
		// 생성자나 매개변수는
				// 1) 매개변수의 타입의 유형이 다를 때,
				// 2) 매개변수의 개수가 다를 때,
				// 3) 매개변수의 개수가 동일하더라도 타입의 순서가 다를 때
				//		다른 생성자나 메서드로 인식하여 선언이 가능하다. ==> 오버로딩 규칙
				// # 궁극적으로 생성자나 매개변수에 데이터를 넘겨줄 때, 식별이 가능한 한 선언이 가능하다.
		
		// 매개변수의 타입 유형이 다를 때, 매개변수의 개수가 다를 때, 매개변수의 개수가 동일하더라도 타입의 순서가 다를 때,
		// 다른 생성자나 메서드로 인식하여 선언이 가능하다.
		Person05 p03 = new Person05("고길동");
		Person05 p04 = new Person05(7);
		Person05 p05 = new Person05("고길동", 10);
		Person05 p06 = new Person05(20, "고길동"); // 매개변수에 따라 4개의 메서드가 모두 각각 다른 메서드로 인식되었다.
		
//		[1단계:확인] 5. Car 객체의 생성자를 매개변수를 제조사, 최고속도, 배기량을 기준으로 1~3개까지 선언하고 해당 데이터를
//		            출력하세요.
		Car c01 = new Car("삼성", 200, 100);
		Car c02 = new Car("삼성", 200);
		Car c03 = new Car("삼성", 100);
		System.out.println(c01);
		System.out.println(c01.name);
		
//		[1단계:확인] 6. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
//		    1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
		Singer s01 = new Singer("IU", "Edam", "GoodDay");
		System.out.println("이름 : " + s01.name + ", 소속사 : " + s01.manage + ", 메인곡 : " + s01.song);
		
//		    2) Game 클래스를 선언하고 출시회사, 비용, 인기순을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
		Game g01 = new Game("Riot", 10000, 1);
		System.out.println("출시회사 : " + g01.name + ", 비용 : " + g01.price + "$, 인기순 : " + g01.rank + "위");

	}

}
class Person05{
	// 한 클래스로 여러 객체를 만들어낼 수 있다.
	String name; // 필드 선언 : 데이터를 저장하는 역할
	int age;
	Person05(String name){
		System.out.println(name);
	}
	Person05(int age){
		System.out.println(age);
	}
	Person05(String name, int age){
		System.out.println(name + age);
	}
	Person05(int age, String name){
		System.out.println(age + name);
	}
}
class Car{
	String name;
	int maxSpeed;
	int baegi;
	Car(String name){
		this.name = name;
		System.out.println("제조사 : " + name);
	}
	Car(String name, int maxSpeed){
		this.name = name;
		this.maxSpeed = maxSpeed;
		System.out.println("제조사 : " + name + ", 최고속도 : " + maxSpeed + "km");
	}
	Car(String name, int maxSpeed, int baegi){
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.baegi = baegi;
		System.out.println("제조사 : " + name + ", 최고속도 : " + maxSpeed + "km, 배기량 : " + baegi + "cc");
	}
}
class Singer{
	String name;
	String manage;
	String song;
	Singer(String name, String manage, String song){
		this.name = name;
		this.manage = manage;
		this.song = song;
	}
}
class Game{
	String name;
	int price;
	int rank;
	Game(String name, int price, int tier){
		this.name = name;
		this.price = price;
		rank = tier;
	}
}