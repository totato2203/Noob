--2022-05-23
--[1단계:개념] 1. case when의 2가지 기본형식을 정리하고 예제를 통해서 비교하세요.
-- 형식 1)
SELECT sal,
CASE WHEN sal >= 5000 THEN 'A'
	 WHEN sal >= 4000 THEN 'B'
	 WHEN sal >= 3000 THEN 'C'
	 WHEN sal >= 2000 THEN 'D'
	 WHEN sal >= 0 THEN 'F'
	 ELSE '데이터 없음'
	 END 급여등급
FROM emp;
-- 형식2)
SELECT DISTINCT job
FROM emp;

SELECT DISTINCT job,
CASE job WHEN 'CLERK' THEN '서울'
		 WHEN 'SALESMAN' THEN '대전'
		 WHEN 'PRESIDENT' THEN '대구'
		 WHEN 'MANAGER' THEN '광주'
		 WHEN 'ANALYST' THEN '제주'
		 ELSE '데이터 없음'
		 END "직책별 출장지"
FROM emp;
	 
--[1단계:확인] 2. 입사월을 3가지 분류를 나누어 보너스금액을 10%, 20%, 30%로 정하여 출력하세요.
SELECT hiredate
FROM emp;

SELECT to_number(to_char(hiredate, 'MM')) 입사월, MOD(to_number(to_char(hiredate, 'MM')), 3) + 1 구분자,
(MOD(to_number(to_char(hiredate, 'MM')), 3) + 1) * 10 || '%' 보너스비율,
sal, sal * (MOD(to_number(to_char(hiredate, 'MM')), 3) + 1) / 10 보너스금액
FROM emp;

--[1단계:확인] 3. case when 2번째 형식(복합함수)으로 상반기/하반기 입사자로 구분하여 출력하세요.
SELECT ename, hiredate,
CASE floor((to_number(to_char(hiredate, 'MM')) - 1) / 6) WHEN 0 THEN '상반기'
														 WHEN 1 THEN '하반기'
														 ELSE '오류'
														 END "상반기 / 하반기"
FROM emp
ORDER BY "상반기 / 하반기";

--[1단계:개념] 4. 그룹함수의 개념과 기본형식을 기본예제를 통해서 설명하세요.
SELECT deptno, max(sal), round(avg(sal)) -- deptno로 그룹된 sal열에서의 최대값과 평균값을 출력한다.
FROM emp
GROUP BY deptno;

--[1단계:확인] 5. 분기별, 입사 사원수의 수가 2이상인 분기(1~4분기)와, 해당분기의 최고 급여를 출력하세요.
SELECT floor((to_number(to_char(hiredate, 'MM')) - 1) / 3) + 1 입사분기,
count(floor((to_number(to_char(hiredate, 'MM')) - 1) / 3) + 1) "분기별 입사 사원 수",
max(sal) "분기별 최고 급여"
FROM emp
GROUP BY floor((to_number(to_char(hiredate, 'MM')) - 1) / 3) + 1
HAVING count(floor((to_number(to_char(hiredate, 'MM')) - 1) / 3) + 1) >= 2
ORDER BY 입사분기;

--[1단계:확인] 6. 급여를 5000이상부터 시작하여 천단위로 등급을 나누고, 등급별 인원수와 평균 급여를 출력하세요.
SELECT
	CASE floor(sal / 1000)
					WHEN 5 THEN 'A'
					WHEN 4 THEN 'B'
					WHEN 3 THEN 'C'
					WHEN 2 THEN 'D'
					WHEN 1 THEN 'E'
					WHEN 0 THEN 'F'
					ELSE '오류'
					END 급여등급,
count(floor(sal / 1000)) "등급별 인원 수",
floor(avg(sal)) "등급별 평균 급여"
FROM emp
GROUP BY floor(sal / 1000)
ORDER BY 급여등급;

-- 문제풀이
-- 천 단위 등급 처리 case when2
SELECT sal, sal/1000, floor(sal/1000) div,
	CASE floor(sal / 1000)
				WHEN 5 THEN 'A'
				WHEN 4 THEN 'B'
				WHEN 3 THEN 'C'
				WHEN 2 THEN 'D'
				WHEN 1 THEN 'E'
				WHEN 0 THEN 'F'
				ELSE '오류'
				END 급여등급
FROM emp;

SELECT sal, 
		decode(floor(sal/1000),
				5, 'A',
				4, 'B',
				3, 'C',
				2, 'D',
				1, 'E',
				0, 'F',
				'오류') 등급
FROM emp;

SELECT
	CASE floor(sal / 1000)
					WHEN 5 THEN 'A'
					WHEN 4 THEN 'B'
					WHEN 3 THEN 'C'
					WHEN 2 THEN 'D'
					WHEN 1 THEN 'E'
					WHEN 0 THEN 'F'
					ELSE '오류'
					END 급여등급,
count(sal) "등급별 인원 수",
round(avg(sal)) "등급별 평균 급여"
FROM emp
GROUP BY floor(sal / 1000)
ORDER BY 급여등급;
-- floor(sal/1000)를 통해서 0~5까지 그룹별로 처리하기 때문에 위에 case문에 등급을 입력하지 않아도 된다.

--[1단계:개념] 7. 조인이란 무엇인가? 기본 예제를 통하여 기술하세요
-- 조인 : 두 테이블을 결합하는 것
SELECT *
FROM emp
WHERE sal = 5000;

SELECT *
FROM dept
WHERE deptno = 10;

SELECT loc, e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal = 5000;

--[1단계:확인] 8. [조인]연봉이 1000~2000사이의 사원의 부서명을 출력하세요.
SELECT *
FROM emp
WHERE sal >= 1000 AND sal <= 2000;

SELECT *
FROM dept
WHERE deptno = 10 OR deptno = 30;

SELECT ename, sal, dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal >= 1000 AND sal <= 2000;

--[1단계:확인] 9. 부서위치(loc)별 평균 연봉을 출력하세요.
SELECT *
FROM emp;

SELECT *
FROM dept;

SELECT loc, sal
FROM emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY loc;

SELECT loc, avg(sal)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY loc;