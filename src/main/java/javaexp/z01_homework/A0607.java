package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;

public class A0607 {

	public static void main(String[] args) {
//		2022-06-07
//		[1단계:개념] 1. PreparedStament를 사용하는 이유를 기술하세요
		// 관리자의 비밀번호를 모르더라도 인증이 돼버리는 현상을 방지하기 위해
			/*
			SELECT user FROM user_table WHERE id = 'admin' AND password = ' ' or '1' = '1';
			String sql = "SELECT user FROM user_table WHERE id = '"+id+"' AND password = '"+pass+"'";
			 */
		
//		[1단계:개념] 2. PreparedStament 를 활용하여 기존에 Statement와 비교하여 변경되는 code를 예제를 통해 기술하세요.
		/*
	 	stmt = con.createStatement();
	 	rs = stmt.executeQuery(sql);
		==>
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		 */
		
//		[1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
		/*
		1) sql 작성
		2) DAO 기능 메소드 선언
			- VO 생성 확인
			- 리턴값 매개변수 확인
		3) 기본 메소드 복사
		4) sql 선언, pstmt.setXXXX() 설정
		5) ResultSet 선언
		 */
		A0607 dao = new A0607();
		dao.showEmp3(10, 1000, 3000);
		
//		[1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.(PreparedStament)
		dao.showEmp4("A", "A");
		
//		[1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
//		              리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
		ArrayList<Dept> deptList = dao.getDeptList();
		for(Dept d : deptList) {
			System.out.print(d.getDeptno() + "\t");
			System.out.print(d.getDname() + "\t");
			System.out.print(d.getLoc() + "\n");
		}
		
//		[1단계:확인] 6. 오늘 webprj2로 프로젝트 만들고, 톰캣연동하는 부분을 ppt 자료를 만들어서 캡쳐해서, 제출하세요.

	}

	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 에러 : " + e.getMessage());
		}
	}


// 2.
	public void showEmp() {
		try {
			setConn();
			String sql = "select * from emp";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
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
			rs.close();
			stmt.close();
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
	
	public void showEmp2() {
		try {
			setConn();
			String sql = "select * from emp";
			pstmt = con.prepareStatement(sql);							// stmt = con.createStatement(); ==> pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();									// stmt.executeQuery(sql); ==> pstmt.executeQuery();
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
			rs.close();
			pstmt.close();												// stmt.close(); ==> pstmt.close();
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
			if(pstmt != null) {											// (stmt != null) ==> (pstmt != null)
				try {
					pstmt.close();										// stmt.close(); ==> pstmt.close();
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
	
	
// 3.
	
//	[1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
	public void showEmp3(int deptno, double lowsal, double hisal) {
		try {
			setConn();
			String sql = "SELECT * FROM emp WHERE deptno = '" + deptno + "' AND sal >= '" + lowsal + "' AND sal <= '" + hisal + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
	}


// 4.	
	//	[1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.(PreparedStament)
		public void showEmp4(String ename, String dname) {
			try {
				setConn();
				String sql = "SELECT dname, ename, empno, sal\r\n"
						+ "FROM EMP e , DEPT d\r\n"
						+ "WHERE e.deptno = d.deptno\r\n"
						+ "AND ename LIKE '%' || ? || '%'\r\n"
						+ "AND dname LIKE '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ename);
				pstmt.setString(2, dname);
				rs = pstmt.executeQuery();
				
				int cnt = 1;
				while(rs.next()) {
					System.out.print(cnt + "행\t" + rs.getString("dname") + "\t");
					System.out.print(rs.getString("ename") + "\t");
					System.out.print(rs.getInt("empno") + "\t");
					System.out.print(rs.getDouble("sal") + "\n");
					cnt++;
				}
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
		}


// 5.	
		//	[1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
		// 				리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
		public ArrayList<Dept> getDeptList() {
			ArrayList<Dept> deptList = new ArrayList<Dept>();
				try {
					setConn();
					String sql = "select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%'";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						deptList.add(new Dept(
							rs.getInt("deptno"),
							rs.getString("dname"),
							rs.getString("loc"))
						);
					}
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
				return deptList;
			}
}
