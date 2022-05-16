package javaexp.z01_homework;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;

public class RV0515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a07_multiObj
			Banana[] bn01 = new Banana[3];
			bn01[0] = new Banana("빨강", 1);
			bn01[1] = new Banana("노랑", 2);
			bn01[2] = new Banana("파랑", 3);
			for(int idx = 0; idx <= bn01.length-1; idx++) {
				System.out.print(bn01[idx].getKind());
				System.out.println(bn01[idx].getCnt());
			}
			
			Banana[] bn02 = {
					new Banana("분홍", 4),
					new Banana("노르스름", 5),
					new Banana("하늘", 6)
			};
			for(Banana bnbn : bn02) {
				System.out.print(bnbn.getKind());
				System.out.println(bnbn.getCnt());
			}
			
			ArrayList<Banana> blist = new ArrayList<Banana>();
			blist.add(new Banana("뻘겅", 1));
			blist.add(new Banana("누렁", 2));
			blist.add(new Banana("퍼렁", 3));
			for(Banana bnbb : blist) {
				bnbb.showInfo();
			}
			
			Banana.num = 9000;
			Banana bn03 = new Banana();
			Banana bn04 = new Banana();
			bn03.num += 100;
			bn04.num += 100;
			System.out.println(Banana.num);
			// static 변수 num은 bn03과 bn04, 각각 다른 객체에서 더했지만 둘 다 올라간 값(9200)이 출력된다.
			bn03.num = 1000;
			System.out.println(bn03.num);
			System.out.println(bn04.num);
			System.out.println(Banana.num); // 셋 모두 같은 값 1000 출력
			bn04.num = 8888;
			System.out.println(bn03.num);
			System.out.println(bn04.num);
			System.out.println(Banana.num); // 마찬가지로 8888
			
			
			System.out.println(bn03.num01);
//			bn03.num01 = 999; // final로 선언한 num01은 객체에서 바꿀 수 없다.
			
			System.out.println(bn03.REAL_COLOR); // final static으로 선언한 REAL_COLOR는 상수라고 한다.
			
			
			PersonalNum pm = new PersonalNum("123123");
			pm.searchInfo();
			pm.registerInfo(new PersonalInfo("홍길동", 25, "01012341234"));
			pm.searchInfo();
			

	}

}
class FootballPlayer{
	private String name;
	private int age;
	private int backNum;
	public FootballPlayer() {}
	public FootballPlayer(String name, int age, int backNum) {
		this.name = name;
		this.age = age;
		this.backNum = backNum;
	}
	public void showInfo() {
		System.out.print("# " + name + " 선수 정보 #");
		System.out.print("이름 : " + name + "\t");
		System.out.print("나이 : " + age + "\t");
		System.out.print("등번호 : " + backNum + "\n");
	}
}
class FootballTeam{
	private String teamName;
	private ArrayList<FootballPlayer> plist;
	public FootballTeam() {
		plist = new ArrayList<FootballPlayer>();
	}
	public FootballTeam(String teamName) {
		this.teamName = teamName;
		plist = new ArrayList<FootballPlayer>();
	}
	
}

class PersonalInfo{
	private String name;
	private int age;
	private String phoneNum;
	public PersonalInfo() {}
	public PersonalInfo(String name, int age, String phoneNum) {
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	public void showInfo() {
		System.out.println("# " + name + " 씨의 개인 정보 #");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화번호 : " + phoneNum);
	}
}
class PersonalNum{
	private String pNum;
	public PersonalInfo pi;
	public PersonalNum(String pNum) {
		this.pNum = pNum;
	}
	public void registerInfo(PersonalInfo pi) {
		this.pi = pi;
	}
	public void searchInfo() {
		if(pi == null) {
			System.out.println(pNum + "에 등록된 정보가 없습니다.");
		}else{
			pi.showInfo();
		}
	}
}
class Banana{
	String kind;
	int cnt;
	static int num;
	final int num01 = 100;
	final static String REAL_COLOR = "원래 하얀색";
	Banana() {}
	Banana(String kind, int cnt){
		this.kind = kind;
		this.cnt = cnt;
	}
	String getKind() {
		return kind;
	}
	int getCnt() {
		return cnt;
	}
	void showInfo() {
		System.out.println("바나나의 종류 : " + kind + ", 개수 : " + cnt);
	}
}