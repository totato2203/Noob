package javaexp.a06_class;

public class A03_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자
		1. new 연산자에 의해 호출되어 객체의 초기화를 담당한다.
			new 클래스명();
			1) 필드의 값 설정
			2) 메소드를 호출해 객체를 사용할 수 있도록 준비하는 역할 수행
		2. 기본 생성자(Default Constructor)
			1) 모든 클래스는 생성자가 반드시 존재하며 하나 이상 가질 수 있다.
			2) 생성자 선언을 생략하면 컴파일러로 클래스명과 동일하고 매개변수가 없는 생성자가 추가된다.
		 */
//		Music m01 = new Music(); // Music() 생성자라고 한다.
//				default 생성자는 개발자에 의해서 생성자가 선언되는 순간 사라진다.
//				선언된 생성자에 적합하게 호출하는 경우에 사용할 수 있다.
		Music m02 = new Music("행복한 음악");
//		ex) Player 객체를 선언하고 default 생성하고 출력한 후,
//			문자열을 받아서 이름을 출력하는 생성자를 선언하고 출력하세요
		Player p01 = new Player("고길동");
		Player p02 = new Player(); // default 생성자를 호출
		System.out.println(p02);

	}

}
class Player{
	Player(){
	System.out.println("ㅇㅇ");
	}
	Player(String name){
		System.out.println("입력받은 값 : " + name);
	}
}
class Music{
	// 코드로 생성자를 선언하지 않을 때는 내부적으로 컴파일 시,
	// Music(){}
	// 코드로 생성자를 선언하는 순간 default 생성자는 사라진다.
	Music(String name){
		System.out.println("입력받은 값 : " + name);
	}
}