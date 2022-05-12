package javaexp.a09_inherit;

import java.util.ArrayList;

public class A04_Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다형성(polymorphism)
		1. 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질을 말한다.
		 	- 부모 타입에는 모든 자식 객체가 대입 가능
		 	- 자식 타입은 부모 타입으로 자동 타입 변환
		 	ex) 타이어의 공통적인 내용에서 사용 시
		 			한국타이어, 금호타이어, 광폭타이어 등 여러가지 형태로 재정의 메서드에 따라서 활용되는 것을 사용할 수 있다.
		 		컴퓨터의 부품(ComPart)이라는 공통 클래스에서
		 			Ram, Cpu, Hdd 등의 기능에 따라서 여러가지 내용을 사용할 수 있다.
		 			이 때, 상위에 있는 공통 필드나 메서드를 선언하고, 하위에 재정의하여 활용하면 프로그램을 효과적으로 처리할 수 있다.
		 			
		2. 자동 타입 변환(promotion)
			- 프로그램 실행 도중에 자동 타입 변환이 일어나는 것
				부모클래스 변수 = 자식클래스타입
				class Animal{}
				class Cat extends Animal{}
				Animal an01 = new Cat();
				
		ex) 상위 Animal 메서드 sound() 재정의
			하위 Cat, Dog, Bird
			다형성 처리로 출력하세요
		 */
		Animal m1 = new Cat();
		m1.sound();
		m1.eatFood();
		Animal m2 = new Dog();
		m2.sound();
		Animal m3 = new Bird();
		m3.sound();
		ArrayList<Animal> mList = new ArrayList<Animal>();
		mList.add(new Cat());
		mList.add(new Dog());
		mList.add(new Bird());
		System.out.println("# 다중의 객체의 기능을 배열로 처리 #");
		for(Animal m : mList) {
			m.eatFood(); m.sound();
		}
		System.out.println("임의의 객체 호출");
		int ranIdx = (int)(Math.random()*3);
		mList.get(ranIdx).sound();
		
		// 부모객체가 형변환이 일어나서 하위객채로 생성
		Larva l1 = new Drone();
		l1.attack();
		Larva l2 = new Zergling();
		l2.attack();
		Larva l3 = new Hydralisk();
		l3.attack();
		// ex) 상속으로 Hydra 클래스를 선언하고
		// attack() 메서드로 "공격력 +3로 원거리" 를 출력하세요.

	}

}
class Animal{
	private String kind;
	public Animal(String kind) {
		this.kind = kind;
	}
	public void eatFood() { // 공통 기능 메서드
		System.out.println(kind + "가 음식을 먹다.");
	}
	public void sound() { // 하위에서 다양하게 처리할 메서드
		System.out.print(kind + "의 울음소리 : ");
	}
}
class Cat extends Animal{
	public Cat() {
		super("고양이");
	}
	@Override
	public void sound() {
		super.sound();
		System.out.println("야옹야옹");
	}
}
class Dog extends Animal{
	public Dog() {
		super("강아지");
	}
	@Override
	public void sound() {
		super.sound();
		System.out.println("멍멍");
	}
}
class Bird extends Animal{
	public Bird() {
		super("새");
	}
	public void sound() {
		super.sound();
		System.out.println("짹짹");
	}
}
// Starcraft
// - Zerg(외계종족 - 파충류)
//	Larva	== > Drone
//			== > Zergling
//			== > Hydralisk

class Larva{
	public void attack() {
		System.out.println("공격을 하다.");
	}
}
class Drone extends Larva{
	@Override
	public void attack() {
		super.attack();
		System.out.println("공격력 +1로 원거리");
	}
}
class Zergling extends Larva{
	@Override
	public void attack() {
		super.attack();
		System.out.println("공격력 +1로 빠르게 근거리");
	}
}
class Hydralisk extends Larva{
	@Override
	public void attack() {
		super.attack();
		System.out.println("공격력 +3로 원거리");
	}
}