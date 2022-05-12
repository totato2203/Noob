package javaexp.a09_inherit;

public class A06_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 인터페이스란?
		1. 개발 코드와 객체가 서로 통신하는 접점
			1) 개발토드는 인터페이스의 메소드만 알고 있으면 OK
		2. 인터페이스의 역할
			1) 개발 코드가 객체에 종속되지 않은 채 객체를 교체할 수 있도록 하는 역할
				ex) Mz는 코드에 변경이 없더라도 처리가 된다.
			2) 개발 코드 변경 없이 리턴값 또는 실행 내용이 다양해 질 수 있음(다형성)
				ex) WingInf를 상속받은 Wing01().. Wing03()... 계속 다양하게 처리
		3. 인터페이스의 선언
			1) 인터페이스 이름 - 자바 식별자 작성 규칙에 따라 작성
			2) 소스 파일 생성 - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성
			3) 인터페이스 선언
				interface 인터페이스명{}
			4) 인터페이스 구성 멤버
				타입 상수명 = 값;
				타입 메소드명(매개변수...)
				default 타입 메소드명(매개변수...){}
				static 타입 메소드명(매개변수...){}
		 */
		WingInf w1 = new Wing01();
		w1.flying();
		WingInf w2 = new Wing02();
		w2.flying();
		Mz m1 = new Mz();
		m1.running();
		m1.flying();
		m1.setWing(new Wing01());
		m1.flying();
		// 날개를 통해 upgrade 할 내용을 Mz 소스 변경하지 않고
		// WingInf를 상속받은 하위 클래스를 선언하면, Mz의 날으는 기능을 계속 수행할 수 있다.
		m1.setWing(new Wing02());
		m1.flying();
		// ex1) Wing03을 선언하고, 세계를 누비다. 처리를 하고 main()에 호출하여 처리하세요.
		m1.setWing(new Wing03());
		m1.flying();
		// ex2) AttackWay 인터페이스 attack() 추상메소드 선언,
		//		상속 하위
		//		RocketAttack attack() 로켓포 발사
		//		MissileAttack attack() 미사일 발사
		//		Mz에 필드와 기능메소드로 처리하게 하세요
		m1.setAttack(new RocketAttack());
		m1.attacking();
		m1.setAttack(new MissileAttack());
		m1.attacking();

	}

}
class Mz{
	private WingInf wing; // 이를 컨트롤 할 수 있게 마징거Z 조종장치에 처리
	private AttackWay aw;
	public void setWing(WingInf wing) {	// adapter(인터페이스)를 어깨와 허리에 장착
		this.wing = wing;
	}
	public void setAttack(AttackWay aw) {
		this.aw = aw;
	}
	public void running() {
		System.out.println("MZ 뛰어 다닙니다.");
	}
	public void flying() {
		if(wing != null) {
			System.out.println("MZ 나르다!!");
			wing.flying();
		}else {
			System.out.println("날개가 장착되지 않았습니다.");
		}
	}
	public void attacking() {
		if(aw != null) {
			System.out.println("MZ 공격!!");
			aw.attack();
		}else {
			System.out.println("무기가 장착되지 않았습니다.");
		}
	}
}
interface AttackWay{
	void attack();
}
class RocketAttack implements AttackWay{
	@Override
	public void attack() {
		System.out.println("로켓포 발사!!");
	}
}
class MissileAttack implements AttackWay{
	@Override
	public void attack() {
		System.out.println("미사일 발사!!");
	}
}

interface WingInf{	// 추상 클래스의 종류 중 하나
	void flying();	// public abstract 무조건 붙음
}
class Wing01 implements WingInf{	// 인터페이스는 implements라는 키워드를 통해서 상속받음
	@Override
	public void flying() {
		System.out.println("날개 1호 우리 동네를 나르다!!");
	}
}
class Wing02 implements WingInf{	// 인터페이스는 implements라는 키워드를 통해서 상속받음
	@Override
	public void flying() {
		System.out.println("날개 2호 우리나라 창공을 나르다!!");
	}
}
class Wing03 implements WingInf{	// 인터페이스는 implements라는 키워드를 통해서 상속받음
	@Override
	public void flying() {
		System.out.println("날개 3호 세계를 누비다!!");
	}
}

/*
MZ(마징거Z)
1. 마징거Z 초기에는 뛰어다니면서 지구를 지킴
	마징거Z에 날개를 인식할 수 있는 adapter를 어깨와 허리에 장착
	이를 컨트롤 할 수 있게 마징거Z 조종장치에 처리
	
	박사는 날개(연결 adapter 포함)를 제작
2. 박사가 마징거Z 날개를 따로 만들어서 보냄

3. 날개가 마징거Z의 허리와 어깨로 날아가서 장착되고 날 수 있게 되어 지구를 지킴
4. 날개1호 ==> 날개2호 ==> 날개3호
*/