/*
# 다중 행 입력
1. 기본 형식
	insert 명령문에서 서브쿼리 절을 이용
	insert 명령문에 의해 한 번에 여러 행을 동시에 입력
	9i 버전 이후
		insert all
		first insert
2. 단일 테이블에 다중 행 입력 방법
	1) insert 명령문에서 서브쿼리 절을 이용하여 자신이나 다른 테이블에 데이터를 복사하여 여러 행을 동시에 입력
	2) insert 명령문의 values절 대신 서브쿼리에서 검색된 결과 집합을 한꺼번에 입력
	3) 서브쿼리의 결과 집합은 insert 명령문에 지정된 컬럼 개수와 데이터 타입이 일치해야 함
	4) 서브쿼리를 이용한 다중 행 입력 시 테이블에 기본키, 고유키, 제약 조건이 중복되지 않도록 주의
	5) 제약 조건을 위반할 경우 입력되지 않고 오류 발생
3. 활용 방법
	INSERT INTO 테이블 (컬럼1, 컬럼2, ...)
	subquery
 */
CREATE TABLE emp_cp103
AS SELECT * FROM emp WHERE 1 = 0;
SELECT * FROM emp_cp103;
INSERT INTO emp_cp103
SELECT * FROM emp WHERE deptno = 30;

INSERT INTO emp_cp103(empno, ename)
SELECT empno, ename FROM emp WHERE deptno = 10;
SELECT * FROM emp_cp103;
-- ex) EMP_CP104로 데이터가 없는 복사테이블을 만들고,
--	사원정보 중 연봉이 1000 ~ 3000 사이인 데이터를 전체 데이터로 입력하세요.
--	사원 정보 중 직책이 SALESMAN인 데이터를 사원번호, 사원명, 직책, 급여만 입력 처리하세요.
CREATE TABLE emp_cp104
AS SELECT * FROM emp WHERE 1 = 0; -- 데이터 없는 복사 테이블 생성

SELECT * FROM emp_cp104;

INSERT INTO emp_cp104
SELECT * FROM emp WHERE sal BETWEEN 1000 AND 3000;

INSERT INTO emp_cp104(empno, ename, job, sal)
SELECT empno, ename, job, sal
FROM emp
WHERE job = 'SALESMAN';
/*
# 다중 행 입력 insert all
1. 조회된 내용을 한 번에 여러 테이블에 입력 처리
2. 내용
	서브 쿼리의 결과 집합을 조건 없이 여러 테이블에 동시에 입력
	서브 쿼리의 컬럼 이름과 데이터가 입력되는 테이블의 컬럼이 반드시 동일하여야 함
		- 개수, 유형, 크기 입력이 가능해야 함
2. 기본 형식
	INSERT ALL || FIRST
	INTO 테이블1 values(컬럼1, 커럼2, ...)
	INTO 테이블2 values(컬럼1, 커럼2, ...)
	INTO 테이블3 values(컬럼1, 커럼2, ...)
	INTO 테이블. values(컬럼1, 커럼2, ...)
	subquery
	1) all : 서브 쿼리의 결과 집합을 해당하는 insert 절에 모두 입력
	2) first : 서브 쿼리의 결과 집합을 해당하는 첫번째 insert 절에 입력
	3) subquery : 입력 데이터 집합을 정의하기 위한 서브쿼리
 */
CREATE TABLE EMP_CPY201
AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY202
AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY203
AS SELECT * FROM emp WHERE 1 = 0;
SELECT * FROM emp_cpy201;
SELECT * FROM emp_cpy202;
SELECT * FROM emp_cpy203;

INSERT ALL
INTO emp_cpy201(empno, ename, job) VALUES(empno, ename, job)
INTO emp_cpy202(empno, ename, job) VALUES(empno, ename, job)
INTO emp_cpy203(empno, ename, job) VALUES(empno, ename, job)
SELECT empno, ename, job
FROM emp
WHERE deptno = 10;

INSERT first
INTO emp_cpy201(empno, ename, job) VALUES(empno, ename, job)
INTO emp_cpy202(empno, ename, job) VALUES(empno, ename, job)
INTO emp_cpy203(empno, ename, job) VALUES(empno, ename, job)
SELECT empno, ename, job
FROM emp
WHERE deptno = 20;
/*
ex) EMP_CPY301, EMP_CPY302, EMP_CPY303 데이터가 없는 복사 테이블을 만들고,
	해당 테이블에 부서번호가 20인 사원정보 전체 컬럼을 입력 처리하세요.
 */
SELECT empno, ename, job
FROM emp
WHERE deptno = 20;

CREATE TABLE EMP_CPY301
AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY302
AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY303
AS SELECT * FROM emp WHERE 1 = 0;

INSERT ALL
INTO EMP_CPY301 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
INTO EMP_CPY302 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
INTO EMP_CPY303 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT *
FROM emp
WHERE deptno = 20;

SELECT * FROM EMP_CPY301;
SELECT * FROM EMP_CPY302;
SELECT * FROM EMP_CPY303;
/*
# INSERT FIRST 형식
INSERT FIRST 
조건절 1
INTO 테이블 values(데이터)
조건절 2
INTO 테이블 values(데이터)
조건절 3
INTO 테이블 values(데이터)
subquery 처리

ex) 사원 정보 중에 급여가 4000 이상인 데이터는 테이블1에 입력,
	급여가 2000 ~ 4000 미만인 데이터는 테이블2에 입력,
	그 외에는 테이블3에 입력
 */
CREATE TABLE EMP_CPY401 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY402 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY403 AS SELECT * FROM emp WHERE 1 = 0;
SELECT * FROM EMP_CPY401;
INSERT FIRST
	WHEN sal >= 4000 THEN
		INTO EMP_CPY401(empno, ename, sal) values(empno, ename, sal)
	WHEN sal >= 2000 THEN
		INTO EMP_CPY402(empno, ename, sal) values(empno, ename, sal)
	ELSE
		INTO EMP_CPY403(empno, ename, sal) values(empno, ename, sal)
SELECT empno, ename, sal
FROM emp;
SELECT * FROM EMP_CPY401;
SELECT * FROM EMP_CPY402;
SELECT * FROM EMP_CPY403;
-- ex) EMP_CPY501, EMP_CPY502, EMP_CPY503, EMP_CPY504를 만들고
--		사원 입사분기별로 사원데이터를 각각 입력 처리하세요.
CREATE TABLE EMP_CPY501 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY502 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY503 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE EMP_CPY504 AS SELECT * FROM emp WHERE 1 = 0;

INSERT FIRST
	WHEN to_char(hiredate, 'Q') = 1 THEN INTO EMP_CPY501 values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
	WHEN to_char(hiredate, 'Q') = 2 THEN INTO EMP_CPY502 values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
	WHEN to_char(hiredate, 'Q') = 3 THEN INTO EMP_CPY503 values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
	WHEN to_char(hiredate, 'Q') = 4 THEN INTO EMP_CPY504 values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
	-- 마지막 줄은 ELSE INTO EMP_CPY504 values(데이터 ~)로도 쓸 수 있다.
SELECT * FROM emp;

SELECT * FROM EMP_CPY501;
SELECT * FROM EMP_CPY502;
SELECT * FROM EMP_CPY503;
SELECT * FROM EMP_CPY504;

