--2022-05-26
--[1단계:확인] 1. inline view을 활용하여 분기별 최저급여자의 사원 정보를 출력하세요.
SELECT to_char(hiredate, 'Q'), min(sal) ms
FROM emp
GROUP BY to_char(hiredate, 'Q');

SELECT DISTINCT e.*
FROM (
	SELECT to_char(hiredate, 'Q'), min(sal) sal
	FROM emp
	GROUP BY to_char(hiredate, 'Q')
	) d, emp e
WHERE d.sal = e.sal;

--[1단계:개념] 2. 삭제 처리 기본 형식과 subquery를 통한 삭제 형식를 예제를 통해서 설명하세요.
CREATE TABLE emp002 AS SELECT * FROM emp;
SELECT * FROM emp002;
-- 삭제 처리 기본 형식
DELETE FROM emp002 WHERE sal <= 1500; -- select를 쓰지 않는다.
-- 삭제 처리 subquery 형식
DELETE FROM emp002
WHERE (job, empno) IN (
	SELECT job, max(empno)
	FROM emp002
	GROUP BY job
	);
SELECT * FROM emp002;

--[1단계:확인] 3. emp02로 복사테이블을 만들고, delete subquery를 이용하여, 상/하반기 최고 급여자를 삭제처리하세요.
CREATE TABLE emp02 AS SELECT * FROM emp;

SELECT ceil(to_char(hiredate, 'Q')/2) 상하반기, max(sal) sal
FROM emp02
GROUP BY ceil(to_char(hiredate, 'Q')/2);

DELETE FROM emp02
WHERE (CEIL(to_char(hiredate, 'Q')/2), sal) IN (
	SELECT ceil(to_char(hiredate, 'Q')/2) 상하반기, max(sal) sal
	FROM emp02
	GROUP BY ceil(to_char(hiredate, 'Q')/2)
);
SELECT * FROM emp02;

--[1단계:개념] 4. merge의 기본 형식을 선언하고, 2가지 기본예제(2개 테이블 비교 수정/등록, 
--            dual을 통한 데이터 비교 수정/등록)를 통하여 설명하세요.
/*
2. 기본 형식
	MERGE INTO 목적테이블명
	USING 비교할 테이블 및 subquery
	ON 두 테이블의 비교 조건
	WHEN MATCHED THEN
		비교조건이 일치할 때, 수정 구문 처리
	WHEN NOT MATCHED THEN
		비교조건이 일치하지 않을 때, 등록 구문 처리
 */
-- 2개 테이블 비교 수정/등록
SELECT * FROM emp;
CREATE TABLE emp003 AS SELECT * FROM emp;
CREATE TABLE emp004 AS SELECT * FROM emp WHERE deptno = 20;
SELECT * FROM emp003;
SELECT * FROM emp004;
MERGE INTO emp003 t
USING emp004 s
ON (t.empno = s.empno)
WHEN MATCHED THEN -- empno가 있으면 ename만 emp004 것으로 바꿈
	UPDATE SET t.ename = s.ename
WHEN NOT MATCHED THEN -- empno가 없으면 모든 열을 emp004 것으로 추가
	INSERT VALUES (s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);

-- dual을 통한 데이터 비교 수정/등록
MERGE INTO emp003 t
USING (SELECT 8001 empno, '홍길동' ename, '사원' job, 7902 mgr, sysdate hiredate, 2000 sal, 100 comm, 10 deptno
		FROM dual) s
ON (t.empno = s.empno)
WHEN MATCHED THEN	
		UPDATE SET 	t.ename = s.ename,
					t.job = s.job,
					t.mgr = s.mgr,
					t.hiredate = s.hiredate,
					t.sal = s.sal,
					t.comm = s.comm,
					t.deptno = s.deptno
WHEN NOT MATCHED THEN
	INSERT VALUES (s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);
SELECT * FROM emp003; -- dual 테이블의 empno가 7369일 땐 수정, 8001일 땐 등록
	

--[1단계:확인] 5. 물건테이블과 회원테이블을 만들어 기본 데이터 5개를 입력하되, merge를 이용하여
--            등록/수정처리해보세요.
CREATE TABLE stf01 (물건번호 char(8), 물건이름 varchar2(50), 가격 NUMBER);
CREATE TABLE member01 (회원번호 char(8), ID varchar2(50), PW varchar2(50), 회원이름 varchar2(50));
INSERT INTO stf01 VALUES('111-2222', '책상', 100000);
INSERT INTO stf01 VALUES('111-2223', '의자', 50000);
INSERT INTO stf01 VALUES('111-2224', '옷장', 150000);
INSERT INTO stf01 VALUES('111-2226', '옷걸이', 30000);
INSERT INTO stf01 VALUES('111-2227', '식탁', 120000);
INSERT INTO member01 VALUES('100-1000', 'rlacjftn', '1234', '김철수');
INSERT INTO member01 VALUES('100-1001', 'angel777', 'angel', '나천사');
INSERT INTO member01 VALUES('100-1002', 'cuty1022', '1022', '홍귀척');
INSERT INTO member01 VALUES('100-1003', 'happy0207', 'hhaappyy', '최행복');
INSERT INTO member01 VALUES('100-1004', '1q2w3e4r', '1q2w3e4r', '이당직');
SELECT * FROM stf01;
SELECT * FROM member01;

MERGE INTO member01 o
USING (SELECT '100-1000' 회원번호, 'newmember' ID, 'newface' PW, '박신삥' 회원이름
		FROM dual) n
ON (o.회원번호 = n.회원번호)
WHEN MATCHED THEN
	UPDATE SET 	o.ID = n.ID,
				o.PW = n.PW,
				o.회원이름 = n.회원이름
WHEN NOT MATCHED THEN
	INSERT VALUES (n.회원번호, n.ID, n.PW, n.회원이름);
SELECT * FROM member01;
--[1단계:개념] 6. 문자열, 숫자형, 날짜형 데이터 유형을 기능별로 설명하세요
/*
	문자열 : 	char(size) - (size 크기의 고정된 길이 문자 데이터 타입),
			nchar(size),
			varchar2(size) - (size 크기의 가변 길이 문자 데이터 타입),
			nvarchar2(size) - (국가별 문자 집합에 따른 size 크기의 문자 또는 바이트 가변 길이 문자 데이터 타입)
	숫자형 : 	number(p,s) - 정밀도(p)와 스케일(s)로 표현되는 숫자 데이터 타입
	날짜형 : 	date - 날짜 형식 저장하는 데이터 타입
 */

--[2단계:확인] 7. 어떤 회원이 구매한 물건 정보를 담는 구매테이블을 만들려고 한다. 
--        구매테이블은 어떤 컬럼이 필요할지 기술해보고, 실제 저장한 데이터를 입력해보자.
CREATE TABLE buyStf (물건번호 char(9), 구매한회원번호 char(9), 물건명 varchar2(50), 가격 NUMBER, 개수 NUMBER);
INSERT INTO buyStf VALUES ('1002-3500', '7001-6652', '사과', 2500, 4);
INSERT INTO buyStf VALUES ('1002-3502', '7001-6679', '바나나', 3000, 2);
INSERT INTO buyStf VALUES ('1002-3505', '7001-6652', '귤', 500, 5);
SELECT * FROM buyStf;




