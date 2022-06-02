package javaexp.a13_database;

import java.sql.*;

public class A01_DAO {
	
	// 1. 공통 필드 선언하기
	private Connection con; // 연결 객체
	private Statement stmt; // 대회 객체
	private ResultSet rs; // data를 받는 결과 객체 sql
		
		// 2. 공통 연결 메소드
	public void setConn() {
		// 1. jdbc 드라이버의 클래스를 객체화하여 메모리에 로딩 : 연결 - 필수예외처리(컴파일 시 필요)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 특정 서버에 접속정보로 접속 - localhost
			//		ip, port, sid, 계정, 비번
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	}
	// 3. 각 기능별 메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_DAO dao = new A01_DAO();
		dao.setConn();

	}

}
