SELECT * FROM emp;
-- 조회한 결과와 같은 모양을 ResultSet 객체가 가지고 있다.
-- rs.next() : 행 단위로 커서를 위치시켜주고, 해당 행에 데이터가 있으면 true, 없으면 false
-- rs.next() : 한 번 호출하면 1행(true), 두 번은 2행(true), ..., 12번 호출하면 12행(true),
--				데이터는 12행까지 밖에 없기 때문에 13번 호출하면 false
-- rs.getInt("empno") : sql을 결과로 나온 컬럼명과 데이터 유형에 맞게 가져온다.
-- rs.get데이터유형("컬럼명") : 컬럼명은 대소문자를 구분하지 않는다.
-- rs.getString("job")
-- rs.getString() : 모든 데이터를 가져올 수는 있지만 모두 문자열형이 된다.

-- ex) 3번째 행의 sal를 가져오려면 rs.next()를 몇 번, rs.getXXX("???")를 호출해야하는가?
--		rs.next() 3번, rs.getDouble("sal")
-- ex) 2번째 행의 ename을 가져오려면 rs.next()를 몇 번, rs.getXXX("???")를 호출해야하는가?
--		rs.next() 2번, rs.getString("ename")
-- ex) 5번째 행의 deptno를 가져오려면 rs.next()를 몇 번, rs.getXXX("???")를 호출해야하는가?
--		rs.next() 5번, rs.getInt("deptno")

SELECT empno NO, ename name FROM emp;
-- * 주의) sql의 결과로 나온 컬럼명으로 rs.getString("컬럼명")을 지정해야지, 테이블의 컬럼명으로 하면 안 된다!
--	3번째 행의 NAME(WARD)를 가져오는 경우 : 
--		rs.next() 3번 호출, rs.getString("name") -- ename이 아니다!

SELECT * FROM dept;

SELECT count(*) cnt FROM emp;
SELECT * FROM emp
WHERE empno = 7654;

SELECT count(*)
FROM emp
WHERE job = 'CLERK';

/*
SELECT count(*)
FROM emp
WHERE job = CLERK; // 에러 발생
 */
/*
String sql = "SELECT count(*)
FROM emp
WHERE job = '" + job + "'"; // job = 'CLERK'; 형태로 sql을 만들어야한다.
 */





