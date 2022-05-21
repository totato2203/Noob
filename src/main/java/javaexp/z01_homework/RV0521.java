package javaexp.z01_homework;

public class RV0521 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a09_inherit
		
		Dad01 d01 = new Dad01();
		System.out.println("Dad01 클래스");
		d01.show01();
		d01.show02();
		System.out.println(d01.getJob()); // null
		Dad01 d02 = new Dad01("casher");
		System.out.println(d02.getJob());
		Dad01 d03 = new Dad01("painter");
		System.out.println(d03.getJob());

		Son01 s01 = new Son01();
		System.out.println("Son01 클래스");
		s01.show01(); // Son01 클래스에 아무것도 없어도 Dad01의 메소드를 상속받아서 사용할 수 있다.
		s01.show02(); // private은 다른 메소드를 통해 간접적으로 사용할 수 있다.
		System.out.println(s01.getJob());
		Son01 s02 = new Son01("soccer player");
		System.out.println(s02.getJob());
		
		d01.working();
		s01.working(); // Override 하여 상속된 메소드를 변경
		
		EVE ev01 = new EVE();
		ev01.elem();
		EVE ev02 = new FireEVE();
		ev02.elem();
		EVE ev03 = new IceEVE();
		ev03.elem();
		
		Tree[] tr = {
				new OakTree(),
//				new Tree(), 추상 클래스는 스스로 생성될 수 없다.
				new PaperTree()
				};
		for(Tree trs : tr) {
			trs.use();
			trs.cut();
		}
		
		Mech me = new Mech();
		me.moving();
		me.brainTest();
		me.setMove(new Wheel());
		me.setBrain(new GoodBrain());
		me.moving();
		me.brainTest();
		me.setMove(new Wing());
		me.setBrain(new BadBrain());
		me.moving();
		me.brainTest();
	}

}
class Mech{
	private Move mv;
	private Brain br;
	public void setMove(Move mv) {
		this.mv = mv;
	}
	public void setBrain(Brain br) {
		this.br = br;
	}
	public void moving() {
		if(mv != null) {
			System.out.println("System : 이동 시작.");
			mv.move();
		}else {
		System.out.println("추가 이동장치가 없어서 걸어갑니다.");
		}
	}
	public void brainTest() {
		if(mv != null) {
			System.out.println("System : 뇌 테스트 시작.");
			br.brain();
		}else {
			System.out.println("뇌가 장착되어 있지 않습니다.");
		}

	}
}
interface Move{
	void move();
}
class Wheel implements Move{
	@Override
	public void move() {
		System.out.println("바퀴로 굴러갑니다.");
	}
}
class Wing implements Move{
	@Override
	public void move() {
		System.out.println("날개로 날아갑니다.");
	}
}
interface Brain{
	void brain();
}
class GoodBrain implements Brain{
	@Override
	public void brain() {
		System.out.println("뇌의 성능이 아주 우수합니다.");
	}
}
class BadBrain implements Brain{
	@Override
	public void brain() {
		System.out.println("뇌의 성능이 아주 구립니다.");
	}
}

abstract class Tree{
	abstract void use();
	private String name;
	public Tree(String name) {
		this.name = name;
	}
	public void cut() {
		System.out.println("잘리는 " + name);
	}
}
class OakTree extends Tree{
	public OakTree () {
		super("오크나무");
	}
	@Override
	void use() {
		System.out.print("책상이 되기 위해 ");
	}
}
class PaperTree extends Tree{
	public PaperTree() {
		super("종이나무");
	}
	@Override
	void use() {
		System.out.print("종이가 되기 위해 ");
	}
}
class EVE{
	public void elem() {
		System.out.println("이브이는 노말 속성입니다.");
	}
}
class FireEVE extends EVE {
	@Override
	public void elem() {
		System.out.println("불브이는 불 속성입니다.");
	}
}
class IceEVE extends EVE {
	@Override
	public void elem() {
		System.out.println("얼브이는 얼음 속성입니다.");
	}
}

class Dad01 {
	String blood = "B";
	String lastName = "Kim";
	private String hobby = "게임";
	private String job;
	public Dad01() {}
	public Dad01(String job) {
		this.job = job;
	}
	public String getJob() {
		return job;
	}
	public void show01() {
		System.out.println(blood + "\t" + lastName);
	}
	public void show02() {
		System.out.println(blood + "\t" + lastName + "\t" + hobby);
	}
	public void working() {
		System.out.println("아빠는 열심히 일합니다.");
	}

}
class Son01 extends Dad01 {
	public Son01() {
		super("Doctor"); // 항상 생성자 첫 줄에 위치해야 한다.
	}
	public Son01(String job) {
		super(job);
	}
	@Override // 오버라이딩 문법에 맞아서 회색
	public void working() {
		System.out.println("아들은 띵까띵까 놉니다."); // 오버라이딩을 통해 상속받은 메소드 내용 변경
	}
}