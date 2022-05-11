package javaexp.a07_multiObj;

import java.util.ArrayList;

public class A02_ArrayList_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 동적인 객체형 배열 ArrayList를 통한 객체형 배열 처리
		1. 모든 배열은 초기 크기가 정해지면 변경이 불가능하다.
		2. 유동적으로 변경이 가능한 api에 있는 객체가 ArrayList이다.
			자바에서는 기본적으로 api java.lang.* 하위에 있는 패키지나 클래스는
			그대로 사용이 가능하지만 이외의 package에 있는 클래스나 객체에 대해서는 import 하여야 한다.
		3. 기본형식
			ArrayList<단위객체타입> 참조값 = new ArrayList<단위객체타입>();
			참조값.add(new 생성자());	// 객체를 생성함과 동시에 하나의 객체에 할당
			참조값.get(0);	// index 번호를 통해 특정한 위치에 있는 객체를 가지고 온다.
			참조값.size();	// 동적배열의 크기를 가져온다.
			참조값.set(특정index, 변경할객체); // 해당 위치에 있는 객체를 변경 처리한다.
			참조값.remove(index번호);	// 특정한 위치에 있는 객체를 삭제
				ex) 5짜리 중간에 하나를 삭제하면 삭제된 위치로 이후 객체들을 다시 할당하여 크기가 4개로 변경된다.
		 */
		ArrayList<Player> plist = new ArrayList<Player>();
		plist.add(new Player("삼성", "피렐라", 0.398));
		plist.add(new Player("LG", "문성주", 0.381));
		plist.add(new Player("롯데", "한동희", 0.373));
		for(int idx = 0; idx < plist.size(); idx++) {
			plist.get(idx).showInfo();
		}
		System.out.println();
		for(Player p : plist) {
			p.showInfo();
		}
		// ex) Singer 가수이름 소속사 대표곡 singing()를 통해서 @@가 @@을 부르다.
		ArrayList<Singer> slist = new ArrayList<Singer>();
		slist.add(new Singer("IU", "EDAM", "좋은 날"));
		slist.add(new Singer("GD", "YG", "삐딱하게"));
		slist.add(new Singer("TWICE", "JYP", "Cheer up"));
		for(Singer s : slist) { // forEach : for(단위객체 : 배열형객체)
			s.singing();
		}

	}

}
class Singer{
	String sname;
	String ent;
	String mainsong;
	public Singer(String sname, String ent, String mainsong) {
		super();
		this.sname = sname;
		this.ent = ent;
		this.mainsong = mainsong;
	}
	void singing() {
		System.out.println(sname + "가 " + mainsong + "을 부르다.");
	}
}
class Player{
	String tname;
	String name;
	double record;
	public Player(String tname, String name, double record) {
		super();
		this.tname = tname;
		this.name = name;
		this.record = record;
	}
	void showInfo() {
		System.out.println(tname + "\t" + name + "\t" + record);
	}
}