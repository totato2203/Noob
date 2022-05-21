/*
# 데이터의 타입 변환
1. oracle에서는 크게, 문자열형, 숫자형, 날짜형으로 나누어진다.
2. 각 데이터는 유형에 따라서 변환이 일어난다.
	문자열 ==> 숫자, 숫자 ==> 문자열
	숫자 ==> 날짜, 날짜 ==> 숫자
	날짜 ==> 문자열, 문자열 ==> 날짜
3. 형변환의 유형
	1) 묵시적 형변환 : oracle 서버에서 자동적으로 형변환을 하여 처리
	2) 명시적 형변환 : 변환 함수를 통해서 명시적으로 형변환을 처리한다.
	
# 묵시적 형변환
1. 묵시적인 데이터 타입 변환은 정확한 연산을 위하여
	오라클 서버 시스템 내부에서 타입을 내부적으로 변환해서 처리해주는 경우를 말한다.
*/
-- 문자열을 묵시적으로 숫자로 변환해서 조건처리
SELECT *
FROM emp
WHERE sal = '800';
-- 명시적 형변환인 to_number() 함수를 통해서 처리한다.
SELECT *
FROM emp
WHERE sal = to_number('800');
-- 날짜형의 묵시적 형변환
SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '%81%';
-- ==>
SELECT ename, hiredate, to_char(hiredate)
FROM emp
WHERE to_char(hiredate) LIKE '81%';
/*
# 명시적 데이터 변환
1. 사용자가 데이터 타입 변환 함수를 이용하여 명시적으로 데이터 타입을 변환 처리하는 것을 말한다.
2. 명시적 데이터 타입 변환 함수
	1) to_char() : 숫자/날짜 데이터를 문자형으로 변환
	2) to_number() : 문자열 데이터를 숫자형으로 변환
	3) to_date() : 문자열 데이터를 날짜형으로 변환
*/
-- # to_char함수
-- to_char(number | date 타입, 'format')
-- 1) 날짜형 데이터의 문자열 format 처리
SELECT sysdate,
	to_char(sysdate, 'CC'), -- 세기 표현
	to_char(sysdate, 'YYYY'), -- 연도 표현
	to_char(sysdate, 'MM'), -- 월 표기
	to_char(sysdate, 'DD'), -- 일 표기
	to_char(sysdate, 'YYYY/MM/DD') --  현재 날짜를 YYYY/MM/DD 표기
FROM dual;
-- ex) to_char 활용하여, 1980에 입사한 사원의 이름, 입사년도, 입사월, 입사일을 출력하세요.
SELECT ename,
to_char(hiredate, 'YYYY') 입사년도,
to_char(hiredate, 'MM') 입사월,
to_char(hiredate, 'DD') 입사일,
to_char(hiredate, 'YYYY/MM/DD') 입사일
FROM emp
WHERE to_char(hiredate, 'YYYY') = '1980';
/*
2) 기타 날짜 관련 함수 매개변수 형식
	to_char(날짜형데이터, 형식)
	'Q' : 분기, 'MM' : 월, 'MONTH' : 월 영문,
	'WW' : 연 단위 주표기 @@@@년도 @@째주,
	'W' : 월 단위 주표기 @@월의 @@째주,
	'DD' : 일 표기
	'DY' | 'DAY' : 요일 표기
 */
SELECT ename, hiredate,
	to_char(hiredate, 'Q') "분기",
	to_char(hiredate, 'MONTH') "월",
	to_char(hiredate, 'WW') "연 단위(주)",
	to_char(hiredate, 'W') "월 단위(주)",
	to_char(hiredate, 'DAY') "요일"
FROM emp;
-- ex) 1981년도 1/4 분기에 입사한 사원의 이름, 입사년도, 월단위 주, 월, 날짜를 표기하세요.
SELECT ename,
to_char(hiredate),
to_char(hiredate, 'Q'),
to_char(hiredate, 'W'),
to_char(hiredate, 'YYYY'),
to_char(hiredate, 'MM'),
to_char(hiredate, 'DD')
FROM emp
--WHERE to_char(hiredate, 'YYYY') = '1981' AND to_char(hiredate, 'Q') = 1;
WHERE to_char(hiredate, 'YYYY Q') = '1981 1';
-- 3) to_char(숫자형, '출력형식')
--		숫자형 데이터를 지정한 출력 형식으로 문자열 출력
--		- 출력 형식 : $9999(달러형 표기), 9999.99(소수점 두 자리),
--					'9,999,999' 해당 자리수 안에서 첫 단위 ,(콤마) 표시
SELECT ename, sal, to_char(sal, '$9999') "달러표기",
	to_char(sal, '9999.99') "소수점 표기",
	to_char(sal, '9,999,999') "첫 단위 콤마"
FROM emp;
-- ex) 사원명, 급여, 급여 + 보너스(천 단위 콤마 표기) 총계로 출력하세요.
SELECT ename, sal, comm, to_char(sal + nvl(comm, 0), '9,999') 총계
FROM emp;
/*
	4) to_number
		- 숫자 형태의 문자열로 구성된 데이터를 숫자로 변환 처리
		- 형식
			to_number('숫자형태문자열')
		ps) 프로그래밍에서 입력되는 데이터는 문자열이기 때문에 숫자형의 데이터는
		형변환 함수를 통해서 처리하는 경우가 많다.
 */
-- 문자열로 '2000'인 데이터를 이용하여 2000 이상인 급여 데이터를 조회 처리
SELECT *
FROM emp
WHERE sal >= to_number('2000');
-- 입사일이 3분기, 4분기 데이터를 검색하고자 한다.
SELECT ename, hiredate, to_char(hiredate, 'Q') "분기",
to_number(to_char(hiredate, 'Q')) "분기(숫자)"
FROM emp
WHERE to_number(to_char(hiredate, 'Q')) >= 3;
-- ps) 위 같은 경우도 자동형변환에 의해 처리를 할 수 있지만, 가능한한 함수를 정확하게 처리하자.
-- ex) 입사일이 15일 이후인 사원들을 출력하세요.
SELECT ename, hiredate, to_number(to_char(hiredate, 'DD'))
FROM emp
WHERE to_number(to_char(hiredate, 'DD')) >= 15;
/*
# 중첩함수
1. 가장 내부에 있는 함수 F1의 결과값을 다음 함수 F2에 인수로 적용하고,
	다시 F2의 결과값을 F3의 인수로 사용할 때,
	F1, F2, F3라는 함수를 중첩 사용한다고 한다.
	기본 형식 : F3(F2(F1(데이터/컬럼, arg1), arg2), arg3)
 */
-- 입사년도 1981 ==> 올해 연도로 변경하여 데이터를 출력하자
SELECT to_char(sysdate, 'YYYY') "올해 연도"
FROM dual;
SELECT ename, hiredate,
	to_char(sysdate, 'YYYY') || to_char(hiredate, 'MMDD') "올해 입사",
	to_date(to_char(sysdate, 'YYYY') || to_char(hiredate, 'MMDD'), 'YYYYMMDD') "날짜형 변경"
FROM emp;

