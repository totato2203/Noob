package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaexp.z03_vo.Dept01;

//[1단계:개념] 1. 등록/수정/삭제시, 추가 삭제 필요한 코드를 예제로 기술하세요.
/*
추가해야할 코드 :
		con.setAutoCommit(false);
		
		pstmt.executeUpdate();
		
		con.commit();
		
		try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 */
/*
삭제해야할 코드 :
			rs = pstmt.executeQuery();
			rs.close();
			if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
 */

//[1단계:확인] 2. 복사테이블로 Dept01 을 만들고, 입력처리하는 메서드를 만드세요.
//[1단계:확인] 3. Dept01부서정보를 전체 컬럼을 수정하세요.
//[1단계:확인] 4. Dept01부서정보를 deptno기준으로 삭제하세요

//[1단계:개념] 5. jsp페이지를 웹서버(WAS)에서 실행할 때, 기본예제로 기본 위치와 설정파일을 기술하세요.

/*
jsp 파일 위치 : webprj\src\main\webapp\a01_html\a01_start
javaexp에서의 위치 : javaexp\src\main\webapp\WEB-INF

설정 파일 위치 : webprj\src\main\webapp\WEB-INF\lib
	설정 파일 : jsp-api.jar, ojdbc6.jar, servlet-api.jar
javaexp에서의 위치 : javaexp\src\main\webapp\WEB-INF\lib
	설정 파일 : jsp-api.jar, ojdbc6.jar, servlet-api.jar
 */

public class A0608 {

		private Connection con;
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
		
		public void showDept01() {
			try {
				setConn();
				String sql = "select * from dept01";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int cnt = 1;
				while(rs.next()) {
					System.out.print(cnt + "행\t" + rs.getInt("deptno") + "\t");
					System.out.print(rs.getString("dname") + "\t");
					System.out.print(rs.getString("loc") + "\n");
					cnt++;
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
		}
		
// 2.
		public void insertDept01(Dept01 ins) {
			try {
				setConn();
				con.setAutoCommit(false);
				String sql = "INSERT INTO dept01 VALUES (?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ins.getDeptno());
				pstmt.setString(2, ins.getDname());
				pstmt.setString(3, ins.getLoc());
				
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("DB 에러: " + e.getMessage());
				// commit 전에 예외가 발생하면 rollback 처리
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("일반 예외 : " + e.getMessage());
			}finally {
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
		
// 3.
		public void updateDept01(Dept01 ins) {
			try {
				setConn();
				con.setAutoCommit(false);
				String sql = "UPDATE dept01\r\n"
						+ "	SET dname = ?,\r\n"
						+ "		loc = ?\r\n"
						+ "WHERE deptno = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ins.getDname());
				pstmt.setString(2, ins.getLoc());
				pstmt.setInt(3, ins.getDeptno());
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("DB 에러: " + e.getMessage());
				// commit 전에 예외가 발생하면 rollback 처리
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("일반 예외 : " + e.getMessage());
			}finally {
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
			public void deleteDept01(int deptno) {
				try {
					setConn();
					con.setAutoCommit(false);
					String sql = "DELETE FROM dept01\r\n"
							+ "WHERE deptno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, deptno);
					pstmt.executeUpdate();
					con.commit();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("DB 에러: " + e.getMessage());
					// commit 전에 예외가 발생하면 rollback 처리
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception e) {
					System.out.println("일반 예외 : " + e.getMessage());
				}finally {
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
	
	public static void main(String[] args) {
		
		A0608 dao = new A0608();
		dao.showDept01();
		dao.insertDept01(new Dept01(10, "영업직", "서울"));	// 2.
		dao.showDept01();
		dao.updateDept01(new Dept01(10, "기획부", "부산"));	// 3.
		dao.showDept01();
		dao.deleteDept01(10);								// 4.
		dao.showDept01();
	}
}
