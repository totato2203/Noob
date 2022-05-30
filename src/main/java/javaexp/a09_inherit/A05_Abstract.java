package javaexp.a09_inherit;

public class A05_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 추상 클래스(abstract class)
		1. 추상 클래스 개념
			1) 추상(abstract)
				- 실체를 간의 공통되는 특성을 추출하는 것
				ex) 새, 곤충, 물고기 ==> 동물(추상)
					삼성, 현대, LG ==> 회사(추상)
			2) 추상 클래스(abstract class)
				- 실제 클래스들의 공통되는 필드와 메소드 정의한 클래스
				- 추상 클래스는 실제 클래스의 부모 클래스 역할(단독 객체 X)
				cf) 추상 클래스 법칙
				1. 추상 메소드(abstract)가 하나라도 있으면,
					추상 클래스(abstract class 클래스명)로 선언되어야 한다.
					ex) 추상 메소드는 재정의가 목적이기에 body({})가 없다.
				2. 추상 클래스가 가지고 있는 추상 메소드는 상속받은 하위 클래스에서 반드시 재정의 해야한다.
				3. 추상 클래스는 혼자 생성하지 못하고, 다형성에 의해서 생성할 수 있다.
					추상클래스 참조 = new 추상클래스(); (x)
					추상클래스 참조 = new 하위실체클래스(); (o)
				
		2. 추상 클래스의 용도
			1) 실체 클래스의 공통된 필드와 메소드의 이름 통일 목적
				- 실체 클래스의 설계자가 여러 사람일 경우
				- 실체 클래스마다 필드와 메소드가 제각기 다른 이름을 가질 경우
			2) 실체 클래스를 작성할 때 시간 절약
				- 실체 클래스는 추가적인 필드와 메소드만 선언
			3) 실체 클래스 설계 규격을 만들고자 할 때
				- 실체 클래스가 가져야 할 필드와 메소드를 추상 클래스에 미리 정의
				- 실체 클래스는 추상 클래스를 무조건 상속 받아 작성
		3. 기본 코드
			1) 추상 클래스 선언
				public abstract class 클래스명{
					public abstract 리턴값 메소드명();
					// 메소드명(); body({})가 없음, 하위 클래스에서 반드시 재정의 해야함.
				}
			2) 추상 클래스를 상속받은 하위 클래스(실체클래스)
				class 클래스 extends 클래스명{
					// 추상메소드는 반드시 재정의해야 한다. : (강제) - 컴파일 에러 발생
					public 리턴값 상위에선언된추상메소드(){
					
					}
				}
		 */
//		Larva01 lv01 = new Larva01(); // 추상 클래스는 혼자 객체 생성을 하지 못한다.
		Larva01 lv02 = new Mutal(); // 추상 클래스는 실체 클래스 형태로 객체 생성이 가능하다.
		Larva01 lv03 = new Ultra();
		lv02.move(); // 공통 메소드
		lv02.attack(); // 재정의 메소드
		lv03.move();
		lv03.attack();
		
		// ex) 삼성, 현대, LG ==> 회사(추상)
		// Company 추상클래스 선언, 공통메소드 : 돈을 벌다(earnMoney), 추상메소드 : working()
		Company01[] coms = {new SamsungEl(), new Hyundai(), new LG()};
		for(Company01 com : coms) {
			com.working();
			com.earnMoney();
		}
		
	}

}
abstract class Company01{
	private String name;
	public Company01(String name) {
		this.name = name;
	}
	void earnMoney() {
		System.out.println(" 돈을 버는 " + name);
	}
	String getName() {
		return name;
	}
	abstract void working();
}
class SamsungEl extends Company01{
	public SamsungEl() {
		super("삼성전자");
	}
	void working() {
		System.out.print(getName() + " : " + "반도체 만들면서");
	}
}
class Hyundai extends Company01{
	public Hyundai() {
		super("현대중공업");
	}
	void working() {
		System.out.print(getName() + " : " + "중공업 하면서");
	}
}
class LG extends Company01{
	public LG() {
		super("LG");
	}
	void working() {
		System.out.print(getName() + " : " + "가전제품 만들면서");
	}
}

abstract class Larva01{
	void move() {	// 공통 메소드
		System.out.println("이동하다.");
	}
	abstract void attack(); // body가 없는 추상 메소드
}
class Mutal extends Larva01{
	// 추상 클래스를 상속한 하위 클래스는 추상 메소드를 반드시 재정의하여야 한다.(메소드 통일을 유지가능)
	@Override
	void attack() {
		System.out.println("공중 원거리 공격하다!!");
	}
}
class Ultra extends Larva01{
	@Override
	void attack() {
		System.out.println("근접 공격하다!!");
	}
	
}