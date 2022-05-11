package javaexp.z01_homework;

public class A0510 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		# 1:1 관련 추가 연습 예제를 통해 종속객체를 할당하고 내용을 출력 처리하는 연습
//		1. 컴퓨터(제조사, CPU)  VS 소유주(이름, 컴퓨터)
//		2. 연필(종류, 제조사) VS 지우개(제조자, 연필)
//		3. 자동차(배기량, 제조사) VS 소유주(이름, 자동차)
//
//		2022-05-10(과제)
//		[1단계:개념] 1. static 변수와 일반 변수의 차이점을 기본 예제를 통해 설명하세요.
		// static 변수는 클래스 종속적인 변수이고 공유메모리를 사용하여 모든 객체로부터 영향을 받는다.
		// 일반 변수는 참조변수를 사용하기 때문에 객체마다 다른 데이터를 가지고 있다.
		
		
//		[1단계:확인] 2. 가수의 정보(이름, 소속사, 현재타이틀곡)을 static과 일반변수를 적절하게 설정하고 메서드를 통해 출력하세요.
		Singer01 s01 = new Singer01("loen", "좋은 날");
		s01.singerInfo();
		Singer01 s02 = new Singer01("EDAM", "LILAC");
		s02.singerInfo();
		
//		[1단계:개념] 3. static final 상수와 static 변수의 차이점을 기술하세요.
		// static final 상수는 클래스 단위에서도 변경이 불가능한 상수이고,
		// static 변수는 객체에서 변경해도 클래스 단위까지 변경되는 변수이다.
		
//		[1단계:개념] 4. package란 무엇이고 클래스와의 관계를 설명하세요.
		// 클래스를 기능별로 묶어서 그룹 이름을 붙여놓은 것을 말한다.
		// 패키지는 클래스를 유일하게 만들어주는 식별자이다. 전체 클래스 이름은 상위패키지.하위패키지.클래스로 나타낸다.
		
//		[1단계:개념] 5. 접근제어자의 범위를 기술하세요.
		// 접근제어자는 public, protected, X(default), private가 있다.
		// private : 같은 클래스 내에서만 접근 가능
		// X(default) : 같은 패키지 내에서 접근 가능
		// public : 외부 패키지에서도 import를 통해 접근 가능
		
		
		
		
//		[1단계:확인] 6. playroom패키지 선언과 내부적으로 친구1, 친구2 클래스 선언, studyroom패키지선언 학생1, 학생2 클래스
//		            선언호, 친구1, 학생1에서 private, X(default), public에 적절한 필드값을 선언하고, 상호간에 호출하세요.
		
		
		
//		package javaexp.a08_access.a04_playroom;
//
//		public class frd01 {
//
//			private String privInfo = "나는 사실 동성애자다.";
//			String normInfo = "나는 시금치를 싫어한다.";
//			public String publInfo = "나는 남자다.";
//
//		}

		
		
//		package javaexp.a08_access.a04_playroom;
//
//		import javaexp.a08_access.a05_studyroom.std01;
//
//		public class frd02 {
//
//			void callInfo() {
//				
//				frd01 frd = new frd01();
////				System.out.println(frd.privInfo); private은 같은 클래스 내에서만 호출 가능
//				System.out.println(frd.normInfo);
//				System.out.println(frd.publInfo);
//				
//				std01 std = new std01();
////				System.out.println(std.privInfo); private은 같은 클래스 내에서만 호출 가능
////				System.out.println(std.normInfo); default는 같은 패키지 내에서만 호출 가능
//				System.out.println(std.publInfo); // import를 통해 외부 패키지에서도 호출 가능
//			}
//		}
		
		
		
//		package javaexp.a08_access.a05_studyroom;
//
//		public class std01 {
//
//			private String privInfo = "나는 사실 컨닝을 한다.";
//			String normInfo = "나는 공부를 열심히 한다.";
//			public String publInfo = "나는 전교 꼴지다.";
//
//		}

		
		
//		package javaexp.a08_access.a05_studyroom;
//
//		import javaexp.a08_access.a04_playroom.frd01;
//
//		public class std02 {
//
//			void callInfo() {
//				
//				frd01 frd = new frd01();
////			System.out.println(frd.privInfo); private은 같은 클래스 내에서만 호출 가능
////			System.out.println(frd.normInfo); default는 같은 패키지 내에서만 호출 가능
//				System.out.println(frd.publInfo); // import를 통해 외부 패키지에서도 호출 가능
//				
//				std01 std = new std01();
////			System.out.println(std.privInfo); private은 같은 클래스 내에서만 호출 가능
//				System.out.println(std.normInfo); 
//				System.out.println(std.publInfo);
//			}
//		}
		
		
		
//		[1단계:확인] 8. 클래스의 1:1 내용을 현실에서 3개 이상 선언하고 할당하여 출력하는 내용을 처리하세요
		StudentName std01 = new StudentName("전장호");
		std01.test();
		std01.choiceStudent(new StudentInfo(17, "국어", 95));
		std01.test();
		StudentName std02 = new StudentName("김똑똑");
		std02.choiceStudent(new StudentInfo(2, "수학", 100));
		std02.test();

	}

}
class StudentInfo{
	int num;
	String subject;
	int point;
	public StudentInfo(int num, String subject, int point) {
		super();
		this.num = num;
		this.subject = subject;
		this.point = point;
	}
	void pointResult() {
		System.out.println("번호 : " + num + "번, 과목명 : " + subject + ", 점수 : " + point + "점");
	}
}
class StudentName{
	String stdName;
	StudentInfo std01;
	public StudentName(String stdName) {
		super();
		this.stdName = stdName;
	}
	void choiceStudent(StudentInfo std01) {
		this.std01 = std01;
	}
	void test() {
		System.out.println("# " + stdName + " 학생 정보 #");
		if(std01 == null) {
			System.out.println("시험을 치르지 않았습니다.");
		}else {
			std01.pointResult();
		}
	}
	
}
class Singer01{
	static String name = "IU";
	String comp;
	String titleSong;
	Singer01(String comp, String titleSong){
		this.name = name;
		this.comp = comp;
		this.titleSong = titleSong;
	}
	void singerInfo() {
		System.out.println("# 가수 정보 #");
		System.out.println("이름 : " + name + ", 소속사 : " + comp + ", 현재 타이틀곡 : " + titleSong);
	}
}