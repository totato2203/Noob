package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.List;

public class A0517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-17
//		[1단계:개념] 7. 기본 유형을 Wrapper 클래스로 만드는 이유를 설명하세요.
		// 기본 타입의 값은 외부에서 변경 불가능하기 때문에 객체로 변환하여,
		// 객체에게 지원하는 메소드를 통해 처리할 때 사용한다.
		
//		[1단계:확인] 8. 아래의 기본유형의 문자열을 Wrapper클래스의 valueOf 메서드를 이용해서 Wrapper클래스로 만들어 보세요.
//		                (Integer,Character,Boolean)
		Integer ob01 = Integer.valueOf(1000);
		Character ob02 = Character.valueOf('+');
		Boolean ob03 = Boolean.valueOf(true);
		System.out.println(ob01 + "\t" + ob02 + "\t" + ob03);
		
//		[1단계:개념] 9. boxing, unboxing, auto boxing/auto unboxing 개념에 대하여 기본예제로 기술하세요.
		
		Short ob04 = new Short("10"); // 생성자를 사용한 박싱
		Integer ob05 = Integer.valueOf(1000); // valueOf() 메소드를 사용한 박싱
		System.out.println(ob04 + ob05);
		
		short num04 = ob04.shortValue(); // 언박싱
		int num05 = ob05.intValue(); // 언박싱
		System.out.println(ob04 + ob05);
		
		Integer ob06 = 2000; // 자동 박싱
		List<Integer> ilist = new ArrayList<Integer>();
		ilist.add(3000); // 동적 배열을 사용한 자동 박싱
		int ob07 = ob06; // 기본 타입에 포장 객체가 대입되면 자동 언박싱
		
//		[1단계:개념] 10. 컬렉션 프레임 웍의 최상위 인터페이스 3가지와 그 특징을 기술하세요.
		// 최상위 인터페이스 : List, Set, Map
		// 특징 :
		//	1) List : 순서를 유지한 채로 저장하고 중복 저장이 가능하다.
		//	2) Set : 순서를 유지하지 않은 채로 저장하고 중복 저장이 불가능하다.
		//	3) Map : 키와 값의 쌍으로 저장되고 키는 중복저장이 불가능하다.
		
//		[1단계:확인] 11. List기능 메서드를 예제를 통하여 설명하세요
		List<String> flist = new ArrayList<String>();
		flist.add("사과");
		flist.add("바나나");
		flist.add("오렌지"); // 초기 데이터 : idx 0부터 차례대로 들어간다.
		System.out.println("\n# 초기 데이터 #");
		for(int idx = 0; idx < flist.size(); idx++) {
			System.out.println(flist.get(idx));
		}
		flist.add(1, "키위"); // 삽입 데이터 : idx 1 자리에 키위가 들어가고 바나나, 오렌지는 각 idx 2,3으로 밀려난다.
		System.out.println("\n# 삽입 데이터 #");
		for(int idx = 0; idx < flist.size(); idx++) {
			System.out.println(flist.get(idx));
		}
		flist.set(2, "딸기"); // 변경 데이터 : idx 2 자리의 바나나가 딸기로 변경된다.
		System.out.println("\n# 변경 데이터 #");
		for(int idx = 0; idx < flist.size(); idx++) {
			System.out.println(flist.get(idx));
		}
		flist.remove(3); // 삭제 데이터 : idx 3 자리의 오렌지가 삭제된다.
		System.out.println("\n# 삭제 데이터 #");
		for(int idx = 0; idx < flist.size(); idx++) {
			System.out.println(flist.get(idx));
		}
	}

}
