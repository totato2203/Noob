SELECT * FROM emp;
-- 조회한 결과와 같은 모양을 ResultSet 객체가 가지고 있다.
-- .next() : 행 단위로 이동 처리함. - 그 행에 데이터가 있으면 true, 없으면 false
-- .getString("컬럼명") : 해당 row 상단에 선언된 column명을 기준으로 데이터를 가져온다.
--		주의, SELECT @@ 최종 컬럼명이기 때문에 alias가 있으면 alias명으로 호출해야 한다.
--		.get데이터유형()
--			ex) rs.getInt("empno"), rs.getDate("hiredate"),
--				sal의 경우 number(4,2)로 실수형이기 때문에 rs.getDouble("sal")
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

SELECT * FROM salgrade;

SELECT ename, sal
FROM emp
WHERE sal IN (
	SELECT max(sal)
	FROM emp
	GROUP BY deptno
);

SELECT max(sal)
FROM emp
WHERE deptno = 20;

SELECT *
FROM emp
WHERE ename = 'JONES';

-- 분기별 최고급여자
SELECT ename, sal
FROM emp
WHERE sal IN (
	SELECT max(sal)
	FROM emp
	GROUP BY to_char(hiredate, 'Q')
);

-- String sql = "select count(*) cnt from emp where deptno = " + deptno;
SELECT count(*) cnt FROM emp WHERE deptno = 10;
SELECT * FROM emp WHERE deptno = 10;
-- String sql = "select count(*) cnt from emp where job = '" + job + "'";
-- job = '" + job + "'" : 변동되는 문자열 job에 다른 sql 결과를 얻기 위해서 이런 형식이 필요하다.
SELECT count(*) cnt FROM emp WHERE job = 'CLERK';
SELECT * FROM emp WHERE job = 'CLERK';

-- 부서번호가 20인 최고연봉
SELECT *
FROM emp
WHERE sal = (
	SELECT max(sal)
	FROM emp
	WHERE deptno = 20
);

SELECT *
FROM emp
WHERE ename LIKE '%' || 'A' || '%';

-- [1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
SELECT *
FROM emp
WHERE deptno = 10 AND sal >= 1000 AND sal <= 3000;

-- [1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.(PreparedStament)
SELECT dname, ename, empno, sal
FROM EMP e , DEPT d
WHERE e.deptno = d.deptno
AND ename LIKE '%' || 'A' || '%'
AND dname LIKE '%' || 'A' || '%'; 

SELECT *
FROM dept;







