package javaexp.z01_homework;

import java.util.ArrayList;

public class A0509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-09
//		[1단계:개념] 1. 하나의 클래스를 통해 여러개의 객체을 생성하는 기본 예제를 작성하고 설명하세요.
		Triangle[] arr01 = new Triangle[3]; // 객체 배열 선언
		arr01[0] = new Triangle(2, 3, "보라");
		arr01[1] = new Triangle(5, 8, "초록");
		arr01[2] = new Triangle(6, 9, "검정"); // 객체 배열에 각 객체들을 할당
		
//		[1단계:개념] 2. 배열과 반복문 처리의 형식 2개(일반 for문, forEach 문)를 예제를 통하여 기술하세요
		System.out.println("# 일반 for문 #");
		for(int idx = 0; idx < arr01.length; idx++) {
			System.out.println("삼각형의 면적 : " + arr01[idx].area());
		}
		
		System.out.println("# forEach문 #");
		for(Triangle t01 : arr01) {
			System.out.println("삼각형의 면적 : " + t01.area());
		}
		
//		[1단계:확인] 3. 삼각형 3개 배열을 생성하되, 삼각형의 밑면과 높이 색상을 필드로 선언하고, 생성자를 통해를 이를 할당하고
//		      출력메서드를 통해서 해당 정보를 출력하되, 면적을 리턴하는 메서드를 선언하세요.
		Triangle[] arr02 = {
				new Triangle(3, 4, "빨강"),
				new Triangle(5, 6, "파랑"),
				new Triangle(7, 8, "노랑")
		};
		for(Triangle t02 : arr02) {
			System.out.println("삼각형의 면적 : " + t02.area());
		}
		
//		[1단계:개념] 4. 일반 배열과 동적배열(ArrayList)의 차이점을 예제를 통해서 기술하세요.
		// 모든 배열은 처음에 크기가 정해지면 변경이 불가능하지만 동적배열은 유동적으로 변경이 가능한 api에 있는 객체이기 때문에 가능하다.
		ArrayList<Triangle> arr03 = new ArrayList<Triangle>();
		arr03.add(new Triangle(4, 7, "하양"));
		arr03.add(new Triangle(9, 3, "갈색"));
		arr03.add(new Triangle(2, 6, "회색"));
		for(int idx = 0; idx < arr03.size(); idx++) {
			System.out.println("삼각형의 면적 : " + arr03.get(idx).area());
		}
		
//		[1단계:개념] 5. 동적배열 ArrayList의 활용 방법과 주요 기능 메서드를 기본 예제를 통하여 기술하세요.
		ArrayList<Triangle> arr04 = new ArrayList<Triangle>(); // 동적배열 선언
		arr04.add(new Triangle(3, 6, "남색")); // 참조값.add(new 생성자()); 로 객체 생성과 동시에 할당
		arr04.get(0).area(); // 참조값.get(idx); 를 통해 특정한 위치에 있는 객체를 가져온다.
		arr04.size(); // 참조값.size(); 을 통해 동적배열의 크기를 가져온다.
		arr04.remove(0); // 참조값.remove(idx); 를 통해 해당 객체를 삭제한다.
		
//		[2단계:확인] 6. ArrayList<Product>를 활용하여 구매할 물건 정보 3개를 추가하여 출력처리하세요.
//		      int tot()메서드로 내용 출력과 물건가격*물건단가를 리턴하게 하여, 물건 3개의 총비용을 누적 처리되게 하세요.
		ArrayList<Product> arr05 = new ArrayList<Product>();
		arr05.add(new Product("사과", 2000, 3));
		arr05.add(new Product("바나나", 3000, 4));
		arr05.add(new Product("딸기", 13000, 2));
		int totalPay = 0;
		for(Product prd : arr05) {
			prd.info();
			totalPay += prd.tot();
		}
		System.out.println("총 구매액 : " + totalPay + "원");
		
//		[1단계:개념] 7. static 멤버와 instance 멤버의 차이점을 예제를 통해 기술하세요.
		Triangle t01 = new Triangle(2, 3, "분홍");
		Triangle t02 = new Triangle(4, 5, "연두");
		Triangle.stt = 100000;
		System.out.print("t01 -> ");
		t01.sttInstc();
		System.out.print("t02 -> ");
		t02.sttInstc();
		t01.stt += 1234;
		t02.stt += 1234; // static 값에는 1234가 두 번, 총 2468이 더해졌다.
		t01.instc += 1234;
		t02.instc += 1234; // instance 값은 t01과 t02에 각각 1234 씩 더해졌다.
		System.out.print("t01 -> ");
		t01.sttInstc();
		System.out.print("t02 -> ");
		t02.sttInstc();
	}

}
class Product{
	String name;
	int price;
	int cnt;
	
	Product(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	int tot() {
		return price * cnt;
	}
	void info() {
		System.out.println("구매 물건 : " + name + ", 가격 : " + price + ", 개수 : " + cnt + ", 합계 : " + tot());
	}
}
class Triangle{
	int base;
	int height;
	String color;
	static int stt;
	int instc;
	
	public Triangle(int base, int height, String color) {
		super();
		this.base = base;
		this.height = height;
		this.color = color;
	}
	double area() {
		System.out.println("밑변 : " + base + ", 높이 : " + height + ", 색상 : " + color);
		return base * height / (double)2;
	}
	void sttInstc() {
		System.out.println("static 값 : " + stt + ", instance 값 : " + instc);
	}
	
}