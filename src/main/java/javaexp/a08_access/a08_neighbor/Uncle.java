package javaexp.a08_access.a08_neighbor;

import javaexp.a08_access.a06_woodhome.WoodCutter;

public class Uncle {
	public void callWoodCutter() {
		WoodCutter wc = new WoodCutter();
		// 같은 패키지에 있는 클래스는 private 이외에 모두 접근 가능하다.
//		System.out.println("private : " + wc.priveSec);
//		System.out.println("default : " + wc.payOurHome);
//		System.out.println("protected : " + wc.inheritMoney);
		// 상속관계가 없는 외부 패키지의 클래스는 public만 접근 가능하다.
		System.out.println("public : " + wc.announce);
	}


}
