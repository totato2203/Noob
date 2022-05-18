package javaexp.z01_homework;

import javaexp.a07_multiObj.A06_Food;

public class RV0518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a08_access
		
		System.out.println("현재 패키지 클래스의 객체 : " + new RV0518());
		// javaexp.z01_homework.RV0518@372f7a8d
		System.out.println("다른 패키지 클래스의 객체 : " + new javaexp.a08_access.A05_Person());
		// javaexp.a08_access.A05_Person@28a418fc
		
		A06_Food fd = new A06_Food(); // import javaexp.a07_multiObj.A06_Food; 해서 사용 가능
		System.out.println(fd.name); // 짜장면 출력
		
		/*
		public : 다른 패키지라도 import 하면 클래스로 사용 가능
		protected : 다른 패키지라도 상속 받았으면 클래스로 사용 가능
		default : 같은 패키지에서만 클래스로 사용 가능
		private : 같은 클래스 안에서만 사용 가능
		 */
		
	}

}
