package javaexp.a12_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A03_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		// 문자열key, 문자열value가 설정하는 Map인터페이스 하위에 HashMap 객체 생성
		Map<String, String> map = new HashMap<String, String>();
		// 키 : 키값을 중복하지 않아서않아서 마지막에 넣은 값이 저장된다.
		map.put("1000", "홍길동");
		map.put("1001", "김길동");
		map.put("1002", "신길동");
		map.put("1003", "오길동");
		map.put("1002", "마길동");
		map.put("1001", "하길동");
		// map.keySet() : Map에서 key를 가져오는 메소드
		Set<String> memKey = map.keySet();
		for(String key : memKey) {
			// get("키")를 통해서 key와 mapping 되는 value를 가져온다.
			System.out.println(key + " - " + map.get(key));
		}
		// 중복된 key는 삭제되고, 이와 연결된 value를 가져온다.
		// ex) 학생의 번호와 연결된 점수를 Map으로 선언하고 해당 Map의 key / value를 출력하세요.
		Map<String, String> std01 = new HashMap<String, String>();
		std01.put("01", "100");
		std01.put("02", "76");
		std01.put("03", "81");
		std01.put("04", "90");
		std01.put("05", "57");
		std01.put("06", "96");
		System.out.println("번호\t점수\t(String)");
		for(String key : std01.keySet()) {
			System.out.println(key + "\t" + std01.get(key));
		}
		Map<Integer, Integer> std02 = new HashMap<Integer, Integer>();
		std02.put(01, 100); // auto boxing 처리
		std02.put(02, 76);
		std02.put(03, 81);
		std02.put(04, 90);
		std02.put(05, 57);
		std02.put(06, 96);
		System.out.println("번호\t점수\t(Integer)");
		for(int key : std02.keySet()) { // auto unboxing 처리
			System.out.println(key + "\t" + std02.get(key));
		}
		System.out.println("번호\t점수\t(Integer -> Set)");
		Set<Integer> stdKey = std02.keySet();
		// Integer의 key할 때엔 순서 정렬도 자동 처리되어 출력한다.
		for(int key : stdKey) { // auto unboxing 처리
			System.out.println(key + "\t" + std02.get(key));
		}
	}

}
