package javaexp.a12_collections;

import java.util.HashSet;
import java.util.Set;

public class A02_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# Set
		1. 컬렉션의 특징
			1) 수학의 집합에 비유
			2) 저장 순서가 유지되지 않음
			3) 객체를 중복 저장 불가
			4) 하나의 null만 저장 가능
		2. 구현 클래스
			HashSet, LinkedHashSet, TreeSet
		3. 주요 메소드
			add()
			contains()
			isEmpty
			Interator<E> iterator()
			size()
			clear()
			remove(Object)
		 */
		// 상위 인터페이스 = 하위 실제 객체
		Set<String> set = new HashSet<String>();
		set.add("사과");
		set.add("사과");
		set.add("사과");
		set.add("바나나");
		set.add("바나나");
		set.add("딸기");
		set.add("딸기");
		set.add("딸기");
		set.add("딸기");
		set.add("오렌지");
		set.add("오렌지");
		set.add("수박");
		set.add("수박");
		set.add("수박");
		// 중복이 제거되고 순서를 확보하지 못한다.
		for(String fruit : set) {
			System.out.println(fruit);
		}
		// ex) 주머니 속에 구슬 빨강 2개, 파랑 3개, 노랑 2개를
		//		Set으로 할당하고 for문을 통해서 출력하세요.
		Set<String> goosle = new HashSet<String>();
		goosle.add("빨강");
		goosle.add("빨강");
		goosle.add("파랑");
		goosle.add("파랑");
		goosle.add("파랑");
		goosle.add("노랑");
		goosle.add("노랑");
		for(String gs : goosle) {
			System.out.println(gs);
		}

	}

}
