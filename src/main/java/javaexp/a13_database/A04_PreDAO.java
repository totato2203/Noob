package javaexp.a13_database;

import java.sql.*;
import java.util.ArrayList;

import javaexp.z03_vo.Emp;

// DAO(Database Access Object)
// 전화기와 동일 : 연결/대화/결과를 통해 받은 데이터/종료 - 자원해제, 예외처리
public class A04_PreDAO {
	private Connection con; // 연결 객체
	private PreparedStatement pstmt; // 대화 객체
	private ResultSet rs; // data를 받는 결과 객체 SELECT sql의 처리 결과로 활용
	public void setConn() throws SQLException { // 예외를 외부에 던져 한꺼번에 처리할 수 있게 함
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
			// 계층적으로 연관 관계로 객체가 만들어진다.
			// 드라이버 객체 ==> DB 처리는 연결객체 ==> 대화가 결과객체 (상호 간에 연동하여 객체 생성)
			
			//		2) 대화객체 생성
			pstmt = con.prepareStatement(sql);
			
			//		3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = pstmt.executeQuery();
			//		4) 전체 데이터 가져오기
			//			저장된 개수만큼 next()를 호출
			int cnt = 1;
			while(rs.next()) { // 행 단위로 이동되게 한다.
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
			pstmt.close();
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// ex) getEmpCnt()를 PreparedStatement로 처리해서 에러가 없게 하세요.
	// 단일 row sql 처리
	public int getEmpCnt() {
		int cnt = 0;
		// -----[* 핵심코드]
		String sql = "select count(*) cnt from emp";
		// 연결
		try {
			setConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			pstmt.close();
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
			if(pstmt != null) {
				try {
					pstmt.close();
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
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			pstmt.close();
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
			if(pstmt != null) {
				try {
					pstmt.close();
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
	// ex) 아래 내용을 ? mapping 되게 처리하세요.
	public int getEmpCnt(String job) {
		int cnt = 0;
		// -----[* 핵심코드]
		String sql = "select count(*) cnt from emp where job = ?";
		// 홑따옴표('') 붙이면 안 됨! (아래에서 데이터 타입을 정했기 때문)
		
		// 연결
		try {
			setConn();
			pstmt = con.prepareStatement(sql);
			// ?에 mapping될 데이터를 타입에 맞게 처리한다.
			
			pstmt.setString(1, job);
			// deptno로 연동할 데이터가 정수형이고, 첫번째 ?에 연동할 데이터
			// ?는 1부터 시작해서 증가시킨다.
			
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기 때문에 바로 처리
			// ----- [* 핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			//
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
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
		return cnt;
	}
	
// # return 객체 설정과 키워드 검색
	
	public ArrayList<Emp> getEmpList(String ename) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {
			setConn();
			String sql = "SELECT *\r\n"
					+ "FROM emp\r\n"
					+ "WHERE ename LIKE '%' || ? || '%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			int cnt = 1;
			while(rs.next()) {
				empList.add(new Emp(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getInt("mgr"),
					rs.getDate("hiredate"),
					rs.getDouble("sal"),
					rs.getDouble("comm"),
					rs.getInt("deptno"))
				);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("DB 에러: " + e.getMessage());
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
			if(pstmt != null) {
				try {
					pstmt.close();
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
		return empList;
	}
	public static void main(String[] args) {
		// 실제는 외부에서 위 DAO의 특정한 객체를 호출하는데,
		// 그 전에 테스트로 main()에서 객체를 생성해본다.
		A04_PreDAO dao = new A04_PreDAO();
		// dao.showEmp();
		/*
		System.out.println("사원정보의 개수 : " + dao.getEmpCnt());
		System.out.println("부서번호(10)별 개수 : " + dao.getEmpCnt(10));
		System.out.println("부서번호(20)별 개수 : " + dao.getEmpCnt(20));
		System.out.println("부서번호(30)별 개수 : " + dao.getEmpCnt(30));
		System.out.println("직업별 개수 : " + dao.getEmpCnt("PRESIDENT"));
		*/
		ArrayList<Emp> empList = dao.getEmpList("A");
		for(Emp e : empList) {
			System.out.print(e.getEmpno() + "\t");
			System.out.print(e.getEname() + "\t");
			System.out.print(e.getJob() + "\t");
			System.out.print(e.getMgr() + "\t");
			System.out.print(e.getHiredate() + "\t");
			System.out.print(e.getComm() + "\t");
			System.out.print(e.getDeptno() + "\n");
		}
	}

}
