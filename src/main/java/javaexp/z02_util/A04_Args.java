package javaexp.z02_util;

public class A04_Args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main() 실행 시 사용되는 메서드.
		// String[] args : 실행 시 외부에서 받은 데이터를 배열로 받아서 처리할 때 활용된다.
		// java A04_Args 사과 바나나 딸기
		//		위 경우에 String[] args = {"사과", "바나나", "딸기"}
		//		args[0] : "사과"
		//		args[1] : "바나나"
		//		args[2] : "딸기"
		System.out.println("# 외부 데이터 args로 받기 #");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		// java A04_Args 사과 2000 2
		// 위 경우에 String[] args = {"사과", "2000", "2"};
		//		args[] : "사과"
		//		args[] : "2000"
		//		args[] : "2"
		// args[1], args[2]는 문자열이어서 연산이 안 되므로 숫자로 형변환이 필요하다.
		String name = args[0];
		int price = Integer.parseInt(args[1]);
		int cnt = Integer.parseInt(args[2]);
		System.out.println("총비용 : " + price * cnt);

	}

}
