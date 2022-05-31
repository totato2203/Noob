--2022-05-30
--[1단계:개념] 1. sequence를 사용하는 이유와 기본형식을 예제를 통해서 기술하세요.
-- 기본키 값을 시퀀스를 통해 편리하게 생성하여 사용하기 위함이다.
CREATE SEQUENCE seq07
	INCREMENT BY 1 -- 시퀀스의 다음 값이 증가하는 양
	START WITH 1 -- 시퀀스의 시작값
	MAXVALUE 10 -- 시퀀스의 최대값
	MINVALUE 0 -- 시퀀스의 최소값(시퀀스가 증가하다가 MAXVALUE를 넘어서면 MINVALUE부터 다시 진행)
	CYCLE -- MAXVALUE를 넘으면 다시 MINVALUE부터 반복
	cache 2;
SELECT seq07.nextval FROM dual;

--[1단계:확인] 2. 회원테이블은 만들고, 회원번호가 'N'(일반), 'S'(수퍼고객), 'A'(관리자)
--      가 붙어서 N1000, S1001, A1002 형식으로 시퀀스와 조합해서 만들어 진다고 한다.
--      회원번호, 회원아이디, 회원명, 회원패스워드로 구성된 테이블과 각각
--      권한에 따를 번호를 입력하세요.
CREATE TABLE emp0001 (
	empno char(5) PRIMARY KEY,
	ID varchar2(50),
	PW varchar2(50)
);
CREATE SEQUENCE seq08
	INCREMENT BY 1
	START WITH 1000
	MAXVALUE 9999
	MINVALUE 1000
	nocycle;
SELECT * FROM emp0001;
INSERT INTO emp0001 VALUES ('N' || seq08.nextval, 'dksusdgktpdy', 'dkssud');
INSERT INTO emp0001 VALUES ('S' || seq08.nextval, 'higuys', 'hello');
INSERT INTO emp0001 VALUES ('A' || seq08.nextval, 'ddff', 'ggaa');

--[1단계:개념] 3. sequence 수정의 한계를 기술하고, 이를 보완하는 방법을 예제를 통해서 기술하세요
-- START WITH로 정한 시퀀스의 시작값은 수정할 수 없다. DROP SEQUENCE를 통해 삭제 후 다시 생성해야 한다.
ALTER SEQUENCE seq08
	INCREMENT BY 1000;
--	START WITH 1500; -- ALTER로 시퀀스 시작값을 수정할 수 없다는 에러 발생
DROP SEQUENCE seq08; -- 삭제
CREATE SEQUENCE seq08 -- 재생성
	INCREMENT BY 1000
	START WITH 1500
	MAXVALUE 9999
	MINVALUE 1499
	CYCLE
	cache 2;
SELECT seq08.nextval FROM dual;

--[1단계:개념] 4. 복사테이블의 유형을 예제를 통해서 기술하세요.
-- 1. 컬럼 구조 + 데이터 복사
CREATE TABLE emp0002 AS SELECT * FROM emp;
-- 2. 컬럼 구조만 복사
CREATE TABLE emp0002 AS SELECT * FROM emp WHERE 1 = 0;
-- 3. 컬럼명 변경
CREATE TABLE emp0002 AS SELECT empno NO, ename name FROM emp;
-- 4. 유형 변경
CREATE TABLE emp0002 AS SELECT to_char(hiredate, 'Q') hiredate FROM emp;

SELECT * FROM emp0002;
DROP TABLE emp0002;


--[1단계:확인] 5. 부서별 최고급여자의 사원정보컬럼전체가 들어가는 복사테이블 emp200을 만드세요.
DROP TABLE emp200;
SELECT * FROM emp200;

CREATE TABLE emp200
AS SELECT * FROM emp
WHERE (deptno, sal) IN (SELECT deptno, max(sal) FROM emp GROUP BY deptno);

--[1단계:개념] 6. 테이블의 구조 변경의 원칙을 예제를 통해서 기술하세요.
CREATE TABLE emp0002 AS SELECT * FROM emp WHERE 1 = 0;
SELECT * FROM emp0002;
ALTER TABLE emp0002
MODIFY ename NUMBER;

DROP TABLE emp0002;
CREATE TABLE emp0002 AS SELECT * FROM emp;
SELECT * FROM emp0002;
ALTER TABLE emp0002
MODIFY ename NUMBER; -- 기존 컬럼에 데이터가 존재해서 타입 변경 불가능
ALTER TABLE emp0002
MODIFY job varchar2(50); -- 기존 컬럼에 데이터가 존재할 때, char와 varchar2(n)만 기존 컬럼 최대값과 같거나 큰 크기로만 변경할 수 있다.

--[1단계:확인] 7. 부서테이블과 사원테이블을 결합한 복사테이블을 만들고, 부서번호 컬럼 삭제
--              문자열 컬럼은  최대크기로 컬럼을 변경하고, 컬럼명도 empno ==> no,
--         ename ==> name, sal ==> salary로 변경 하세요.
CREATE TABLE emp0003
AS SELECT e.*, dname, loc
FROM DEPT d , EMP e 
WHERE d.deptno = e.deptno;

SELECT * FROM emp0003;
ALTER TABLE emp0003
DROP COLUMN deptno;

SELECT max(lengthb(ename)) FROM emp0003; -- 6
SELECT max(lengthb(job)) FROM emp0003; -- 9
SELECT max(lengthb(dname)) FROM emp0003; -- 10
SELECT max(lengthb(loc)) FROM emp0003; -- 8

ALTER TABLE emp0003
MODIFY ename varchar2(6);
ALTER TABLE emp0003
MODIFY job varchar2(9);
ALTER TABLE emp0003
MODIFY dname varchar2(10);
ALTER TABLE emp0003
MODIFY loc varchar2(8);

ALTER TABLE emp0003
RENAME COLUMN empno TO no;
ALTER TABLE emp0003
RENAME COLUMN ename TO name;
ALTER TABLE emp0003
RENAME COLUMN sal TO salary;
