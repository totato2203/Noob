/*
# 날짜 함수
1. 날짜형 데이터
	1/1000 ==> 1초 ==> (60)1분 ==> (60)1시간 ==> (24)1일 ==> (28, 30, 31)1월 ==> (12)1년
2. 기본 연산
	날짜 + 1 : 해당 날짜의 1일 이후 처리
	날짜 - 1 : 해당 날짜의 1일 이전 처리
	날짜 + 1/24 : 해당 날싸의 1시간 이후 처리
	ex) 현재 시간이 15:18일 때, 9시간 이후 날짜는 내일이 된다.	날짜 + 9/24
3. 기본 함수
	sysdate : 현재 시간과 날짜를 날짜형으로 나타내는 키워드
*/
SELECT sysdate 현재, sysdate + 1 내일, sysdate - 1 어제,
		sysdate + (10/24) "10시간 이후" FROM dual;
-- ex) 인턴기간(입사 후 120일)과 입사8시간전, 근무일수를 아래와 같이 출력하세요.
-- 사원번호, 사원명, 입사8시간전, 입사일, 인턴기간, 현재근무일수(절삭)
SELECT empno 사원번호, ename 사원명, (hiredate - 8/24) 입사8시간전,
hiredate 입사일, hiredate + 120 인턴기간, floor(sysdate - hiredate) 현재근무일수
FROM emp;
/*
	2) months_between(날짜1, 날짜2) : 날짜 사이의 개월 수를 표기한다.
		5/19, 6/19 ==> 1개월, 15일 ==> 0.5개월
		- 소수점 이하의 데이터를 floor로 절삭하는 경우가 많다.
 */
SELECT ename, hiredate, months_between(sysdate, hiredate) 근무개월수,
	trunc(months_between(sysdate, hiredate)) 근무개월수2,
	floor(months_between(sysdate, hiredate)/12) 근무연한
FROM emp;
-- ex1) 오늘로부터 100일 후 개월수를 출력(dual, 소수점 이하 표기, 절삭하기)
SELECT sysdate, sysdate + 100,
months_between(sysdate + 100, sysdate) "100일 후 개월수 1",
floor(months_between(sysdate + 100, sysdate)) "100일 후 개월수 2"
FROM dual;
/*
	3) add_months(날짜형데이터, 추가할개월수) : 해당 날짜에 개월을 더한 날짜 계산
 */
SELECT sysdate, add_months(sysdate, 4) FROM dual;
-- 사원정보를 통해 부서별로 인턴기간을 다르게 처리한다고 한다. 인턴기간의 만료일
-- 부서번호 : 10 ==> 1개월, 20 ==> 2개월, ...
SELECT ename, deptno, hiredate, deptno/10 "인턴기간(개월)",
	add_months(hiredate, deptno/10)
FROM emp;


