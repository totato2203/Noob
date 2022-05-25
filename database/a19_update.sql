/*
# 데이터 수정
1. 개요
	update 명령문은 테이블에 저장된 데이터 수정을 위한 조작이다.
	where 절을 생략하면 테이블의 모든 행을 수정한다.
2. 기본 형식
	update 테이블
	set 컬럼1 = 수정데이터1,
		컬럼2 = 수정데이터2,
		...
	where 조건문
 */
SELECT * FROM EMP_CP100;
UPDATE EMP_CP100
	SET ename = '이현규',
		job = '대리'
	WHERE empno = 7782;
-- ex) 부서번호가 10인 사원정보의 입사일을 오늘로 변경, sal는 10% 인상 금액으로 처리
UPDATE EMP_CP100
	SET hiredate = sysdate,
		sal = sal * 1.1
	WHERE deptno = 10;
SELECT deptno, hiredate, sal FROM EMP_CP100;
/*
# subquery를 통한 수정 처리
1. update 명명문에 set 부분이나 where 조건절에 subquery를 이용하여 수정 처리하는 것을 말한다.
2. 다른 테이블이나 현재 테이블에 정보를 변경할 때, 일단 query를 수행한 결과로
	해당 데이터를 수정 처리하는 것을 말한다.
3. 변경할 컬럼의 타입과 개수는 반드시 일치해야 한다.
4. 유형
	1) set 부분 subquery 활용
		- 한 개의 컬럼 : set 컬럼명 = (결과가 1개인 컬럼데이터)
		- 두 개의 컬럼 : set (컬럼명1, 컬럼명2) = (결과가 2개인 컬럼데이터)
 */
-- 부서번호가 10인 사원정보의 급여를 부서번호 20인 사원의 최고 급여로 변경 처리
SELECT ename, sal
FROM EMP_CP101
WHERE deptno = 10;
SELECT max(sal)
FROM EMP_CP101
WHERE deptno = 20;
CREATE TABLE EMP_CP101 AS SELECT * FROM emp;
SELECT * FROM EMP_CP101;

UPDATE EMP_CP101
	SET sal = (
		SELECT max(sal)
		FROM emp_CP101
		WHERE deptno = 20
	)
WHERE deptno = 10;
-- ex) 직책이 SALESMAN인 사원의 평균급여를 사원번호 7499의 급여로 수정 처리하세요.
SELECT *
FROM EMP_CP101
WHERE empno = 7499; -- 수정 전 : sal = 1600

SELECT avg(sal)
FROM EMP_CP101
WHERE job = 'SALESMAN';

UPDATE EMP_CP101
	SET sal = (
		SELECT round(avg(sal))
		FROM EMP_CP101
		WHERE job = 'SALESMAN'
	)
	WHERE empno = 7499;

SELECT *
FROM EMP_CP101
WHERE empno = 7499; -- 수정 후 : sal = 1400

-- 두 개 열에 대한 subquery 처리
-- 부서별 최고 급여 중 최고 급여가 3000 미만인 부서번호와 급여를 사원번호 7369에 변경 처리
SELECT deptno, max(sal)
FROM EMP_CP101
GROUP BY deptno
HAVING max(sal) < 3000;
UPDATE EMP_CP101
	SET (deptno, sal) = (
		SELECT deptno, max(sal)
		FROM EMP_CP101
		GROUP BY deptno
		HAVING max(sal) < 3000
	)
WHERE empno = 7369;
SELECT *
FROM EMP_CP101;
-- ex) 직책별 최고 급여자 중에 SALESMAN의 직책과 급여를 사원번호 7782에 변경 처리
SELECT job, max(sal)
FROM EMP_CP101
GROUP BY job; -- SALESMAN의 max(sal) = 1500

UPDATE EMP_CP101
	SET (job, sal) = (
		SELECT job, max(sal)
		FROM EMP_CP101
		GROUP BY job
		HAVING job = 'SALESMAN'
	)
WHERE empno = 7782;

SELECT * FROM EMP_CP101 WHERE empno = 7782;
-- 변경 전 : job = MANAGER, sal = 3000
-- 변경 후 : job = SALESMAN, sal = 1500


