SELECT ename, deptno
FROM emp;
SELECT *
FROM dept;
-- SMITH의 부서이름과 부서위치를 확인하기 위해서 join을 하지 않는 경우
SELECT ename, deptno
FROM emp
WHERE ename = 'SMITH';
-- 20
SELECT *
FROM dept
WHERE deptno = 20;
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.deptno;
/*
dept라는 부서테이블 정보를 emp라는 사원정보와 연결관계를 설정하는데
부서라는 정보에 여러 개의 사원 정보를 연결할 수 있어,
1:다 관계로 설정이 된 연관관계 테이블이다.
중간에 연결되는 컬럼은 deptno로 연결하여 처리한다.
ps) WHERE e.deptno = d.deptno
위와 같이 중첩되는 컬럼의 경우, 어느 테이블에 종속된 컬럼인지 반드시
앞에 테이블명이나 별칭으로 구분하여야 한다.
 */
-- 두 개의 테이블은 deptno(부서번호)를 기준으로 연관관계를 설정하기 때문ㅇ
-- e.deptno = d.deptno; 사원테이블의 부서번호와 부서테이블의 부서번호를 조인하여 확인한다.
/*
# 조인(join)
1. 조인의 개념
	1) 하나의 sql 명령문에 의해 여러 테이블에 저장된 데이터를 한 번에 조회할 수 있는 기능을 말한다.
	2) 관계형 데이터베이스 분야의 표준 : entity relation diagram(ER)
	3) 두 개 이상의 테이블을 결합한다는 의미
2. 조인의 필요성
	1) 조인을 사용하지 않는 일반적인 예
		학생 주소록을 출력하기 위해 학생들의 학번, 이름, 소속학과 이름을 검색
		학생에 대한 정보 검색하는 단계 필요
		학생 정보에서 소속학과번호 정보를 추출하여 소속학과 이름을 검색하는 단계 필요
	
	ex) 사원번호가 7369인 사원의 이름과 부서이름, 부서위치를 출력하세요.
		- 사원정보에서 부서번호를 가져온다.
		- 부서정보에서 부서이름과 부서위치를 가져온다.
	2) 조인을 하는 경우
		- 연관관계에 있는 deptno를 조회조건으로 검색하면 한 번에 원하는 데이터를 가져올 수 있다.
 */
SELECT *
FROM emp
WHERE empno = 7369;

SELECT *
FROM dept
WHERE deptno = 20;

SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND empno = 7369;

-- ex) ename이 ALLEN인 경우의 부서이름과 부서위치를 가져오되,
--		 조인을 하지 않는 경우와 조인을 한 경우 두 가지를 처리하여 출력하세요.
SELECT deptno
FROM emp
WHERE ename = 'ALLEN'; -- deptno = 30

SELECT LOC
FROM dept
WHERE deptno = 30; -- LOC = CHICAGO

SELECT d.dname, d.loc, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND ename = 'ALLEN'; -- 부서이름(DNAME) : SALES, 부서위치(LOC) : CHICAGO

SELECT d.dname, d.loc, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND loc = 'DALLAS';

-- 중첩되는 컬럼(공통컬럼)은 반드시 어떤 테이블 소속인지를 명기해야 되지만
-- 컬럼명이 다른 각각의 컬럼을 테이블명이 테이블의 alias(별칭 e., d.)을 사용하지 않아도 된다.
SELECT d.dname, d.loc, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal >= 3000;

SELECT e.*, d.*
FROM emp e, dept d;
-- 카티션 곱 조인 : 부서번호 10, 사원정보 13개 전부 표시, 부서 20, 사원정보 13개 전부 표시
/*
# equi join
1. 개념
	1) 조인 대상 테이블에서 공통 컬럼을 '='(equal) 비교를 통해
	같은 값을 가지는 행과 연결하여 결과를 생성하는 조인 방법
	2) SQL 명령문에서 가장 많이 사용하는 조인 방법
	3) 조인 애트리뷰트(속성)
2. WHERE 절을 이용한 equi join 사용법
	SELECT 테이블1.컬럼명, 테이블2.컬럼명
	FROM 테이블1, 테이블2
	WHERE 테이블1.컬럼명 = 테이블2.컬럼명
	1) FROM : 조인 대상 테이블을 기술한다. 테이블은 콤마(,)로 구분
	2) WHERE : 조인 애트리뷰트와 '=' 연산자를 사용하여 조인 조건을 기술
3. oracle에서 지원하는 natural join
	1) 자연조인을 이용한 equi join
		오라클 9i 버전부터 equi join을 자연조인이라고 명명
		WHERE 절을 사용하지 않고 natural join 키워드 사용
		오라클에서 자동적으로 테이블의 모든 컬럼을 대상으로 공동 컬럼을 조사 후,
		내부적으로 조인문 생성
		- 테이블 간에 컬럼명과 type이 같은 겉을 확인하여,
			같은 데이터가 있는 row 단위로 연결하여 출력한다.
	2) 기본 형식
		SELECT 테이블1.컬럼명, 테이블2.컬럼명
		FROM 테이블1 natural join 테이블2
 */
SELECT *
FROM emp NATURAL JOIN dept;
-- deptno가 같은 type이고 같은 이름이어서 데이터를 확인하여 동일한 데이터가 있는 row 단위로 출력한다.

CREATE TABLE emp200
AS SELECT * FROM emp WHERE deptno = 10;
CREATE TABLE dept200
AS SELECT * FROM dept;
-- ex) emp200과 dept200을 natural join 하여 부서명, 사원번호, 사원명, 직책명, 급여 출력하세요.
SELECT dname, empno, ename, job, sal
FROM emp200 NATURAL JOIN dept200;
/*
# join ~ using 절을 이용한 equi join
1. using에 조인 대상 컬럼을 지정
	컬럼 이름은 조인 대상 테이블에서 동일한 이름으로 정의되어 있어야 함.
2. 사용법
	select 테입르1.컬럼명, 테이블2.컬럼명
	from 테이블1 join 테이블2
		using(컬럼명)
3. 주의 : 조인 애트리뷰트에 테이블 별명을 사용하면 오류 발생
 */
SELECT *
FROM emp JOIN dept
USING (deptno);
/*
# non-equi join (완전히 동일하지는 않다는 뜻)
1. <, between a and b와 같이 '=' 조건과 같이 동일하지 않고,
	범위를 지정하여 조인하는 경우를 말한다.
2. 사용예
	급여의 등급 테이블을 사원정보의 급여 테이블과 non-equi join 하여 처리한다.
 */
SELECT *
FROM salgrade;
SELECT ename, sal, grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;

CREATE TABLE salgrade02
AS SELECT * FROM salgrade;

SELECT * FROM salgrade02;
-- ex) emp와 salgrade02를 조인하여 사원명, 급여, 급여등급을 출력하세요.
SELECT ename, sal, grade
FROM emp e, salgrade02 s
WHERE sal BETWEEN losal AND hisal;


