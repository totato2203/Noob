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
			System.out.println(Banana.num); // bn03과 bn04, 각각 다른 객체에서 더했지만 둘 다 올라간 값이 출력된다.

	}

}

class Banana{
	String kind;
	int cnt;
	static int num;
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
	void showInfo2() {
		
	}
	
}