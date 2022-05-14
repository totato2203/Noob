package javaexp.z01_homework;

public class RV0514 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a05_reference
		
		
		Apple ap = new Apple();
		System.out.println(ap);
		// heap 영역에 존재하는 객체 ap의 주소값 : javaexp.z01_homework.Apple@2f92e0f4
		
		
		// 문자열을 바로 할당하면 비교연산자(==)로 비교 시 동일하게 처리되지만
		// 문자열의 일반적인 데이터 생성 형태는 내부적으로 new String()으로 사용된다. ex) DB의 데이터 불러오기, Scnner 등..
		String name01 = "홍길동";
		String name02 = "홍길동";
		System.out.println("바로 할당한 경우(==) : " + (name01 == name02)); // true
		
		String name03 = new String ("홍길동");
		String name04 = new String ("홍길동");
		System.out.println("new String으로 할당한 경우(==) : " + (name03 == name04)); // false
		System.out.println("new String으로 할당한 경우(.equals()) : " + (name03.equals(name04))); // true
		// 문자열 자체를 비교할 땐 .equals()를 활용해야 에러가 발생하지 않는다.
		
		
		int[] array01 = {100, 200, 300};
		System.out.println(array01[0] + array01[1] + array01[2]); // 100 + 200 + 300 = 600
		String[] array02 = {"안", "녕", "하", "세", "요"};
		System.out.println(array02[0] + array02[1] + array02[2] + array02[3] + array02[4]); // 안녕하세요

		
		int[][] gugudan = new int[10][10]; // 왜 [10][10]이지?
		for(int idx = 2; idx <= 9; idx++) {
			for(int jdx = 1; jdx <= 9; jdx++) {
				gugudan[idx][jdx] = idx * jdx;
			}
		}
		for(int idx = 2; idx <= 9; idx++) {
			for(int jdx = 1; jdx <= 9; jdx++) {
				System.out.print(gugudan[idx][jdx] + "\t");
			}
			System.out.println();
		}
		
		
		Apple ap01 = new Apple(); // ap01, ap02, ap03 :참조변수
		Apple ap02 = new Apple(); // 생성자 default값 출력
		Apple ap03 = new Apple("빨강"); // 매개변수 kind(빨강)을 받는 생성자 출력
		System.out.println(ap01); // 같은 클래스로 만든 객체들이지만
		System.out.println(ap02); // 주소값이
		System.out.println(ap03); // 모두 다르다.
		Apple ap04 = new Apple(3);
		Apple ap05 = new Apple('+');
		Apple ap06 = new Apple(2 == 3);
		Apple ap07 = new Apple("파랑", 5);
		Apple ap08 = new Apple(6, "파랑");
		Apple ap09 = new Apple("초록", 7, '+');
		System.out.println(ap09.kind + ap09.icon + ap09.cnt);
		ap09.setKind("분홍");
		System.out.println(ap09.getKind());
		
		
	}

	
}
class Apple {
	String kind; // 필드
	int cnt;
	char icon;
	Apple(){// 생성자
		System.out.println("생성자 default값 출력");
	}
	Apple(String kind){
		System.out.println("매개변수 " + kind + "을 받는 생성자 출력");
	}
	Apple(int pm01){ // 정수형 매개변수를 받는 생성자
		System.out.println("정수형 매개변수 : " + pm01);
	}
	Apple(char pm02){ // char형 매개변수를 받는 생성자
		System.out.println("char형 매개변수 : " + pm02);
	}
	Apple(boolean pm03){ // boolean형 매개변수를 받는 생성자
		System.out.println("boolean형 매개변수 : " + pm03);
	}
	Apple(String name, int num){ // 문자열, 정수형 순서의 매개변수를 받는 생성자
		System.out.println("문자열, 정수형 순서의 매개변수 : " + name + num);
	}
	Apple(int num, String name){ // 정수형, 문자열형 순서의 매개변수를 받는 생성자
		System.out.println("정수형, 문자열 순서의 매개변수 : " + num + name);
	}
	Apple(String kind, int cnt, char icon){
		this.kind = kind;
		this.cnt = cnt;
		this.icon = icon;
	}
	
	String getKind() { // 메소드
		return kind;
	}
	void setKind(String kind) {
		this.kind = kind;
	}
}
