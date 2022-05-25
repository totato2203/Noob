--2022-05-19
--[1단계:개념] 1. 데이터베이스의 정렬의 기본 형식을 기본 예제를 통해서 설명하세요.
SELECT *
FROM emp
ORDER BY job, empno DESC; -- 먼저 직책명 알파벳 (default)오름차순으로 정렬 후 사원번호 숫자 내림차순으로 정렬한다.

--[1단계:개념] 2. 함수는 크게 단일행/복수행 함수로 나누어진다. 이것의 구별기준을 예제로 설명하세요.

SELECT lower(ename) "(단일행) 소문자"
FROM emp;

SELECT deptno, ename
FROM emp
ORDER BY deptno; -- 복수형 함수 : 부서번호 오름차순으로 사원명 출력

--[1단계:확인] 3. 아래의 형식으로 함수를 적용해서 출력하되 ename이 대소문자 구분없이 a/A인 데이터가 두번째 포함되어 검색 되게 처리하세요.
--                The salary of Ward is @@@ won!!!
SELECT 'The salary of ' || ename || ' is ' || sal || ' won!!!' show
FROM emp
WHERE ename LIKE '_A%';

--[1단계:개념] 4. substr() 함수의 기본 매개변수와 기능을 기본예제를 통해서 설명하세요.
-- substr(문자열데이터, 시작위치, 시작위치에서개수)
SELECT ename, substr(ename, 2, 2) FROM emp;
 -- 2번째 글자에서부터 2글자를 뽑는다. ABCDEF라면 BC 

--[1단계:확인] 5. ename의 첫번째에서 3번째 데이터 추출, job과 혼합하여 화면에 출력하되, substr(), concat()함수를 활용하세요
SELECT ename, job, substr(ename, 1, 3), concat(substr(ename, 1, 3), job) FROM emp;

--[1단계:확인] 6. ||, substr을 활용하여 1980에 입사한 사람의 입사일정보를 @@@는 @@@@년 @@월 @@일에 입사했습니다.로 출력하세요(ename, hiredate활용)
SELECT ename || '는 '
|| '19'
|| substr(hiredate, 1, 2) || '년 '
|| substr(hiredate, 4, 2) || '월 '
|| substr(hiredate, 7, 2) || '일에 입사했습니다.' show
FROM emp;

--[1단계:개념] 7. instr의 기본 매개변수 옵션을 예제를 통해서 기술하세요.
-- instr(데이터, '검색할문자', 검색할시작위치, n번째매칭대상이나올위치)
SELECT ename, instr(ename, 'A', 1, 1) FROM emp; -- ename에서 'A'를 첫번째 자리부터 검색하고 첫번째 매칭 대상이 나올 위치를 출력함.

--[1단계:확인] 8. 사원번호, 사원명, 직책 급여을 출력하되, 사원명, 직책은 최고 크기를 확인하고, 
--                사원명과 직책은 각각 최고 크기의 기준으로 왼쪽과 오른쪽에 #을 삽입하여 출력하세요.
SELECT empno, ename, LENGTH(ename), job, length(job), sal -- ename 최고크기 : 6, job 최고크기 : 9
FROM emp;

SELECT empno, lpad(ename, 6, '#'), LENGTH(ename),
	rpad(job, 9, '#'), length(job), sal
FROM emp;

--[1단계:개념] 9. 숫자형 함수 중에 자리수 처리에 대한 처리를 함수별로 비교를 기술하세요.
-- round(데이터, 자릿수)(자릿수까지 반올림), trunc(데이터, 자릿수)(자릿수까지 절삭), 
-- ceil(데이터)(소수점 올림), floor(데이터)(소수점 내림)
SELECT round(22.8887, 2), trunc(22.8887, 2), ceil(22.8887), floor(22.8887) FROM dual;

--[1단계:확인] 10. 근무일수를 2분위로 나누어서(중앙값을 기준) 보너스를 급여의 150%,200% 차등 지급하기로 했다. 사원명, 입사일, 분류, 보너스금액
-- 1) 근무일수 확인
-- 2) 근무일수의 중앙값 추출 : 육안 14955
-- 3) 근무일수의 중앙값을 기준점으로 미만과 이상을 구분자로 준다.
--		이상인지 미만인지 구분 : 나눗셈을 통해 1이상이면 중앙값 이상, 1미만이면 중앙값 미만
-- 4) 위 구분자로 보너스를 150% ==> 1.5, 200% ==> 2.0으로 처리되게 한다.
--	0 ==> 1.5,	1 ==> 2.0
--	+3	3 ==> 1.5	4 ==> 2.0
--	*0.5 0.5 * 3 ==> 1.5,	0.5 * 4 ==> 2.0
SELECT hiredate, floor(sysdate - hiredate)
FROM emp
ORDER BY floor(sysdate - hiredate); -- 육안으로 추출한 중앙값 : 14955

SELECT 
	floor(median(sysdate - hiredate)) 중앙값,
	floor(avg(sysdate - hiredate)) 평균값
FROM emp;	-- 함수 이용 중앙값 : 14909, 평균값 : 14918
-- 중앙값 이상, 미만 구분
SELECT  ename, hiredate,
	floor(sysdate - hiredate),
	floor((sysdate - hiredate)/14955) 구분자,
	sal,
	sal * (floor((sysdate - hiredate)/14955) + 3) * 0.5 "보너스"
--	(floor((sysdate - hiredate)/14955)+3)*0.5)*100 || '%' "보너스(%)",
FROM emp;

SELECT ename, hiredate,
	floor(sysdate - hiredate),
	floor((sysdate - hiredate) / 14955) 구분자
FROM emp;

--SELECT ename, hiredate, floor(sysdate - hiredate) "200%", sal, sal * 2 보너스
--FROM emp
--WHERE floor(sysdate - hiredate) >= 7477;
--
--SELECT ename, hiredate, floor(sysdate - hiredate) "150%", sal, sal * 1.5 보너스
--FROM emp
--WHERE floor((sysdate - hiredate)/2) <= 7432;

--[1단계:확인] 11. 오늘을 1일을 기준으로 1000일 기념일의 날짜와  걸린 기간을 @@년 @@개월 @@일 형식으로 표기하세요. hint)mod함수 활용
SELECT sysdate "오늘",
	sysdate + 1000 "1000일 기념일",
	floor(months_between(sysdate + 1001, sysdate)) "월 계산",
	floor(months_between(sysdate + 1001, sysdate) / 12) "연 계산",
	mod(floor(months_between(sysdate+1001, sysdate)), 12) "월",
	mod(1001, floor(months_between(sysdate + 1001, sysdate))) "일",
	floor(months_between(sysdate + 1001, sysdate) / 12) || '년 ' ||
	mod(floor(months_between(sysdate+1001, sysdate)), 12) || '개월 ' ||
	mod(1001, floor(months_between(sysdate + 1001, sysdate))) || '일' "걸린 기간"
FROM dual;
/*
months_between : 월 계산에서 1.5 1개월 15일 ==> ceil floor을 통해서 차이가 남
 */
/*
# 기간 계산 처리 형식
1. 날짜 자체로 처리 방식
	1000 ==> /365(365로 나눠서) 년, /12(12로 나눠서) 월, /30(30으로 나눠서) 일
2. between_months로 날짜를 계산하여 처리하는 방식
	1) 사이의 월을 계산
		between_months(sysdate, sysdate + 1001)
		오늘이 1일이므로 +1을 더해서 월을 계산
	2) 월계산 / 12 == 연도계산
	3) 월계산 * 30 ==> 일계산 (위 날짜 자체 계산처리 방식에서 mod를 활용하여 처리)
	# cf 위 계산식에서 절삭(floor)과 나머지연산자(mod)를 활용해서 처리한다.
 */


--SELECT sysdate + 999 기념일, floor(999 / 365) || '년 ' || floor(MOD(999, 365) / 30) || '개월 ' || MOD(mod(999, 365), 30) || '일' 걸린기간
--FROM emp;

