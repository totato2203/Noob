--2022-05-24
--[1단계:개념] 1. natural join의 기능을 기술하고, 일반 equi 조인과의 차이점을 기술하세요.
/*
natural join은 조인 대상 테이블 간의 공통 컬럼을 '=' 비교를 통해 같은 값을 가지는 행과 연결하여 결과를 생성하는 조인 방법이다.
오라클 자체적으로 테이블의 모든 컬럼을 대상으로 공통 컬럼을 조사한 후 내부적으로 조인문을 생성한다.
일반 equi join과 달리 WHERE 절을 사용하지 않는다.
*/

--[1단계:개념] 2. not equi join이란 무엇인가 기본예제를 통해서 설명하세요.
-- '=' 조건과 같이 완전히 동일하지는 않고 범위를 지정하여 조인하는 것을 말한다.
SELECT ename, job, sal, grade
FROM EMP e , SALGRADE s
WHERE sal BETWEEN losal AND hisal;

--[1단계:확인] 3. 사원번호를 기준으로 4개의 임의 범위를 정하여 복사테이블을 만들어 저장하고(salgrade를 복사한 복사테이블(part)),
--            사원번호를 통한 출장소 지정 1분위 : 서울 2분위 : 부산 3분위 : 제주  4분위 : LA 처리하여 테이블의 데이터를 수정하고, 
--            no equi join 처리하세요.
--            grade hisal rsal ==> loc hiempno rempno
--                                 서울 7001     7500
--                                 부산 7501     7600
--                                 ..
SELECT deptno FROM emp;

SELECT * FROM salgrade;

CREATE TABLE part
AS SELECT '' || grade loc, losal loempno, hisal hiempno
FROM salgrade;
-- ''||grade loc : 숫자형을 문자열로 바꾸고 이름을 loc 변환처리

SELECT * FROM part;

SELECT 	min(empno) 최소,
		round(min(empno) + round(median(empno))) / 2 "1분위",
		round(median(empno)) 중앙,
		round(round(median(empno)) + max(empno)) / 2 "3분위",
		max(empno) 최대
FROM emp;
-- 7369 ~ 7555 서울
-- 7556 ~ 7740 부산
-- 7741 ~ 7837 제주
-- 7838 ~ 7934 LA
SELECT ename, empno, loc
FROM emp e, part p
WHERE empno BETWEEN loempno AND hiempno;

-- 나의 답
SELECT ename, empno, loc
FROM EMP e , PART p 
WHERE empno BETWEEN loempno AND hiempno;

--[1단계:개념] 4. outer join이란 무엇인가? 기본예제를 통하여 개념을 설명하세요.
/*
1) equi join의 조인 조건에서 양측 컬럼 값 중 어느 하나라도 null이면
		'=' 비교 결과가 거짓이 되어 null값을 가진 행은 조인 결과로 출력이 안 된다.
		null에 대하여 어떠한 연산을 적용하더라도 연산 결과는 null.
 */
-- equi join의 조인 조건에서 양측 컬럼 값 중에 어느 하나라도 null값이 존재하면
-- '=' 비교 결과가 거짓이 되어 null값이 포함된 행은 조인 결과에 출력이 안 된다.
-- 이러한 경우처럼 어느 한 컬럼에 null값이 포함되어 있어도 조인 결과를 출력하기 위해 사용하는 방법이다.
SELECT * FROM emp;
SELECT * FROM dept;
SELECT dname, job
FROM EMP e , DEPT d
--WHERE e.deptno = d.deptno; -- dname OPERATOR의 JOB은 null이라 출력되지 않는다.
WHERE e.deptno(+) = d.deptno; -- OUTER JOIN으로 null값이 포함되어 있어도 출력할 수 있다.

--[1단계:확인] 5. emp_cp100에 부서정보를 할당하지 않고, 신규 사원정보를 추가한 후, emp_cp100기준으로 부서정보와
--            outer조인된 데이터를 출력하세요.
SELECT * FROM emp_cp100;
SELECT * FROM dept;
SELECT *
FROM EMP_CP100 ec, DEPT d 
WHERE ec.deptno = d.deptno(+); -- OUTER JOIN 하지 않으면 오길동과 마길동의 부서정보가 출력되지 않는다.

--[1단계:개념] 6. self join에 대하여 기본예제로 기술하세요.
-- 하나의 테이블 안에 있는 컬럼끼리 연결하는 조인을 말한다.
-- 조인하는 대상 테이블이 자기 자신 하나라는 것을 제외하면 equi join과 동일하다.
SELECT * FROM emp_family;
SELECT m.name || '(' || m.role01 || ')의 자손' || e.name || '(' || e.role01 || ')' show
FROM emp_family m, emp_family e
WHERE m.NO = e.refno; -- 테이블 하나 안의 컬럼끼리 조인

--[1단계:개념] 7. subquery란 무엇인가 기본예제와 함께 개념을 설명하세요.
-- 하나의 sql 명령문의 결과를 다른 sql의 명령문에 전달하기 위해 두 개 이상의 sql 명령문을 하나의 sql 명령문으로 연결하여 처리하는 방법이다.
SELECT *
FROM emp
WHERE sal = (
	SELECT min(sal) FROM emp -- emp 속 sal의 최소값을 연결하는 subquery
);

--[1단계:확인] 8. 관리자가 'MANAGER'인 사원의 최저 급여보다 적은 사원들 출력하세요.
-- 1) 직책이 MANAGER인 사람의 사원번호
SELECT empno
FROM emp
WHERE job = 'MANAGER';
-- 2) 위 MANAGER가 관리자인 사원의 mgr
SELECT empno, ename, mgr
FROM emp
WHERE mgr IN (
	SELECT empno
	FROM emp
	WHERE job = 'MANAGER'
	);
-- 3) 최저 급여
SELECT min(sal)
FROM emp
WHERE mgr IN (
	SELECT empno
	FROM emp
	WHERE job = 'MANAGER'
	);
-- 4) 위 금액의 이하인 사원
SELECT *
FROM emp
WHERE sal < (
	SELECT min(sal)
	FROM emp
	WHERE mgr IN (
		SELECT empno
		FROM emp
		WHERE job = 'MANAGER'
	)
);

-- 나의 답
SELECT min(sal)
FROM emp
WHERE job = 'MANAGER';

SELECT ename, job, sal
FROM emp;

SELECT ename, sal
FROM emp
WHERE sal < (
	SELECT min(sal)
	FROM emp
	WHERE job = 'MANAGER'
);

--[1단계:확인] 9. emp, salgrade테이블과 조인하여, 등급이 1~2등급인 사원의 최고 급여보다 많은 사원을 출력하세요.
SELECT s.*, e.*
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal

SELECT *
FROM emp
WHERE sal > (
	SELECT max(sal)
	FROM emp e, salgrade s
	WHERE sal BETWEEN losal AND hisal
	AND grade IN ('1', '2')
) -- 1300보다 많은 사원
ORDER BY sal;

-- 나의 답
SELECT * FROM emp;
SELECT * FROM salgrade;
SELECT * FROM EMP e NATURAL JOIN SALGRADE s;

SELECT s.grade
FROM EMP e NATURAL JOIN SALGRADE s 
WHERE e.sal > s.losal AND e.sal < s.hisal
-- 포기, 질문






