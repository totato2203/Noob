package javaexp.a13_database;

import java.sql.*;

// DAO(Database Access Object)
public class A01_Conn {
	
	// 1. 공통 필드 선언하기
	private Connection con; // 연결 객체
	private Statement stmt; // 대화 객체
	private ResultSet rs; // data를 받는 결과 객체 SELECT sql의 처리 결과로 활용
		
	// 2. 공통 연결 메소드 : 하위에 선언한 기능메소드에서 호출 처리
	public void setConn() {
		// 1. jdbc 드라이버의 클래스를 객체화하여 메모리에 로딩 : 연결 - 필수예외처리(컴파일 시 필요)
		// ex1) 예외 처리를 하고, Class.forName 문자열 변경, info 부분 문자열 변경
		// ex2) DriverManager.getConnection(info, "scott", "tiger");
		//		==> 계정과 비밀번호 변경
		//	위에서 나오는 에러내용이 어떤 경우인지를 확인하고, 추후 에러 나올 때 해당 내용으로 파악
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 특정 서버에 접속정보로 접속 - localhost
			//		ip, port, sid, 계정, 비번
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("클래스 에러 : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("DB 처리 에러 : " + e.getMessage());
		} 
		
	
	}
	// 3. 각 기능별 메소드
	
	// main() : 구현한 내용을 적용하기 전 테스트
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_Conn dao = new A01_Conn();
		dao.setConn();

	}

}
