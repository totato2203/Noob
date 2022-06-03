package javaexp.z01_homework;

import java.sql.*;

public class A0603 {
	
//	2022-06-03
//	[1단계:개념] 1. database 서버 연동에 필요한 기본 정보를 java에서 설정하는 방법을 기술하세요.
	/*
	1. 공통 필드 선언
	2. 공통 연결 메소드 선언
		1) 드라이버 선언
		2) 서버 연결 처리(Connection 객체 생성)
	3. 조회 처리 기능 선언
		1) 연결 메소드 호출
		2) 대화객체 만들기
		3) 결과 객체 할당하기
	4. 자원 해제(열린 순서 반대 방향)
	5. 예외 처리
		1) 기본 예외 : DB - SQLException
		2) 일반 예외 : Exception
	 */
	
	
//	[1단계:확인] 2. A01_Connection 객체로 연동처리하여, 연동된 내용을 출력하세요.
	/*
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
	*/
	// 서버, 드라이버, 클라이언트, 접속정보(ip, port, sid, 계정, 비밀번호)
	
	
//	[1단계:개념] 3. DAO 처리에서 사용하는 필드 Connection, Statement, ResultSet 객체의
//	      역할과, 각 객체의 상호 생성 메서드를 기본예제를 통해서 설명하세요.
	/*
			3-1. 연결 객체 Connection : 접속 정보 + jdbc 드라이버
			3-2. 대화 객체 Statement(sql) : sql - DB서버에 이용하는 명령어
			3-3. 결과 객체 ResultSet(data) : 필요로 하는 정보(data)
	 */
	
	
//	[1단계:개념] 4. ResultSet 객체의 기능 메서드 next(), getXXX() 메서드에 대하여 기본예제와 함께 설명하세요.
		// .next() : 행 단위로 호출, 데이터가 있는 행일 때는 true, 없는 행일 때는 false
		// .getString("컬럼명") : 열 단위로 접근
	
//	[1단계:확인] 5. 아래의 여러형태의 sql을 처리하는 기능 메서드를 만드세요.
//	      1) select * from salgrade (출력만)
//	      2) 부서별 최고급여자 (출력만)
//	      3) 부서번호가 20인 최고연봉 (리턴유형 double)
//	      4) 사원명이 JONES인 사원정보(출력만)
//	      5) 분기별 최고 급여자(출력만)

	
// 예시)
		// 1. 공통 필드 선언
		private Connection con; // 연결 객체
		private Statement stmt; // 대화 객체
		private ResultSet rs;
		
		// 2. 공통 연결 메소드 선언
		public void setConn() throws SQLException {										// ----- 3-1. Connection 생성 메소드
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
		public void empList() {
//			1) 연결메소드 호출
			try {
				setConn();
//			2) 대화객체 만들기
				stmt = con.createStatement();											// ----- 3-2. Statement 생성 메소드
//			3) 결과객체 할당하기
				String sql = "select * from emp";
				rs = stmt.executeQuery(sql);											// ----- 3-3. ResultSet 생성 메소드
				int cnt = 1;
				while(rs.next()) {														// ----- 4-1. .next()
					System.out.print(cnt + "행\t" + rs.getInt("empno") + "\t");			// ----- 4-2. .getXXX("컬럼명")
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
				System.out.println("DB 에러: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외 : " + e.getMessage());
			}finally {
				// 예외 상관없이 처리할 내용
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
		}

		
// 5-1.
	public void salgradeList() {
		//			1) 연결메소드 호출
					try {
						setConn();
		//			2) 대화객체 만들기
						stmt = con.createStatement();
		//			3) 결과객체 할당하기
						String sql = "select * from salgrade";
						rs = stmt.executeQuery(sql);
						int cnt = 1;
						while(rs.next()) {
							System.out.print(cnt + "행\t" + rs.getInt("grade") + "\t");
							System.out.print(rs.getInt("losal") + "\t");
							System.out.print(rs.getInt("hisal") + "\n");
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
						System.out.println("DB 에러: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("일반 예외 : " + e.getMessage());
					}finally {
						// 예외 상관없이 처리할 내용
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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
// 5-2.
	public void maxSalOfDept() {
		//			1) 연결메소드 호출
					try {
						setConn();
		//			2) 대화객체 만들기
						stmt = con.createStatement();
		//			3) 결과객체 할당하기
						String sql = "select ename, sal from emp "
								+ "where sal in (select max(sal) from emp group by deptno)";
						rs = stmt.executeQuery(sql);
						int cnt = 1;
						while(rs.next()) {
							System.out.print(cnt + "행\t" + rs.getString("ename") + "\t");
							System.out.print(rs.getDouble("sal") + "\n");
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
						System.out.println("DB 에러: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("일반 예외 : " + e.getMessage());
					}finally {
						// 예외 상관없이 처리할 내용
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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
// 5-3.
	public double Dept20MaxSal() {
		double maxSal = 0;
		//			1) 연결메소드 호출
					try {
						setConn();
		//			2) 대화객체 만들기
						stmt = con.createStatement();
		//			3) 결과객체 할당하기
						String sql = "select max(sal) 최고연봉 from emp where deptno = 20";
						rs = stmt.executeQuery(sql);
						int cnt = 1;
						while(rs.next()) {
							System.out.print(cnt + "행\t" + rs.getDouble("최고연봉") + "\n");
							cnt++;
						}
						maxSal = rs.getDouble("최고연봉");
						// 자원해제(열린 순서 반대 방향)
						rs.close();
						stmt.close();
						con.close();
						// 예외 처리
						// 기본 예외 : DB - SQLException
						// 일반 예외 : Exception
					} catch (SQLException e) {
						System.out.println("DB 에러: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("일반 예외 : " + e.getMessage());
					}finally {
						// 예외 상관없이 처리할 내용
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
					
					return maxSal;
				}
	
// 5-4.
	public void enameJones() {
		//			1) 연결메소드 호출
					try {
						setConn();
		//			2) 대화객체 만들기
						stmt = con.createStatement();
		//			3) 결과객체 할당하기
						String sql = "select * from emp where ename = 'JONES'";
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
						// 자원해제(열린 순서 반대 방향)
						rs.close();
						stmt.close();
						con.close();
						// 예외 처리
						// 기본 예외 : DB - SQLException
						// 일반 예외 : Exception
					} catch (SQLException e) {
						System.out.println("DB 에러: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("일반 예외 : " + e.getMessage());
					}finally {
						// 예외 상관없이 처리할 내용
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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

// 5-5.

	/*
	SELECT ename, sal
	FROM emp
	WHERE sal IN (
		SELECT max(sal)
		FROM emp
		GROUP BY to_char(hiredate, 'Q')
	)*/
	public void maxSalEnameOfHiredate() {
		//			1) 연결메소드 호출
					try {
						setConn();
		//			2) 대화객체 만들기
						stmt = con.createStatement();
		//			3) 결과객체 할당하기
						String sql = "select ename, sal from emp where sal in (select max(sal) from emp group by to_char(hiredate, 'Q'))";
						rs = stmt.executeQuery(sql);
						int cnt = 1;
						while(rs.next()) {
							System.out.print(cnt + "행\t" + rs.getString("ename") + "\t");
							System.out.print(rs.getDouble("sal") + "\n");
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
						System.out.println("DB 에러: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("일반 예외 : " + e.getMessage());
					}finally {
						// 예외 상관없이 처리할 내용
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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A0603 dao = new A0603();
		dao.salgradeList();
		dao.maxSalOfDept();
		dao.Dept20MaxSal(); // 결과 집합을 모두 소모했음 예외 뜨는 이유
		dao.enameJones();
		dao.maxSalEnameOfHiredate();
	}

}
