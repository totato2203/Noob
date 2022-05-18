package javaexp.z01_homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A0518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-18
//		[1단계:개념] 1. Set컬렉션의 특징을 기본 예제를 통해서 기술하세요.
		/*
		Set : 수학의 집합에 비유할 수 있다.
			1) 저장 순서가 유지되지 않는다.
			2) 객체를 중복으로 저장할 수 없다.
			3) 하나의 null만 저장할 수 있다.
		 */
		Set<String> fruit = new HashSet<String>();
		fruit.add("사과");
		fruit.add("사과");
		fruit.add("사과");
		fruit.add("사과");
		fruit.add("바나나");
		fruit.add("바나나");
		fruit.add("딸기");
		fruit.add("딸기");
		fruit.add("딸기");
		fruit.add("사과");
		fruit.add("사과");
		for(String fr : fruit) {
			System.out.println(fr);
		}
		// 같은 종류의 과일을 여러 개 넣어도 하나만 저장되고, 저장 순서가 유지되지 않음
		
//		[1단계:개념] 2. Map컬렉션의 특징을 기본 예제를 통해서 기술하세요.
		/*
		# Map 컬렉션
		1. 특징
			1) 키와 값으로 구성된 Map.Entry 객체를 저장하는 구조
			2) 키와 값은 모두 객체
			3) 키는 중복될 수 없지만 값은 중복 저장 가능
		2. 구현 클래스
			HashMap, HashTable, LinkedHashMap, Properties, TreeMap
		3. 주요 메소드
			put(키, 값) : 주어진 객체에 키와 값을 추가 처리
			containsKey(키) : 주어진 키가 있는지 여부 확인
			containsValue(값) : 주어진 값이 있는지 여부 확인
			Set<Map.Entry<K, V>> entrySet() : 키와 값의 쌍으로 구성된 모드 Map.
				Entry 객체를 Set에 담아서 리턴
			V get(Object key) : 주어진 키의 값을 리턴
			boolean isEmpty() : 컬렉션이 비어있는지 여부
			Set<K> keySet() : 모든 키를 Set 객체에 담아서 리턴
			int size() : 저장된 키의 총 수를 리턴
			Collections<V> values() : 저장된 모든 값 Collection에 담아서 리턴
			clear() : 모든 Map.Entry(키와 값)을 삭제
			remove(Object key) : 주어진 키와 일치하는 Map.Entry 삭제
		 */
		/*
		Map : 키와 값으로 구성되어 Entry 객체를 저장하는 구조이다.
			1) 키와 값은 모두 객체이다.
			2) 키는 중복될 수 없지만, 값은 중복 저장할 수 있다.
		 */
		Map<String, String> std = new HashMap<String, String>();
		std.put("01", "김철수");
		std.put("02", "이영희");
		std.put("03", "신짱구");
		std.put("04", "최맹구");
		std.put("05", "이영희");
		Set<String> stdKey = std.keySet();
		for(String key : stdKey) {
			System.out.println(key + " -> " + std.get(key));
		}
		// 키는 중복될 수 없지만, 값은 중복 저장할 수 있다.
		
//		[1단계:개념] 3. Map<Integer, Player> 형태로 번호와 선수정보를 mapping하는
//		      Map 객체를 생성하여 선수의 팀명 이름 성적으로 3명 선수번호와 함께 출력하세요.
		Map<Integer, Player> player = new HashMap<Integer, Player>(); 
		player.put(1, new Player("맨체스터", "박지성", 2));
		player.put(2, new Player("토트넘", "손흥민", 3));
		player.put(3, new Player("바르셀로나", "메시", 1));
		Set<Integer> pKey = player.keySet();
		for(Integer key : pKey) {
			System.out.println(key + " -> " + player.get(key));
		}
		
		
	}

}
class Player{
	private String tname;
	private String name;
	private int rank;
	public Player() {}
	public Player(String tname, String name, int rank) {
		this.tname = tname;
		this.name = name;
		this.rank = rank;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tname + "\t" + name + "\t" + rank;
	}
}