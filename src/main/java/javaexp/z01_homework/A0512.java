package javaexp.z01_homework;

public class A0512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-12
//		[1단계:개념] 1. protected의 접근 범위에 대하여 예제를 통하여 기술하세요
		// class MyInfo 참고
		
//		[1단계:개념] 2. 다형성을 오버라이딩과 함께 기본 예제를 통하여 설명하세요.
		Child tc = new Teacher(); 
		tc.working(); // working()을 오버라이딩하여 추가된 문장 출력
		Child gn = new Gang();
		gn.working();
		// 다형성은 같은 타입에 실행 결과가 다양한 객체를 대입할 수 있는 성질을 말한다.
		
//		[1단계:확인] 3. 상위 컴퓨터 부품(ComPart), 하위 Ram, Hdd, Cpu롤 선언하여
//					fuction메서드를 통해 해당 기능을 출력하게 선언하고 다양한 기능이 처리되게 하세요..
		ComPart cp01 = new Ram();
		ComPart cp02 = new Hdd();
		ComPart cp03 = new Cpu();
		cp01.function();
		cp02.function();
		cp03.function();
		
//		[1단계:개념] 4. 추상 클래스의 특징을 기술하세요. 
		
		// 추상 클래스는 실체 클래스들의 공통되는 필드와 메소드를 정의하는 클래스로서,
		// 실체 클래스의 부모 클래스 역할만 할 뿐 단독 객체로서 사용할 수는 없다.
		// 클래스에 추상 메소드가 하나라도 있으면 그 클래스는 추상 클래스로 선언되어야 한다. 추상 메소드는 재정의가 목적이라 body가 없다.
		// 추상 클래스가 가지고 있는 추상 메소드는 상속받은 하위 클래스에서 반드시 재정의 해야한다.
		// 추상 클래스는 혼자 생성하지 못하고, 다형성에 의해서 생성할 수 있다.
		//		추상클래스 참조 = new 추상클래스(); 형식이 아닌
		//		추상클래스 참조 = new 하위실체클래스(); 형식으로 선언한다.
		
//		[1단계:확인] 5. 추상/구상클래스 선언하되, 추상클래스 Robot : 필드로 로봇종류,
//					추상메서드 attack(), 공통메서드 move() 선언하여 처리되게 하세요.
		Robot01 rb01 = new PunchRobot();
		rb01.move();
		rb01.attack();
		Robot01 rb02 = new LaserRobot();
		rb02.move();
		rb02.attack();
		
//		[1단계:개념] 6. 인터페이스의 역할을 기술하세요
		// 인터페이스는 개발 코드가 객체에 종속되지 않은 채 객체를 변경할 수 있도록 돕고
		//	개발 코드의 변경 없이 리턴값이나 실행 내용이 다양해질 수 있게 돕는 역할을 한다.
		
//		[1단계:확인] 7. 인터페이스로 SoundWay 추상메서드 sound(), 하위상속클래스 NormalSound(꽥꽥꽥), EleSound(삑삑삑) 처리하고, 
//					Duck클래스에 SoundWay를 필드로 선언 setSound(SoundWay sw)를 통해서 할당하고
//					duckSound()메서드를 통해서 출력처리하게 하세요.
		Duck ds = new Duck();
		ds.setSound(new NormalSound());
		ds.duckSound();
		ds.setSound(new EleSound());
		ds.duckSound();

	}

}
class Duck{
	private SoundWay sw;
	public void setSound(SoundWay sw) {
		this.sw = sw;
	}
	public void duckSound() {
		sw.sound();
	}
}
interface SoundWay {
	void sound();
}
class NormalSound implements SoundWay{
	@Override
	public void sound() {
		System.out.println("꽥꽥꽥");
	}
}
class EleSound implements SoundWay{
	@Override
	public void sound() {
		System.out.println("삑삑삑");
	}
}

abstract class Robot01{
	private String kind;
	public Robot01(String kind) {
		this.kind = kind;
	}
	public abstract void attack();
	public void move() {
		System.out.println(kind + "이 이동합니다!!");
	}
	public String getKind() {
		return kind;
	}
}
class PunchRobot extends Robot01 {
	public PunchRobot() {
		super("펀치로봇");
	}
	public void attack() {
		System.out.println(getKind() + "은 펀치 공격을 합니다!!");
	}
}
class LaserRobot extends Robot01 {
	public LaserRobot() {
		super("레이저로봇");
	}
	public void attack() {
		System.out.println(getKind() + "은 레이저 공격을 합니다!!");
	}
}


class ComPart{
	private String pname;
	public ComPart(String pname) {
		this.pname = pname;
	}
	public void function() {
		System.out.print("컴퓨터 부품 중 " + pname + " 부품은 ");
	}
	public String getPname() {
		return pname;
	}
}
class Ram extends ComPart{

	public Ram() {
		super("RAM");
	}
	@Override
	public void function() {
		super.function();
		System.out.println(" 이런저런 기능을 갖고 있다.");
	}
	
}
class Hdd extends ComPart{

	public Hdd() {
		super("HDD");
	}
	@Override
	public void function() {
		super.function();
		System.out.println(" 여차저차한 기능을 갖고 있다.");
	}
	
}
class Cpu extends ComPart{

	public Cpu() {
		super("CPU");
	}
	@Override
	public void function() {
		super.function();
		System.out.println(" 이러쿵저러쿵한 기능을 갖고 있다.");
	}
	
}

class Child{
	private String job;
	public Child(String job) {
		this.job= job;
	}
	public void working() {
		System.out.println(job + "이 되고 싶은 아이");
	}
	public String getJob() {
		return job;
	}
}
class Teacher extends Child{
	public Teacher() {
		super("선생님");
	}
	@Override
	public void working() {
		super.working();
		System.out.println(getJob() + "은 학생을 가르칩니다.");
	}
}
class Gang extends Child{
	public Gang() {
		super("건달");
	}
	@Override
	public void working() {
		super.working();
		System.out.println(getJob() + "은 사람을 패는 게 일입니다.");
	}
}

class MyInfo{
	private String privInfo = "나는 사실 살인마야"; // MyInfo 클래스 안에서만 사용가능
	String deftInfo = "우리집 생활비는 100만원이야"; // javaexp.z01_homework 패키지 안에서만 사용가능
	protected String protInfo = "내 아들몫 유산은 500억원을 남긴다."; // 외부 패키지더라도 MyInfo를 상속 받은 클래스라면 사용가능
	public String publInfo = "나는 마카롱을 좋아해"; // 외부 패키지더라도 import 하면 사용가능
}

