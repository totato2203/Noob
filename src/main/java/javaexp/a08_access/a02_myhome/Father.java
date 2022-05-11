package javaexp.a08_access.a02_myhome;

public class Father {

	void callMyInfo() {
		// 접근 제어자 X(default) 이상일 때, 호출 가능(같은 패키지일 때)
		Mine m01 = new Mine();
		
		// 같은 패키지에 있는 클래스는 private 이외에는 모두 접근이 가능
//		System.out.println(m01.myPrivInfo);
		System.out.println(m01.ourFamilyPlan);
		System.out.println(m01.mySucceInfo);
	}
}
