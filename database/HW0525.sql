--2022-05-25
--[1단계:개념] 1. DML이란 무엇인가 종류를 기술하세요..
/*
# DML : 테이블에 여러 가지 기능을 적용할 수 있는 명령어를 일컫는다.
	1) insert : 새로운 데이터 입력 명령어
	2) update : 기존 데이터 수정 명령어
	3) delete : 기존 데이터 삭제 명령어
	4) merge : 두 테이블을 하나의 테이블로 병합하는 명령어
 */

--[1단계:확인] 2. emp테이블과 dept를 조인한 복사테이블로 emp_cp120만들어 
--      전체 데이터 입력과 특정 컬럼 입력을 처리하세요.
CREATE TABLE emp_cp120
AS SELECT * FROM EMP e NATURAL JOIN DEPT d;
SELECT * FROM emp_cp120;
INSERT INTO emp_cp120 values(10, 7777, 'QUEEN', 'TEACHER', 7839, sysdate, 7000, NULL, 'SALES', 'DALLAS'); -- 전체 데이터 입력
INSERT INTO emp_cp120(deptno, empno, ename, job, sal) values(20, 8888, 'JACK', 'STUDENT', 3400); -- 부분 데이터 입력

--[1단계:개념] 3. 명시적 null과 묵시적 null 데이터 입력의 차이점을 예제를 통해서 기술하세요.
/*
1. 명시적 NULL : 전체 또는 지정한 데이터를 입력할 때 값이 NULL인 부분은 NULL을 넣어서 표시한다.
2. 묵시적 NULL : 지정한 데이터를 입력할 때 지정하지 않은 부분은 묵시적으로 NULL값이 들어간다.
 */
INSERT INTO emp_cp120 values(30, 9999, 'GOD', 'GOD', NULL, sysdate, 9999, NULL, 'SALES', 'DALLAS');
-- mgr과 comm의 값을 넣지 않을 때 NULL을 넣어 표시한다.
INSERT INTO emp_cp120(deptno, empno, ename, job, sal) values(10, 6666, 'DEVIL', 'MONSETR', 3333);
-- deptno, empno, ename, job, sal 이외의 컬럼에는 자동으로 NULL값이 들어간다.
SELECT * FROM emp_cp120;

--[1단계:확인] 4. 현재 년도와 월을 기준으로 지정한 날짜와 시간(15일 오전 10:15)오후 12:25을 입력 처리하세요.
INSERT INTO emp_cp120(hiredate) values(to_date(to_char(sysdate, 'YYYY-MM') || '-15 10:15', 'YYYY-MM-DD HH:MI'));
INSERT INTO emp_cp120(hiredate) values(to_date(to_char(sysdate, 'YYYY-MM') || '-15 12:25', 'YYYY-MM-DD HH24:MI'));
SELECT * FROM emp_cp120;

--[1단계:개념] 5. 단일 데이터 입력과 다중 데이터 입력의 차이를 예제를 통해 기술하세요.
-- 다중 행 입력은 단일 행 입력과 다르게 조회된 데이터를 한 번에 여러 테이블에 입력할 수 있다.
INSERT INTO EMP_CP120(ename) values('김철수'); -- 단일 행 입력

CREATE TABLE emp_cp121 AS SELECT * FROM EMP e  NATURAL JOIN DEPT d WHERE 1 = 0;
CREATE TABLE emp_cp122 AS SELECT * FROM EMP e  NATURAL JOIN DEPT d WHERE 1 = 0;
CREATE TABLE emp_cp123 AS SELECT * FROM EMP e  NATURAL JOIN DEPT d WHERE 1 = 0;

INSERT ALL
	INTO EMP_CP121(deptno, ename, sal) values(deptno, ename, sal)
	INTO EMP_CP122(deptno, ename, sal) values(deptno, ename, sal)
	INTO EMP_CP123(deptno, ename, sal) values(deptno, ename, sal)
SELECT *
FROM emp
WHERE sal >= 1000;

SELECT * FROM EMP_CP121;
SELECT * FROM EMP_CP122;
SELECT * FROM EMP_CP123; -- 각 테이블 별로 같은 데이터(sal >= 1000인 deptno, ename, sal)가 입력되었다.

--[1단계:확인] 6. 직책별로 테이블을 만들어 사원정보를 한번에 입력 처리하세요.
CREATE TABLE emp_cp130 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE emp_cp131 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE emp_cp132 AS SELECT * FROM emp WHERE 1 = 0;
SELECT * FROM emp;
INSERT FIRST
	WHEN job = 'MANAGER' THEN INTO EMP_CP130(empno, ename, job, sal) values(empno, ename, job, sal)
	WHEN job = 'SALESMAN' THEN INTO EMP_CP131(empno, ename, job, sal) values(empno, ename, job, sal)
	WHEN job = 'CLERK' THEN INTO EMP_CP132(empno, ename, job, sal) values(empno, ename, job, sal)
SELECT * FROM emp;

SELECT * FROM EMP_CP130;
SELECT * FROM EMP_CP131;
SELECT * FROM EMP_CP132;

--[1단계:개념] 7. 데이터의 수정기본형식을 기술하세요..
UPDATE EMP_CP120
	SET job = '거지',
		mgr = NULL
	WHERE sal <= 1500;

SELECT * FROM EMP_CP120; -- sal <= 1500인 데이터는 모두 '거지'로 수정되었다.

--[1단계:확인] 8. 1사분기 최고 급여를 ALLEN의 급여로 수정 처리하세요
CREATE TABLE emp_cp133 AS SELECT * FROM emp;
SELECT * FROM EMP_CP133;

SELECT max(sal) FROM emp WHERE to_char(hiredate, 'Q') = 1; -- 1사분기 최고 급여 = 1600

UPDATE EMP_CP133
	SET sal = (
		SELECT max(sal)
		FROM emp
		WHERE to_char(hiredate, 'Q') = 1
	)
WHERE ename = 'ALLEN';

SELECT * FROM emp WHERE ename = 'ALLEN'; -- ALLEN의 sal = 1600으로 수정됨
