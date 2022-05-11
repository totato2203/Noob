package javaexp.a08_access.copy;

import javaexp.a08_access.a01_friendship.Deer;
import javaexp.a08_access.a01_friendship.WoodCutter;
// public 이라도 외부 패키지에 있는 클래스는 import 또는 

public class A00_Hunter {

	void callWoodCutterInfo() {
		// WoodCutter wc : public class WoodCutter
		// wc = new WoodCutter() : public WoodCutter(){}
		// wc.hiddenDeer) : default 접근제어자로 상단에 선언된 패키지가 같을 때만 접근이 가능하다.
		// A00_Hunter는 package javaexp.a08_access; 때문에
		// default 접근제어자가 붙은 hiddenDeer 필드는 접근을 할 수 없다.
		
		WoodCutter wc = null;
		wc = new WoodCutter();
//		System.out.println(wc.hiddenDeer);
		
//	void callDeerInfo() {
//			Deer d = new Deer();
//			System.out.println(d.whereWhen);
//		}
	
	}
}
