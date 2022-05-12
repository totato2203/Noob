package javaexp.z03_vo;

// 모든 클래스는 Object라는 클래스를 상속하기에 extends Object가 생략된다.
public class Person {
	private String name;
	// default 생성자
	public Person() {
		super(); // default 생성자인 Object의 생성자를 지칭
	}
	public Person(String name) {
		super();
		this.name = name;
	}
}
class PersonSub extends Person{
	public PersonSub() {
		super("홍길동");
	}
	public PersonSub(String name) {
		super(name); // 상위에 존재하는 매개변수가 있는 생성자를 반드시 호출해야한다.
	}
	/*
	default 생성자를 통해서는 상위에 있는 생성자를 호출하지 못하기 때문에 에러가 발생한다.
	public PersonSub() {
		super(); // default 생성자인 Object의 생성자를 지칭
	}
	*/
}