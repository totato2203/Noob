package javaexp.a12_collections;

import java.util.ArrayList;
import java.util.List;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 컬렉션 프레임워크
		1. 컬렉션 : 사전적 의미로 요소(객체)를 수집해 저장하는 것을 말한다.
		2. 배열의 문제점
			1) 저장할 수 있는 객체 수가 배열을 생성할 때 결정
				==> 불특정 다수의 객체를 저장하기에는 문제
			2) 객체 삭제했을 때, 해당 index가 비게 된다.
				==> 낱알 빠진 옥수수 같은 배열
				==> 객체를 저장하려면 어디가 비어있는지 확인 해야한다.
		3. 특징
			1) 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 제공되는 컬렉션 라이브러리
			2) java.util 패키지에 포함되기 때문에 import 하여야 한다.
			3) 인터페이스를 통해서 정형화된 방법으로 다양한 컬렉션 클래스를 이용할 수 있다.
				List (상위)
					ArrayList (하위) ** : spring의 DB에 저장된 데이터 처리
					Vector (하위)
					LinkedList (하위)
		4. 인터페이스 분류
			1) 최상위 인터페이스 : List, Set, Map
			2) 특징
				1) List : 순서를 유지하고 저장, 중복 저장 가능
				2) Set : 순서를 유지하지 않고 저장, 중복 저장 안 됨
				3) Map : 키와 값의 쌍으로 저장, 키는 중복 저장 안 됨
				
		# List 컬렉션
		1. 특징
			1) 인덱스로 관리
			2) 중복해서 객체 저장 가능
		2. 구현 실제 클래스
			1) ArrayList
			2) Vector : 쓰레드 환경에서 객체의 추가 / 삭제 처리가 가능하게 해준다.
			3) LinkedList : 인접 참조를 링크해서 체인처럼 관리, 빈번한 객체 삭제와 삽입이 일어나는 곳에서 좋은 성능 발휘
		3. 주요 기능 메소드
			1) *add() : 주어진 객체를 맨 끝에 추가
			2) add(index, 객체) : 주어진 객체를 특정한 인덱스 위치에 삽입
			3) set(index, 객체) : 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈
			4) contains(객체) : 해당 객체가 포함되어 있는지 여부
			5) *get(index) : 주어진 인덱스에 저장된 객체를 리턴
			6) *isEmpty() : 컬렉션이 비어 있는지 조사
			7) *size() : 저장되어 있는 전체 객체 수 리턴
			8) clear() : 모든 객체 삭제
			9) remove(index) : 특정 위치에 있는 객체 삭제
		 */
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		System.out.println("초기 데이터");
		for(int idx = 0; idx < list.size(); idx++) {
			System.out.println(idx + " : " + list.get(idx));
		}
		
		System.out.println("삽입 데이터");
		list.add(1, "오렌지");
		for(int idx = 0; idx < list.size(); idx++) {
			System.out.println(idx + " : " + list.get(idx));
		}
		System.out.println("변경 데이터");
		list.set(0, "애플망고");
		for(int idx = 0; idx < list.size(); idx++) {
			System.out.println(idx + " : " + list.get(idx));
		}
		System.out.println("삭제 데이터");
		list.remove(2);
		for(int idx = 0; idx < list.size(); idx++) {
			System.out.println(idx + " : " + list.get(idx));
		}
		// ex) 회원리스트를 3명 초기에 할당하고, 두번째 회원을 추가하고, 3번째 회원을 변경하고, 마지막 데이터를 삭제 처리하세요.
		List<String> list01 = new ArrayList<String>();
		list01.add("철수");
		list01.add("영희");
		list01.add("맹구");
		System.out.println("초기 데이터");
		for(int idx = 0; idx < list01.size(); idx++) {
			System.out.println(idx + " : " + list01.get(idx));
		}
		System.out.println("추가 데이터");
		list01.add(2, "짱구");
		for(int idx = 0; idx < list01.size(); idx++) {
			System.out.println(idx + " : " + list01.get(idx));
		}
		System.out.println("변경 데이터");
		list01.set(1, "훈이");
		for(int idx = 0; idx < list01.size(); idx++) {
			System.out.println(idx + " : " + list01.get(idx));
		}
		System.out.println("삭제 데이터");
		list01.remove(3);
		for(int idx = 0; idx < list01.size(); idx++) {
			System.out.println(idx + " : " + list01.get(idx));
		}
		
		List<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member(1000, "홍길동"));
		mlist.add(new Member(2000, "신길동"));
		mlist.add(new Member(3000, "마길동"));
		for(int idx = 0; idx < mlist.size(); idx++) {
			Member m = mlist.get(idx);
			System.out.println(m);
		}
		System.out.println("두번째 자리에 멤버 추가");
		mlist.add(1, new Member(4000, "오길동"));
		for(int idx = 0; idx < mlist.size(); idx++) {
			Member m = mlist.get(idx);
			System.out.println(m);
		}
		
	}

}
class Member{
	private int no;
	private String name;
	public Member(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no + "\t" + name;
	}
	
}