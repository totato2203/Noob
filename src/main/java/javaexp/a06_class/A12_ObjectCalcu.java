package javaexp.a06_class;

public class A12_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		
		 */
		Member m = new Member();
		System.out.println("현재 로그인 : " + m.curLoginId());
		m.login("himan", "7777"); // id = "himan", pass = "7777"
		System.out.println(m.loginResult()); // 출력 : 로그인 성공
		System.out.println("현재 로그인 : " + m.curLoginId());
		// ex) 필드로 point 변수 지정하고 setPoint()로 point 값 할당.
		// 		String isSuperUser() : point >= 10000 이면 "MVP입니다." 리턴
		//		그 외에는 "일반 고객입니다." 리턴 (문자열)
		System.out.println("포인트 : " + m.getPoint()); // 출력 : 포인트 : 0
		m.setPoint(20000); // point = 20000
		System.out.println("포인트 : " + m.getPoint()); // 출력 : 포인트 : 0
		System.out.println(m.isSuperUser()); // 출력 : MVP입니다.

	}

}
class Member{
	String id;
	String pass;
	int point; // 포인트 필드 추가
	void setPoint(int point) {
		this.point = point;
	}
	int getPoint() {
		return point;
	}
	String isSuperUser() {
		String grade = "일반 고객입니다.";
		if(point >= 10000) grade = "MVP입니다.";
		return grade;
	}
	void login(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	String loginResult() {
		String result = "로그인 실패";
		if(id.equals("himan") && pass.equals("7777")) {
			result = "로그인 성공";
		}
		
		return result;
	}
	String curLoginId() {
		return id;
	}
}