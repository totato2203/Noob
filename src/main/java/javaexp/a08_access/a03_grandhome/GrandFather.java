package javaexp.a08_access.a03_grandhome;

import javaexp.a08_access.a02_myhome.Mine;

public class GrandFather {
	void callMyInfo() {
		// 접근 제어자 X(default) 이상일 때, 호출 가능(같은 패키지일 때)
		Mine m01 = new Mine();
		
		// 같은 패키지에 있는 클래스는 private 이외에는 모두 접근이 가능
//		System.out.println(m01.myPrivInfo);
		// 패키지가 다르기 때문에 default 접근제어자(X)는 접근이 불가능
//		System.out.println(m01.ourFamilyPlan);
		// public으로 선언된 필드는 import로 사용이 가능하다.
		System.out.println(m01.mySucceInfo);
	}
}
