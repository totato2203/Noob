package javaexp.z01_homework;

import java.util.ArrayList;

public class A0511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[1단계:개념] 1. 1:1관계 클래스와 1:다관계 클래스를 구현할 때, 구조상/코드상 차이점을 기술하세요. 
		// 1) 1:1 관계 : 종속되는 클래스를 선언하여 필드와 메서드를 입력하고 포함하는 클래스를 선언한다.
		//				한 클래스에 다른 한 클래스만 종속된다.
		// 2) 1:다 관계 : 하나의 클래스 안에 같은 종류 혹은 다른 종류의 클래스를 선언 및 호출한다.
		//				한 클래스에 다른 여러 클래스가 종속될 수 있고, 종속된 여러 클래스들을 확인할 때 반복문을 활용한다.
		
//		[1단계:개념] 2. 1:다관계 클래스 구현할 때, 간단한 예제와 함께 구현 순서를 기술하세요.
		
		
//		[1단계:확인] 3. 아래의 여러가지 1:다 관계 클래스를 선언하고 출력하세요.
//		         1) 버스, 버스에 탄 승객
		Bus01 b01 = new Bus01(1);
		b01.BusResult();
		b01.ridePerson(new BusPerson("김철수", 15, "학생"));
		b01.ridePerson(new BusPerson("송영희", 40, "주부"));
		b01.ridePerson(new BusPerson("최백수", 26, "취준생"));
		b01.ridePerson(new BusPerson("도민호", 32, "배우"));
		b01.BusResult();
//		         2) 담당교수, 수강 학생
		Professor pf01 = new Professor("김상균");
		pf01.pfResult();
		pf01.addStudent(new Student01("전장호", 201610677, "B"));
		pf01.addStudent(new Student01("김선희", 201610658, "A+"));
		pf01.addStudent(new Student01("박성진", 200810534, "A"));
		pf01.pfResult();
//		         3) 기차, 기차 좌석정보
		Train t01 = new Train("KTX");
		t01.TrainResult();
		t01.addTrainBlock(new TrainSeat(1, 20));
		t01.addTrainBlock(new TrainSeat(2, 20));
		t01.addTrainBlock(new TrainSeat(3, 200));
		t01.addTrainBlock(new TrainSeat(4, 40));
		t01.TrainResult();
		
//		[1단계:개념] 4. 상속의 한계에 대하여 예제와 함께 기술하세요
		// private 접근제한자를 갖는 필드와 메소드 : private은 해당 클래스 안에서만 사용할 수 있기에 직접적인 접근 및 처리가 불가능하다.
		//									단, 다른 메소드나 생성자를 통ㅇ해 간접적인 접근은 가능하다.
		// 부모 클래스가 다른 패키지에 있을 경우에는 default 접근제한자를 갖는 필드와 메소드 또한 상속 받을 수 없다.
		
//			class Train01 extends Train{
//				Train01(){
////				System.out.println(tName); // 에러 발생 : private 접근제한자를 갖는 tName은 상속되지 않는다.
//				}
//			}
		
		
//		[1단계:확인] 5. 상위로 탈것(속도)을 선언하고, 이것을 상속받은 하위로 자동차(승객수), 
//		      트럭(중량)를 선언하고 출력하는 메서드를 통해서 출력처리하세요.
		Vehicle vh = new Vehicle(100);
		vh.Spec();
		Car01 c01 = new Car01(200);
		c01.Spec();
		Truck tr = new Truck(80);
		tr.Spec();
		
//		[1단계:개념] 6. 상속 관계에서 super()가 생성자관계에서 사용하는 규칙을 기본 예제를 통해서
//		      기술하세요.
		// 상속받는 클래스는 반드시 부모 클래스의 생성자를 호출해야한다.
		// default 생성자는 기본적인 default 생성자를 호출하기 때문에 선언하지 않더라도 에러가 없지만
		// 상위 클래스에서 매개변수가 있는 생성자를 선언했을 때엔 super()을 사용하여 부모 클래스의 생성자를 호출해야한다.
		PersonA ps01 = new PersonA(); // 에러 없이 "매개변수 없는 상속" 출력
		PersonA ps02 = new PersonA("아시안"); // super(race);을 사용하지 않으면 "매개변수 없는 상속" 출력
		// super(race); 을 사용하면 "나는 아시안 인종이다." 출력
		
//		[1단계:확인] 7. 상위로 Robot을 생성자로 로봇의 종류를 할당하게 하고, Dagan, Gandam을
//		      상속하여 해당 생성자를 통해서 호출하여 처리하고 출력되게 하세요.
		Dagan dg = new Dagan("다간");
		dg.kindResult();
		Gandam gd = new Gandam("간담");
		gd.kindResult();
		
//		[1단계:개념] 8. 메서드 재정의 규칙을 기본예제를 통해서 설명하세요.
		// 부모 클래스의 메소드와 동일한 메소드명을 가져야하고 접근 제한을 더 강하게 오버라이딩 하는 것은 불가능하다.
		// 상위 클래스인 Robot의 public void kindResult(){}를
		// 하위 클래스인 Dagan에서 public void kindResult(){}로 재정의하는 것은 가능하지만
		// Dagan에서 default(X) void kindResult(){}로 재정의하는 것은 불가능하다.
		
//		[1단계:확인] 9. 상위클래스 Vehicle를 선언하고 필드로 탈것의 종류 선언, 재정의 
//		      메서드로 driving()을 선언하여 하위로 Airplane,
//		      Bus, Ship에서 재정의하여 처리하게 하세요.
		Vehicle01 vh01 = new Vehicle01("오토바이");
		vh01.driving();
		Airplane ap = new Airplane("비행기");
		ap.driving();
		Bus02 b02 = new Bus02("버스");
		b02.driving();
		Ship sh = new Ship("배");
		sh.driving();

	}

}
class Vehicle01{
	private String vhKind;
	public Vehicle01(String vhKind) {
		this.vhKind = vhKind;
	}
	public void driving() {
		System.out.println(vhKind + " 타고 드라이브 하니까 좋다~");
	}
	public String getvhKind() {
		return vhKind;
	}
}
class Airplane extends Vehicle01{
	public Airplane(String vhKind) {
		super(vhKind);
	}
	public void driving() {
		super.driving();
		System.out.println(getvhKind() + "는 높아!");
	}
}
class Bus02 extends Vehicle01{
	public Bus02(String vhKind) {
		super(vhKind);
	}
	public void driving() {
		System.out.println(getvhKind() + "는 길어!");
	}
}
class Ship extends Vehicle01{
	public Ship(String vhKind) {
		super(vhKind);
	}
	public void driving() {
		System.out.println(getvhKind() + "는 바다를 갈라!");
	}
	
}

class Robot{
	private String rKind;
	public Robot(String rKind){
		this.rKind = rKind;
	}
	public void kindResult() {
		System.out.println("로봇의 종류 : " + rKind);
	}
}
class Dagan extends Robot{
	public Dagan(String rKind) {
		super(rKind);
	}
	public void kindResult() {
		super.kindResult();
	}
}
class Gandam extends Robot{
	public Gandam(String rKind) {
		super(rKind);
	}
	public void kindResult() {
		super.kindResult();
	}
}

class People{
	String race;
	People(){
		System.out.println("매개변수 없는 상속");
	}
	People(String race){
		System.out.println("나는 " + race + " 인종이다.");
	}
}
class PersonA extends People{
	PersonA(){}
	PersonA(String race){
		super(race);
	}
}

class Vehicle{
	private int speed;
	public Vehicle(int speed){
		this.speed = speed;
	}
	public void Spec() {
		System.out.println("속도 : " + speed + " km/h");
	}
}
class Car01 extends Vehicle{
	private int pCnt = 4;
	public Car01(int speed) {
		super(speed);
	}
	public void Spec() {
		super.Spec();
		System.out.println("탑승객 수 : " + pCnt);
	}
}
class Truck extends Vehicle{
	private int weight = 2;
	public Truck(int speed) {
		super(speed);
	}
	public void Spec() {
		super.Spec();
		System.out.println("중량 : " + weight + "t");
	}
}

class TrainSeat{
	private int tNum;
	private int tSeatCnt;
	
	public TrainSeat() {}
	public TrainSeat(int tNum, int tSeatCnt) {
		this.tNum = tNum;
		this.tSeatCnt = tSeatCnt;
	}
	public void show() {
		System.out.println("기차 칸번호 : " + tNum);
		System.out.println("칸 좌석 수 : " + tSeatCnt);
	}
	public int gettNum() {
		return tNum;
	}
	public int gettSeatCnt() {
		return tSeatCnt;
	}
}
class Train{
	private String tName;
	private ArrayList<TrainSeat> tlist;
	
	public Train() {
		tlist = new ArrayList<TrainSeat>();
	}
	public Train(String tName) {
		this.tName = tName;
		tlist = new ArrayList<TrainSeat>();
	}
	public void addTrainBlock(TrainSeat ts) {
		tlist.add(ts);
		System.out.println(tName + "에 " + ts.gettNum() + "번 칸 결합 완료");
	}
	public void TrainResult() {
		if(tlist.size() > 0) {
			int totSeat = 0; // 총 좌석 수
			System.out.println("# " + tName + "의 총 좌석 수 계산 #");
			for(TrainSeat ts : tlist) {
				ts.show();
				totSeat += ts.gettSeatCnt();
			}
			System.out.println(tName + "의 총 좌석 수 : " + totSeat);
		}else {
			System.out.println(tName + "에는 결합된 칸이 없어서 좌석 또한 없습니다.");
		}
	}
}

class Student01{
	private String sName;
	private int sNum;
	private String sGrade;
	
	public Student01() {}
	public Student01(String sName, int sNum, String sGrade) {
		this.sName = sName;
		this.sNum = sNum;
		this.sGrade = sGrade;
	}
	public void show() {
		System.out.print(sName + "\t");
		System.out.print(sNum + "\t");
		System.out.print(sGrade + "\n");
	}
	public String getsName() {
		return sName;
	}
}
class Professor{
	private String pfName;
	private ArrayList<Student01> slist;
	public Professor() {
		slist = new ArrayList<Student01>();
	}
	public Professor(String pfName) {
		this.pfName = pfName;
		slist = new ArrayList<Student01>();
	}
	public void addStudent(Student01 std) {
		slist.add(std);
		System.out.println(std.getsName() + " 학생이 " + pfName + " 교수님께 배정되었습니다.");
	}
	public void pfResult() {
		if(slist.size() > 0) {
			System.out.println("# " + pfName + " 교수님께 배정된 학생 정보 #");
			for(Student01 std : slist) {
				std.show();
			}
		}else {
			System.out.println(pfName + " 교수님께 배정된 학생이 없습니다.");
		}
	}
}

class BusPerson{
	private String pName;
	private int pAge;
	private String pJob;
	
	public BusPerson() {}
	public BusPerson(String pName, int pAge, String pJob) {
		this.pName = pName;
		this.pAge = pAge;
		this.pJob = pJob;
	}
	public void show() {
		System.out.print(pName + "\t");
		System.out.print(pAge + "세\t");
		System.out.print(pJob + "\n");
	}
	public String getpName() {
		return pName;
	}
}
class Bus01{
	private int bNum;
	private ArrayList<BusPerson> blist;
	public Bus01() {
		blist = new ArrayList<BusPerson>();
	}
	public Bus01(int bNum) {
		this.bNum = bNum;
		blist = new ArrayList<BusPerson>();
	}
	public void ridePerson(BusPerson bp) {
		blist.add(bp);
		System.out.println(bp.getpName() + " 씨가 버스에 탑승했습니다.");
	}
	public void BusResult() {
		if(blist.size() > 0) {
			System.out.println("# 버스 승객 정보 #");
			for(BusPerson bp : blist) {
				bp.show();
			}
		}else {
			System.out.println("버스에 승객이 없습니다.");
		}
	}
}