/*
# 집합 연산자
1. 테이블을 구성하는 행집합에 대해 테이블의 부분 집합을 결과로 변환하는 연산자
2. 집합 연산의 대상이 되는 두 테이블의 컬럼 수가 같고,
	대응되는 컬럼까지 데이터 타입이 동일할 때 활용된다.
3. 기본 형식
	SELECT 명령문1
	UNION, UNION ALL, INTERSECT, MINUS
	SELECT 명령문2
4. 집합 연산자 종류
	1) UNION : 두 집합에 대해 중복되는 행을 제외한 합집합
	2) UNION ALL : 두 집합에 대해 중복되는 행을 포함한 합집합
	3) MINUS : 두 집합 간의 차집합
	4) INTERSECT : 두 집합 간의 교집합
*/
/*
cf) 복사테이블 만들기
	CREAT table 만들테이블명
	as 기존 테이블의 sql
*/
CREATE TABLE emp_cp100
AS SELECT * FROM emp
WHERE deptno = 10;

SELECT * FROM emp_cp100;

INSERT INTO emp_cp100 values(7999, '홍길동', '사원', 7839, sysdate, 3000, NULL, 40);
-- 중복데이터를 제거한 데이터 : UNION
SELECT empno, ename FROM emp
UNION
SELECT empno, ename FROM emp_cp100;
-- 중복데이터를 포함한 데이터 : UNION ALL
SELECT  empno, ename FROM emp
UNION ALL
SELECT empno, ename FROM emp_cp100;
-- 차집합 처리 : MINUS
SELECT  empno, ename, deptno FROM emp
MINUS
SELECT empno, ename, deptno FROM emp_cp100;
-- 교집합 처리 : INTERSECT
SELECT empno, ename, deptno FROM emp
INTERSECT
SELECT empno, ename, deptno FROM emp_cp100;




