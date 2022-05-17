/*
# 데이터 조회하기
데이터는 SELECT 구문을 이용하여 저장된 데이터를 호출(query)할 수 있다.
1. 기본 형식
	SELECT *
		컬럼1, 컬럼2
	FROM 테이블명
	WHERE 조건
*/
SELECT *
FROM emp;
-- select ename, job, deptno
FROM emp;
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
*/
SELECT empno, empno + 10 "10더함", sal, sal * 0.5 "급여의 50%", deptno,
		sal * (deptno / 100) "급여와 부서의 연산"
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




