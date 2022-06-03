package javaexp.a13_database;

import java.sql.*;

// DAO(Database Access Object)
public class A02_DAO {
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
			// 1. 필드에 선언된 private Connection con;에 객체가 생성된다.
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
			//		4) 전체 데이터 가져오기
			//			저장된 개수만큼 next()를 호출
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
	// 단일 row sql 처리
	public int getEmpCnt() {
		int cnt = 0;
		// -----[* 핵심코드]
		String sql = "select count(*) cnt from emp";
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	
	
	// 단일 row sql 처리
	public int getEmpCnt(int deptno) {
		int cnt = 0;
		// -----[* 핵심코드]
		String sql = "select count(*) cnt from emp where deptno = " + deptno;
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	// 단일 row sql 처리
	public int getEmpCnt(String job) {
		int cnt = 0;
		// -----[* 핵심코드]
		String sql = "select count(*) cnt from emp where job = '" + job + "'";
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_DAO dao = new A02_DAO();
		// dao.showEmp();
		System.out.println("사원정보의 개수 : " + dao.getEmpCnt());
		System.out.println("부서번호(10)별 개수 : " + dao.getEmpCnt(10));
		System.out.println("부서번호(20)별 개수 : " + dao.getEmpCnt(20));
		System.out.println("부서번호(30)별 개수 : " + dao.getEmpCnt(30));
		System.out.println("직업별 개수 : " + dao.getEmpCnt("PRESIDENT"));

	}

}
