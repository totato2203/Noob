 SELECT * FROM emp;
 /*
# 중복제어 DISTINCT
1. 특정한 데이터를 출력하는 것은 연관관계 없이 칼럼으로 출력된다.
2. 특정 칼럼의 데이터 중에 중복된 것을 제외시키고 출력할 때에는 DISTINCT 컬럼명 형식으로 처리한다.
3. 2개 이상의 컬럼에서도 중복된 데이터를 제외시킬 수 있다.
	해당 컬럼을 체크해도 동일할 때에는 제외를 한다.
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