package javaexp.a09_inherit;

public class A03_Overriding {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메소드 재정의(overriding)
		1. 부모 클래스의 상속 메소드를 자식 클래스에서 수정하여 재정의 하는 것
			==> 다형성 처리(효과를 알 수 있음)
		2. 메소드 재정의 조건
			1) 부모 클래스의 메소드와 동일한 메소드명을 가져야 한다.
			2) 접근 제한을 더 강하게 오버라이딩 하는 것은 불가하다.
				상위 default(X) ==> 하위 default(X), protected, public
				상위 protected ==> 하위 protected, public
				상위 public ==> 하위 public
				// private은 어차피 상속 못함
		3. @Override 어노테이션
			컴파일러에게 부모 클래스의 메소드 선언부와 동일한지 검사 지시
			정확한 메소드 재정의를 위해 붙여주면 된다.
			ex) 해당 내용을 선언하고, 오기나 잘못된 메소드 표기 시 오버라이딩 할 때까지 에러가 표기된다.
		4. 메소드 재정의 효과
			1) 부모 메소드는 숨겨지는 효과 발생
				- 재정의된 자식 메소드 실행
				- 부모의 원래 메소드를 실행할 땐 super.메소드명(){}
		 */
		Soldier s1 = new Soldier();
		s1.working();
		TaxiDriver td = new TaxiDriver();
		td.working();
		/*
		ex) 재정의 상위 클래스로 Company 선언하고 회사명, earnMoney() 재정의한 메소드
			SamsungEle, HydaiHM
		 */
		Company c = new Company("노가다판");
		c.earnMoney();
		SamsungEle se1 = new SamsungEle();
		SamsungEle se2 = new SamsungEle("삼전");
		se1.earnMoney();
		se2.earnMoney();
		
		HydaiHM hd1 = new HydaiHM();
		HydaiHM hd2 = new HydaiHM("현중");
		hd1.earnMoney();
		hd2.earnMoney();

	}

}
class Company{
	private String comp;
	public Company(String comp) {
		this.comp = comp;
	}
	public void earnMoney() {
		System.out.println(comp + "에서 돈을 법니다!");
	}
}
class SamsungEle extends Company {
	public SamsungEle(String comp) {
		super(comp);
	}
	public SamsungEle() {
		super("삼성전자");
	}
	// @Override를 선언하면 재정의 메서드인지를 확인하여 컴파일 시 체크해준다.
	@Override // earnMoney()는 오버라이딩 문법이 맞기 때문에 에러가 발생하지 않는다.
	// 만약 earnMoney()가 아닌 earnMoney01() 이었다면 오버라이딩 문법에 맞지 않아 에러 발생
	public void earnMoney() {
		super.earnMoney();
		// 재정의 하였기 때문에 부모클래스가 선언한 메서드와 동일한 메서드를 가지고 있다.
		// 부모의 메서드 내용을 구분하여 호출할 때, super.를 활용한다.
		System.out.println("삼성전자에서 반도체 만들며 돈 법니다!");
	}
}
class HydaiHM extends Company{
	public HydaiHM(String comp) {
		super(comp);
	}
	public HydaiHM() {
		super("현대중공업");
	}
	public void earnMoney() {
		super.earnMoney();
		System.out.println("현대중공업에서 돈 법니다!");
	}
}
	

class Worker01{
	private String kind;
	public Worker01(String kind) {
		this.kind = kind;
	}
	public void working() {
		System.out.println(kind + "일을 합니다!");
	}
}
class Soldier extends Worker01{

	public Soldier() {
		super("군인");
		// TODO Auto-generated constructor stub
	}
	// 재정의 : 동일한 메서드를 정의
	public void working() {
		super.working(); // 현재 정의된 클래스와 상위 클래스를 구분하도록 super.를 활용
		System.out.println("나라를 지킵니다!!");
	}
	
}
class TaxiDriver extends Worker01{

	public TaxiDriver() {
		super("택시운전기사");
		// TODO Auto-generated constructor stub
	}

	public TaxiDriver(String kind) {
		super(kind);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		super.working();
		System.out.println("택시로 운행을 합니다!!");
	}
	
}