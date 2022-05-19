 SELECT * FROM emp;
 /*
# 중복제어 DISTINCT
1. 특정한 데이터를 출력하는 것은 연관관계 없이 칼럼으로 출력된다.
2. 특정 칼럼의 데이터 중에 중복된 것을 제외시키고 출력할 때에는 DISTINCT 컬럼명 형식으로 처리한다.
3. 2개 이상의 컬럼에서도 중복된 데이터를 제외시킬 수 있다.
	해당 컬럼을 체크해도 동일할 때에는 제외를 한다.
==> 행 단위로 동일한 데이터가 나타나지 않게  처리
*/
SELECT * FROM emp;
SELECT deptno FROM emp;
SELECT DISTINCT deptno FROM emp;
SELECT mgr, deptno FROM emp;
SELECT DISTINCT mgr, deptno FROM emp;
-- 아래와 같이 컬럼을 출력하되,
-- ex1) job(직책)이 같은 데이터를 제외하세요.
SELECT DISTINCT job FROM emp;
-- ex2) job, mgr(관리자번호) 둘 다 같은 데이터를 제외하세요.
SELECT DISTINCT job, mgr FROM emp;
/*
# 기본적인 sql 질의어 구조
1. 기본형식
	SELECT : 열 단위 컬럼을 선택
	FROM 테이블명
	WHERE 조건 : 행 단위 filtering을 처리
	GROUB BY : 그룹별로 데이터를 처리할 때 - 함수 파트 그룹 함수 진행 시 다시..
		ex) 부서별 평균급여, 직책별 최고급여
	ORDER BY 컬럼 : 정렬할 컬럼의 우선순위
 */
SELECT * FROM emp;
/*
# WHERE 조건
1. 행 단위로 조건/논리식을 통해서 행 단위 데이터를 선택처리한다.
2. 기본 형식
	SELECT * FROM 테이블
	WHERE 컬럼명 비교/논리연산자 데이터값
*/
SELECT *
FROM emp
WHERE sal >= 3000; -- sal가 3000 이상인 데이터를 ROW 단위로 필터링 처리

SELECT  * FROM emp;
-- ex) sal가 2000 이하인 데이터를 출력하세요.
SELECT *
FROM emp
WHERE sal <= 2000;
/*
# WHERE 조건절
1. 테이블에 저장된 데이터 중에서 원하는 데이터만 선택적으로 검새하는 기능을 처리할 때 활용된다.
2. WHERE 절의 조건문은 컬럼이름, 연산자, 상수, 산술 표현식을 결합하여 다양한 형태로 표현한다.
	ex) empno = 7900, ename = 'SMITH', sal >= 3000 and sal <= 5000
3. WHERE 절에서 사용하는 데이터 타입은 문자, 숫자, 날짜 타입을 사용할 수 있다.
	문자나 문자열은 '문자열'로 활용하고 숫자는 데이터 그대로, 날짜는 형변환 함수를 이용해서 검색한다.
	// ""(쌍따옴표)는 alias에만 사용한다.
	ex) job = 'SALESMAN', deptno = 10, hiredate = to_date('YYYYMM', '190812')
4. 데이터는 대소문자를 구분한다.
	job = 'salesman'로는 emp의 SALESMAN 데이터를 검색할 수 없다.
5. 논리 연산자를 활용한다.
	and, or, not	&&(x), ||(x)
	ex) job = 'SALESMAN' AND sal >= 2000,
			deptno = 10 or deptno = 30
*/
-- 부서번호가 10인 사원테이블의 사원명, 부서명, 사원번호 출력
SELECT ename, deptno, empno
FROM emp
WHERE deptno = 10;
-- empno(사원번호), ename(사원명), job(직책명), mgr(관리자번호),
-- hiredate(입사일), comm(보너스), deptno(부서번호)
-- ex) 직책명이 SALESMAN인 사원정보에서 사원명, 직책명, 급여를 출력하세요.
SELECT ename, job, sal
FROM emp
WHERE job = 'SALESMAN';
-- 비교문 1 AND 비교문2, 비교문1 OR 비교문2
-- ex) 급여가 2000에서 3000 사이이거나, 직책이 MANAGER인
-- 사원의 사원번호, 사원명, 직책명, 급여를 출력하세요.
SELECT empno, ename, job, sal
FROM emp
WHERE (sal >= 2000 AND sal <= 3000) OR job = 'MANAGER';
-- ex1) 논리연산자(!=) 부서번호 10이 아니고, 급여가 3000 이상인 사원명, 사원번호, 급여, 부서번호를 출력하세요.
SELECT ename, empno, sal, deptno
FROM emp
WHERE deptno != 10 AND sal >= 3000;
-- WHERE NOT(deptno = 10 or sal < 3000); 위 조건문과 동일
/*
# 키워드 연산식
1. NOT(조건식) : 해당 조건식의 반대 조건
2. 컬렴명 BETWEEN A AND B : 특정 컬럼이 A와 B 사이의 데이터
	다음의 논리식과 동일 : 컬럼명 >= A AND 컬렴명 <= B
3. 컬럼명 in (데이터1, 데이터2, ...)
	해당 컬럼의 데이터를 나열된 조건으로 or 처리되는 결과값을 가져올 때 사용된다.
4. 컬럼명 like '키워드검색'
	1) 키워드검색 유형
		'데이터%' : 해당 데이터로 시작
		'%데이터' : 해당 데이터로 끝
		'%데이터%' : 해당 데이터 포함
		'_데이터' : 첫 자 이후에 특정데이터 포함 - 자릿수 keyword 검색
		'데이터_' : 데이터가 마지막 한자 데이터 포함
 */
SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
-- ex) 사원번호 7500 ~ 7800 사이를 검색해서 사원번호, 사원명, 입사일을 출력하세요.
SELECT empno, ename, hiredate
FROM emp
WHERE empno BETWEEN 7500 AND 7800;
-- 3. 컬럼명 in (데이터1, 데이터2, ...)
--		1) 부서번호가 10, 30인 사원 정보 출력
--		2) 검색결과의 조회를 통해서 다시 검색조건 처리
--			SELECT *
--			FROM  테이블
--			WHERE 컬럼명 in (select 컬럼 from ...)
SELECT *
FROM emp
WHERE deptno IN (10, 30);
-- ex) 사원번호가 7782, 7844, 7934인 데이터의 사원명, 사원번호, 부서번호를 출력하세요.
SELECT ename, empno, deptno
FROM emp
WHERE empno IN (7782, 7844, 7934);
-- 급여가 2000~3000 사이인 사원의 부서번호를 검색해서 해당 부서의 사원들을 출력
SELECT ename
FROM emp
WHERE deptno IN (
	SELECT deptno
	FROM emp
	WHERE sal BETWEEN 2000 AND 3000
);
-- ex) in subquery 부서번호 10, 30에 해당하는 직책을 검색해서
--		그 직책에 해당하는 사원의 사원명, 직책명, 부서번호를 출력하세요.
SELECT ename, job, deptno
FROM emp
WHERE job IN (
	SELECT job
	FROM emp
	WHERE deptno IN (10, 30)
);
-- 키워드 검색 1: 포함되어 있으면 모두 다 검색 : 컬럼명 like '%검색키워드%'
-- 직책에 'ER'이 있으면 모두 검색
SELECT *
FROM emp
WHERE  job LIKE '%ER%';
-- ex) 사원이름에 'A'가 포함되고 급여가 1000~3000 사이인 데이터를 출력하세요.
SELECT *
FROM emp
WHERE ename LIKE '%A%' AND sal BETWEEN 1000 AND 3000;

SELECT *
FROM emp
WHERE to_char(hiredate) LIKE '81/04%'; -- 1981년 4월에 입사한 사람

--	like 문자열% : 해당 문자열로 시작
--	like %문자열 : 해당 문자열로 끝
--	like __A__ : 총 5자리이고 3번째 자리에 A가 들어가는 경우
--			__ : 자릿수의 개수까지 검색할 때 처리
-- 직책이 MAN으로 끝나는 사원 정보
SELECT *
FROM emp
WHERE job like '%MAN';

SELECT *
FROM emp;
-- 직책의 3번째 자리에 E가 포함된 사원 정보
SELECT *
FROM emp
WHERE job LIKE '__E%';
-- ex) 직책의 두번째 자리가 A이고 마지막에 ER로 끝나는 사원정보를 검색하세요.
SELECT *
FROM emp
WHERE job LIKE '_A%ER';




