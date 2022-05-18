--2022-05-18
--[1단계:개념] 4. select 컬럼과 where 조건의 차이점를 예제로 기술하세요.
SELECT ename -- SELECT는 열 단위 컬럼을 선택한다.
FROM emp
WHERE job IS NULL; -- WHERE은 행 단위로 필터링을 한다.

--[1단계:활용] 5. 사원정보에서 급여가 2000~5000인 사원번호, 사원명, 급여를 출력하세요.
SELECT empno, ename, sal
FROM emp
WHERE sal BETWEEN 2000 AND 5000;

--[1단계:활용] 6. 직책이 CLERK와 MANAGER를 검색하여 이에 해당 하는 사원 정보를 출력하세요.
SELECT *
FROM emp
WHERE job = 'CLERK' OR job = 'MANAGER';
--WHERE job IN ('CLERK', 'MANAGER'); 도 가능

--[1단계:활용] 7. [SUBQUERY in] 사원번호 7566, 7782가 소속된 부서번호에 해당하는 사원정보를 출력하세요.
SELECT *
FROM emp
WHERE deptno IN (
	SELECT deptno
	FROM emp
	WHERE empno IN (7566, 7782)
);

--[1단계:개념] 8. 키워드 검색의 종류를 예제와 함께 나열해보세요.
SELECT ename
FROM emp
WHERE job LIKE '%A%'; -- A가 들어가는 직업을 가진
--WHERE job LIKE 'A%'; -- A로 시작하는 직업을 가진
--WHERE job LIKE '%A'; -- A로 끝나는 직업을 가진
--WHERE job LIKE '_A'; -- A가 두 번째 글자에 들어가는 직업을 가진
--WHERE job LIKE 'A_'; -- A가 끝에서 두 번째 글자에 들어가는 직업을 가진
--WHERE job LIKE '__A__'; -- 총 다섯 글자이고 A가 세 번째 글자에 들어가는 직업을 가진

--[1단계:활용] 9. 1981에 입사한 사원들의 직책을 기준으로 사원정보를 출력하세요..
SELECT *
FROM emp
WHERE job in(
	SELECT job
	FROM emp
	WHERE hiredate LIKE '81%'
);
SELECT to_char(hiredate), e.*
FROM emp e
WHERE hiredate LIKE '81%'; -- 날짜열 확인

--[1단계:활용] 10. like 키워드로 1/4분기에 입사한 사원들의 부서정보와 동일한 사원들을 출력하세요.
SELECT ename
FROM emp
WHERE deptno in(
	SELECT deptno
	FROM emp
	WHERE hiredate LIKE '___01%'
	OR hiredate LIKE '___02%'
	OR hiredate LIKE '___03%'
);

--[1단계:개념] 11. 집합연산자의 종류를 예제를 통해서 기술하세요.
--4. 집합 연산자 종류
--	1) UNION : 두 집합에 대해 중복되는 행을 제외한 합집합
--	2) UNION ALL : 두 집합에 대해 중복되는 행을 포함한 합집합
--	3) MINUS : 두 집합 간의 차집합
--	4) INTERSECT : 두 집합 간의 교집합
CREATE TABLE emp_cp10
AS SELECT * FROM emp
WHERE deptno = 10; -- deptno = 10인 데이터들을 복사해서 만든 테이블

-- UNION : 두 집합의 중복되는 행을 제외한 합집합
SELECT empno, ename FROM emp
UNION
SELECT empno, ename FROM emp_cp10;

-- UNION ALL : 두 집합의 중복되는 행을 포함한 합집합
SELECT empno, ename FROM emp
UNION ALL
SELECT empno, ename FROM emp_cp10;

-- 두 집합 간의 차집합
SELECT empno, ename FROM emp
MINUS
SELECT empno, ename FROM emp_cp10;

-- 두 집합 간의 교집합
SELECT empno, ename FROM emp
INTERSECT
SELECT empno, ename FROM emp_cp10;

