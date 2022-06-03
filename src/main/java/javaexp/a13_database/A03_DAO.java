package javaexp.a13_database;

import java.sql.*;

public class A03_DAO{
	
	// 1. 공통 필드 선언
	private Connection con; // 연결 객체
	private Statement stmt; // 대화 객체
	private ResultSet rs;
	
	// 2. 공통 연결 메소드 선언
	public void setConn() throws SQLException {
		// 1) 드라이버 선언
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 에러 : " + e.getMessage());
		}
		// 2) 서버 연결 처리(Connection 객체 생성)
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("접속 성공");
	}
	// 3. 조회 처리 기능 메소드 선언
	public void empList() {
//		1) 연결메소드 호출
		try {
			setConn();
//		2) 대화객체 만들기
			stmt = con.createStatement();
//		3) 결과객체 할당하기
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			System.out.println("기능 sql 처리 완료");
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행\t" + rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				cnt++;
			}
			// 자원해제(열린 순서 반대 방향)
			rs.close();
			stmt.close();
			con.close();
			// 예외 처리
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		}finally {
			// 예외 상관없이 처리할 내용
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
	// ex) 부서정보를 조회하여 출력하는 기능메소드 처리
//	public void deptList() {
//		String sql = "select * from dept";
//	}
	public void deptList() {
		try {
			setConn();
			String sql = "select * from dept";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행\t" + rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");
				cnt++;
			}
			// 자원해제(열린 순서 반대 방향)
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("DB 예외 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		A03_DAO dao = new A03_DAO();
		// dao.empList();
		dao.empList();
		dao.deptList();
	}
	
}

// DAO(Database Access Object)
/* 
public class A03_DAO {
	private Connection con; // 연결 객체
	private Statement stmt; // 대화 객체
	private ResultSet rs; // data를 받는 결과 객체 SELECT sql의 처리 결과로 활용
	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("클래스 에러 : " + e.getMessage());
		}
	}
	// 3. 각 기능별 메소드
	//	1) emp를 출력하는 기능메소드
	public void showEmp() {
		// 선언한 공통 연결 메소드 호출
		try {
			// 1. 필드에 선언된 priate Connection con;에 객체가 생성된다.
			setConn();
			
			// 2. 대화객체 선언
			//		1) sql문 작성
			String sql = "select * from emp";
			// sql문 안에 (;)을 붙이지 않는다. (위 형태처럼 선언해야함) (sql문 복붙할 때 주의)
			//	==> DB 에러: ORA-00911: invalid character
			
			//		2) 대화객체 생성
			stmt = con.createStatement();
			
			//		3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러: " + e.getMessage());
		}
	}
	// ex) A03_DAO.java로 연결, 기본 조회 기능메소드를 만들어 확인하세요.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A03_DAO dao = new A03_DAO();
		dao.showEmp();

	}

}
*/