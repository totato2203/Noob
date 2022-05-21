/*
# 기타일반 함수
1. null 처리
	1) nvl(데이터, null값일 때 처리할 데이터)
		해당 데이터가 null값일 때, 처리할 데이터를 설정해서 기본 데이터 설정을 통해
		연산 및 null로 인한 오류를 방지하고자 한다.
	2) 주의 : 초기값은 해당 데이터 유형과 동일해야 한다.
	3) nvl2(데이터, null값이 아닐 때 처리, null값일 때 처리)
		ex) comm이 null일 때는 100으로, null이 아닐 때는 현재 comm의 10%로 처리
2. 조건문 처리
 */
SELECT comm, nvl(comm, 0),
sal + comm, sal + nvl(comm, 0)
-- , nvl(comm, ' ') : comm이 숫자형인데 초기값을 ' ' 공백으로 문자열을 선언해서 에러가 발생했다.
FROM emp;

CREATE TABLE emp_cpy1001
AS SELECT * FROM emp;
SELECT * FROM emp_cpy1001;
SELECT ename, nvl(ename, '공백') 이름,
		sal, nvl(sal, 100) 급여
FROM emp;
/*
# nv12
 */
SELECT ename, sal, comm, nvl2(comm, comm * 1.1, 100) "보너스"
FROM emp;
/*
# nullif(데이터1, 데이터2)
두 개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고,
동일하지 않으면  첫번째 데이터1을 반환처리하는 함수를 말한다.
 */
SELECT  nullif('a', 'a') "동일할 때",
		nullif('a', 'b') "동일하지 않을 때",
		nvl(NULLIF('a', 'a'), '동일') "동일할 때",
		nvl(NULLIF('a', 'b'), '동일') "동일하지 않을 때"
FROM dual;
/*
# decode 함수
1. 데이터베이스에서 조건에 따라 처리할 때, 활용되는 함수이다.
2. 기본형식 : 매개변수의 개수는 짝수를 유지하여야 한다.
	decode(데이터1, 조건1, 데이터1과 조건1이 같을 때의 데이터, 같지 않을 때의 데이터)
 */
SELECT ename, deptno,
	decode(deptno, 	10, '인사과',
					20, '총무',
					30, 'IT사업부',
					40, '재무'
			'기타과') 부서명
FROM emp;


