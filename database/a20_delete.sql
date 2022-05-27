/*
# 데이터의 삭제
1. DELETE 명령문은 테이블에 저장된 데이터 삭제를 위한 조작어이다.
2. WHERE 절을 생략하면 테이블의 모든 행이 삭제된다.
3. 기본 형식
	DELETE
	FROM 테이블명
	WHERE 조건
 */
SELECT * FROM emp_cp100;
DELETE FROM emp_cp100
WHERE empno = 7782;
-- ex)
SELECT * FROM emp01;
CREATE TABLE emp01
AS SELECT * FROM emp;
-- ex) 급여가 2000 이상이고 부서가 30인 데이터를 삭제 처리하세요.
DELETE FROM emp01
WHERE sal >= 2000 AND deptno = 30;
/*
# 서브쿼리를 이용한 데이터 삭제
1. WHERE 절에서 서브쿼리 이용
2. 다른 테이블에 저장된 데이터를 검색하여 한꺼번에 여러 행의 내용을 삭제함
3. WHERE 절의 컬럼 이름은 서브 쿼리의 컬럼 이름과 달라도 됨
4. 데이터 타입과 컬럼 수는 일치
5. 기본 형식
	1) 1 row인 경우
		DELETE FROM 테이블
		WHERE (컬럼명1, 컬럼명2, ...) = (SELECT ... FROM 테이블 WHERE ...)
	2) 다중의 row인 경우
		DELETE FROM 테이블
		WHERE (컬럼명1, 컬럼명2, ...) in (SELECT ... FROM 테이블 ...)
	cf) 다중 컬럼인 경우에 해당 컬럼 데이터가 1개 row에 같이 있을 때 삭제된다.
 */
SELECT * FROM emp01;
-- 부서별 최고 급여자 삭제
DELETE FROM emp01
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal) sal
	FROM emp01
	GROUP BY deptno
);
-- ex) emp01 입사 분기별 최저 급여자를 삭제하세요.
SELECT to_char(sysdate, 'Q') div, min(sal) sal
FROM emp01
GROUP BY to_char(sysdate, 'Q');

DELETE FROM emp01
WHERE (to_char(hiredate, 'Q'), sal) IN (
	SELECT to_char(hiredate, 'Q') div, min(sal) sal
	FROM emp01
	GROUP BY to_char(hiredate, 'Q')
);
SELECT * FROM emp01;

CREATE TABLE emp001
AS SELECT * FROM emp;
SELECT * FROM emp001;

DELETE FROM emp001
WHERE (to_char(hiredate, 'Q'), sal) IN (
	SELECT to_char(hiredate, 'Q') div, min(sal) sal
	FROM emp001
	GROUP BY to_char(hiredate, 'Q')
); -- 계속 반복해서 다 삭제


