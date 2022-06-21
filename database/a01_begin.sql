/*
# 데이터 sql 처리 파일
1. 변경된 파일 바로 반영 :
	상단 툴바 Window ==> Preferences ==> General
	==> Workspace ==> refresh ... : check ==> Apply
2. 저장 시, 확장자명을 .sql로 저장
3. 상단 툴바에서 DB서버와 계정을 선택하고 적어 놓은 sql문을 실행할 수 있다.
4. 새 파일 만들기 : 상단 툴바 SQL 편집기 ==> 새 SQL 편집기 클릭
 */
/*
# 데이터 조회하기
데이터는 SELECT 구문을 이용하여 저장된 데이터를 호출(query)할 수 있다.
1. 기본 형식
	SELECT *
		컬럼1, 컬럼2
	FROM 테이블명
	WHERE 조건
*/
SELECT * FROM emp;
-- select ename, job, deptno
-- ctrl + / (한줄 주석 단축키)
-- ex1) dept 테이블의 전체 데이터를 검색
-- ex2) emp 테이블의 empno, mgr, hiredate, deptno를 출력하세요.
SELECT empno, mgr, hiredate, deptno
FROM emp;
/*
2. 테이블명과 컬럼명에 별칭(alias) 처리하기
	테이블명과 컬럼명이 as라는 키워드를 쓰거나 공백을 통해서 별칭을 선언하며,
	컬럼명이나 테이블명으로 활용할 수 있다.
*/
SELECT empno,
	empno AS NO,	-- AS 키워드를 이용해서 별칭 사용
	ename AS name,
	hiredate hire	-- " " 공백을 삽입하여 별칭으로 처리
	deptno dno
FROM emp;
-- ex) 다음과 같이 별칭으로 as, 공백을 이용하여 출력하세요
--	emono ==> eno, ename ==> name, mgr ==> management, sal ==> salary
SELECT * FROM emp;
SELECT emono AS eno,
	ename name,
	mgr AS management,
	sal salary;
FROM emp;
-- 기본적인 테이블 처리 문법은 아래와 같이 테이블명.컬럼명으로 적는데,
-- 테이블이 하나 밖에 없을 때엔 테이블을 생략한다.
SELECT emp.empno
FROM emp;
SELECT e.empno, e.ename
FROM emp e;	-- 테이블명은 한 칸 띄워 alias를 사용하여 처리한다.
-- 전체 컬럼을 출력하고, 추가적으로 처리할 때는 아래와 같이 처리한다.
SELECT  empno NO, *
FROM emp; -- 실행 에러 발생 ==> 아래와 같이 처리한다.

SELECT empno NO, e.*
FROM emp e;
-- 컬럼의 alias에 공백이나 허용되지 않는 특수문자를 사용할 때는 컬럼명 "alias명"으로 사용하여 처리한다.
SELECT empno "번 호" -- 중간에 공백을 넣어서 alias를 활용할 때 사용한다.
		sal "#급여" -- alias명으로 허용되지 않는 특수문자를 사용할 때에도 "특수문자"로 처리한다.
FROM emp;
-- ex) 해당 컬럼을 alias로 처리하여 출력하세요	empno("사 원 번 호"), ename("@사원명@"), sal("급여")
SELECT empno "사 원 번 호",
		ename "@사원명@",
		sal 급여
FROM emp;
/*
# 데이터의 산출 연산 처리와 문자열 연결
1. 숫자형 데이터가 있는 컬럼은 연산처리가 가능하다.
	사칙연산자(+, -, *, /), %(지원하지 않음 - mod(데이터1, 데이터2) - 함수 파트에서 진행
	
*/
SELECT empno, empno + 10 "10더함", sal, sal * 0.5 "급여의 50%", deptno,
		sal * (deptno / 100) "급여와 부서의 연산",
		MOD(sal, deptno) "나머지"
FROM emp;
-- ex) 사원번호를 만단위체계로 바꾸기 위해 10000을 더하여 처리하고, sal와 comm을 합산하여 총급여로 표현하세요.
SELECT empno, empno + 10000 "10000 더함", sal, comm, sal + COMM 총급여, sal + nvl(comm, 0) 총급여2
FROM emp;
-- 		cf) null값인 데이터를 연산하면 null이 처리된다.
-- 			nvl(컬럼) 컬럼이 null(데이터가 없을 때, 초기데이터), 초기데이터로 처리
/*
2. 컬럼과문자열 연결 처리 ||
	1) 기본형식
		select 컬럼명 || '연결할문자열', 컬럼명1 || 컬럼명2
 */
SELECT empno || '번' 사원번호,
		ename || empno "이름과 사원번호",
		deptno || '/' || empno || '/' || ename "부서번호/사원명/이름"
FROM emp;
SELECT * FROM emp;
-- empno(사원번호), ename(사원명), job(직책), mgr(관리자번호),
-- hiredate(입사일), sal(급여), comm(보너스), deptno(부서번호)
-- ex1) 사원명 @@@의 사원번호는 @@@ 입니다. ename, empno를 활용하여 출력하세요.
SELECT '사원명 ' || ename || '의 사원번호는 ' || empno || ' 입니다.' show
FROM emp;
-- ex2) 사원명의 월급여(sal의 1/12)를 아래 형식으로 출력하세요. ename, sal
--			@@@의 월급여는 @@ 입니다.
SELECT ename || '의 월급여는 ' || round(sal/12) || ' 입니다.' show
FROM emp;	-- round() : 반올림, ceil() 올림, floor() : 내림 ==> 내장 함수 시 진행


GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT IDENTIFIED BY tiger;
ALTER USER SCOTT DEFAULT TABLESPACE USERS;
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;
CONNECT SCOTT/tiegr
DROP TABLE DEPT;
CREATE TABLE DEPT
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	DNAME VARCHAR2(14) ,
	LOC VARCHAR2(13) ) ;
DROP TABLE EMP;
CREATE TABLE EMP
       (EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);
INSERT INTO DEPT VALUES
	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES
	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES
	(40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-JUL-87')-85,3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-JUL-87')-51,1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
DROP TABLE BONUS;
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10)	,
	JOB VARCHAR2(9)  ,
	SAL NUMBER,
	COMM NUMBER
	) ;
DROP TABLE SALGRADE;
CREATE TABLE SALGRADE
      ( GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER );
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;

SET TERMOUT ON
SET ECHO ON
