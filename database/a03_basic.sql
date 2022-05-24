/*
# NULL 데이터
1. database에서는 테이블 내의 특정 컬럼에 데이터가 없는 것을 NULL이라고 한다.
2. 미확인 값이나 아직 값이 적용되지 않는 것을 의미한다.
3. 0이나 ''(공백)과 구분되어 정의되지 않는 값을 의미한다.
	''도 null로 인식하는 경우가 있다.
	cf) 프로그램의 primitive 데이터의 초기값 설정과 차이가 있다.
*/
SELECT  * FROM EMP_CP100;
INSERT INTO EMP_CP100(ename) values(null);
INSERT INTO EMP_CP100(ename) values('');
INSERT INTO EMP_CP100(ename) values(' '); -- DB에서는 null로 처리된다.
/*
4. NULL값과 다른 데이터의 연산 결과값은 NULL이 된다.
	SELECT sal + NULL ==> NULL
5. 위와 같이 특정한 숫자형 데이터와 연산 시, NULL이 되므로, NULL 값이 나올 때는
	default값을 0으로 설정하여야 정상적인 연산을 할 수 있다.
	cf) 이 때, null 리 관련 함수들을 필요로 한다. nvl, nullif
	대표적인 nvl(데이터, null일 때 처리할 default값) ==> 함수에서 다시 진행합니다.
6. 조건절에 null을 검색하려면 컬럼명 = null은 처리가 안 된다.
	반드시 컬러명 is null 형태로 처리해야 한다.
	cf) null이 아닌 경우를 검색할 때는 컬럼명 is not null
 */
-- null 값의 연산 결과는 null이 된다.

-- empno(사원번호), ename(사원명), job(직책명), mgr(관리자번호),
-- hiredate(입사일), comm(보너스), deptno(부서번호)

SELECT sal, comm, sal + comm 합산, sal + nvl(comm,0) nvl처리합산
FROM emp;
-- comm가 null인 데이터 검색
SELECT empno, comm
FROM emp
WHERE comm IS NULL;
-- comm = NULL; 안 됨
SELECT empno, comm
FROM emp
WHERE comm IS NOT NULL; -- NULL 아닌 데이터 검색
-- ex1) 관리자 번호가 null인 사원과 같은 부서에 있는 사원을 출력하세요.
SELECT ename
FROM emp
WHERE deptno IN (
	SELECT deptno
	FROM emp
	WHERE mgr IS NULL
);
-- ex2) 보너스가 있는 사원의 사원명과 보너스의 합산을 출력하세요
SELECT ename, sal, comm, sal + comm 합산
FROM emp
--WHERE comm IS NOT NULL; -- comm = 0인 경우는 제외되지 않음
WHERE nvl(comm, 0) > 0; -- null과 0을 함께 제외
-- 데이터가 0인 경우와 null인 경우를 둘 다 제외시켜야 하는 경우가 많다.
-- 이런 경우 함수(nvl)을 활용하여 처리한다.





