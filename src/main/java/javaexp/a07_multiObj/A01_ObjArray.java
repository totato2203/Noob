package javaexp.a07_multiObj;

public class A01_ObjArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 객체형 배열 처리
		1. 하나의 클래스에서 만들어진 객체는 여러 개의 배열로 사용할 수 있다.
		2. 객체 배열
			단위객체명[] 배열명 = new 단위객체명[개수];
			단위객체명[] 배열명 = {new 객체명(), new 객체명(), ...};
			배열명[index번호]; 호출
			배열명[index번호]; = new 객체명(); 할당
		 */
		Student []arr1 = new Student[3];
		// 각 index 별로 실체 객체를 할당하고 메서드를 사용
		arr1[0] = new Student(1, "홍길동"); arr1[0].setPoint(80);
		arr1[1] = new Student(2, "신길동"); arr1[1].setPoint(90);
		arr1[2] = new Student(3, "마길동"); arr1[2].setPoint(100);
		int tot = 0;
		// 해당 메서드를 통해서 점수가 return이 되기 때문에 tot이라는 변수에 누적시킬 수 있다.
		tot += arr1[0].showInfo();
		tot += arr1[1].showInfo();
		tot += arr1[2].showInfo();
		System.out.println("총 점수 : " + tot);
		
		// ex) Fruit 필드 : 과일종류, 가격
		//			생성자 : 필드값 초기
		//			메서드 show() : 종류와 가격 출력
		//	배열로 3개를 선언 및 할당, show() 호출
		Fruit []arr2 = new Fruit[3];
		arr2[0] = new Fruit("사과", 3000);
		arr2[1] = new Fruit("바나나", 4000);
		arr2[2] = new Fruit("딸기", 12000);
		for(int idx = 0; idx < arr2.length; idx++) {
			arr2[idx].show();
		}
		Fruit []arr3 = {new Fruit("오렌지", 1200), new Fruit("키위", 1500),
						new Fruit("수박", 15000)};
		// for each 구문을 통한 처리
		// for(단위객체 : 배열) : 배열에 있는 개수만큼 반복해서 단위 객체에 할당
		for(Fruit fru : arr3) {
			fru.show();
		}
		/*
		ex2) Computer 클래스 선언 : cpu, ram, hdd 속성을 선언하고, 객체선언과 할당을 동시처리
				생성자 : 필드 초기화, 메서드 필드 출력
				메서드 : comInfo()를 통해 속성 출력 처리
		 */
		Computer []arr4 = {
				new Computer("a", "b", "c"),
				new Computer("d", "e", "f"),
				new Computer("g", "h", "i")
				};
		// arr4[0] == new Computer("a", "b", "c");
		for(int idx = 0; idx < arr4.length; idx++) {
			arr4[idx].comInfo();
		}
		for(Computer a : arr4) {
			a.comInfo();
		}
		
	}

}
class Computer {
	String cpu, ram, hdd;
	Computer(String cpu, String ram, String hdd){
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	void comInfo() {
		System.out.println(cpu + ram + hdd);
	}
	
}
class Fruit{
	String kind;
	int price;
	Fruit(String kind, int price){
		this.kind = kind;
		this.price = price;
	}
	void show() {
		System.out.println("과일 종류 : " + kind + ", 과일 가격 : " + price);
	}
}
class Student{
	int no;
	String name;
	int kor;
	
	Student(int no, String name){
		this.no = no;
		this.name = name;
	}
	void setPoint(int kor) {
		this.kor = kor;
	}
	int showInfo() {
		System.out.println(no + "\t" + name + "\t" + kor);
		return kor;
	}
}