package javaexp.a09_inherit;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 상속
		1. 상속 개념과 활용
			1) 상속의 효과
				- 부모 클래스 재사용해 자식 클래스 빨리 개발 가능
				- 반복된 코드 중복 줄임
				- 유지 보수 편리성 제공
				- 객체 다형성 구현 기능
				ex) 공통적인 DB접근 class를 만들고
					상속받아서 DB서버별로(oracle, mysql, mssql, ...)
					맞는 처리 class를 선언하여 활용
			2) 상속 대상 제한
				- 부모 클래스의 private 접근 갖는 필드와 메소드 제외
					private 자체가 해당 클래스에서만 사용할 수 있고,
					직접적인 접근 및 처리를 하지는 못한다.
					단, 간접적으로 다른 메서드나 생성자를 통해 접근은 가능하다.
				- 부모 클래스가 다른 패키지에 있을 경우, default 접근 갖는 필드와 메서드도 제외
		2. 상속 처리 기본 형식
			1) extends 키워드 활용
				자식 클래스가 상속할 부모 클래스를 지정하는 키워드
					class 부모{}
					class 자식 extends 부모{}
		 */
		Father f = new Father();
		System.out.println(f.shape);
		f.show();
		System.out.println("# 상속받은 아들 객체 #");
		Son s1 = new Son();
		System.out.println(s1.shape);
		s1.show();
		System.out.println("추가 기능 필드 : " + s1.running);
		// ex) Mother : 필드 : 요리를 잘한다. 온화하다.	메서드 : 위 내용을 출력
		//		상속받은 Daughter 필드 : 수영을 잘한다. 메서드 : 수영을 잘한다. 출력
		Mother m = new Mother();
		System.out.println(m.cook);
		m.show1();
		Daughter d = new Daughter();
		System.out.println(d.swim);
		System.out.println(d.cook);
		d.show2();

	}

}
class Mother{
	String cook = "요리를 잘한다.";
	String crt = "온화하다.";
	void show1() {
		System.out.println("요리 : " + cook);
		System.out.println("성격 : " + crt);
	}
}
class Daughter extends Mother{
	String swim = "수영을 잘한다.";
	Daughter(){}
	// 자신이 선언한 것과 동일하게 호출하여 사용할 수 있다. (주의 - 접근범위 안에서)
	void show2() {		
		// cook은 상속 받았기 때문에 스스로 선언했던 것과 동일하게 사용이 가능하다.
		System.out.println("수영 : " + swim);
		System.out.println("요리 : " + cook);
		show1(); // 상위 선언된 메서드 호출 사용
	}
}
class Father{
	String shape = "통통하다.";
	String height = "키가 큰 편이다.";
	void show() {
		System.out.println("모습 : " + shape);
		System.out.println("키 : " + height);
	}
}
class Son extends Father{
	String running = "달리기를 잘한다.";
}