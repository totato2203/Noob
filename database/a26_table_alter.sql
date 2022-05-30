/*
# 테이블 생성 시 기타 옵션
1. default 옵션
	1) 컬럼의 입력값이 생략될 경우(묵시적)에 null 대신 입력될 기본값을 지정하는 기능
	2) 기본값 : 리터럴 값, 표현식, sql 함수, sysdate, user를 사용
	3) 컬럼이나 의사컬럼(nextval, currval)은 사용할 수 없음
	# 기본형식
	컬럼명 varchar2(100) default 'KOREA'
 */
CREATE TABLE emp102(
	NO NUMBER PRIMARY KEY,
	addr varchar2(50) DEFAULT '대한민국'
);
-- 명시적으로 null을 입력하면 처리하지 않고, 묵시적으로 null이 입력될 때만 처리
INSERT INTO emp102(NO) VALUES (seq01.nextval);
SELECT * FROM emp102;
/*
# subquery를 통해 테이블 생성
1. 컬럼 구조 + 데이터 복사
	CREATE TABLE 테이블명
	AS SELECT * FROM 테이블명;
2. 컬럼 구조만 복사
	CREATE TABLE 테이블명
	AS SELECT * FROM 테이블명 WHERE 1=0;
3. 컬럼명 변경
	CREATE TABLE 테이블명
	AS SELECT 컬럼1 변경명1, 컬럼2 변경명2
	FROM 테이블명
4. 유형 변경
	CREATE TABLE 테이블명
	AS SELECT 함수명(컬럼명) FROM 테이블명
 */
CREATE TABLE emp110
AS SELECT * FROM emp;
SELECT * FROM emp110; -- NOT NULL만 복사, 그 외의 무결성 제약조건은 복사 안 됨

CREATE TABLE emp111
AS SELECT * FROM emp WHERE 1 = 0;
-- WHERE 1 = 0 조건이 false이기에 데이터가 나오지 않지만
-- 구조는 나오기 때문에 그 구조가 복사된다.
SELECT * FROM emp111;

CREATE TABLE emp112
AS SELECT empno NO, ename name, sal salary
FROM emp;
SELECT * FROM emp112;

CREATE TABLE emp113
AS SELECT empno NO, to_char(hiredate, 'YYYY/MM/DD') hiredate,
	decode(deptno, 10, '인사', 20, '재무', 30, '회계', 'it사업부') dname
FROM emp;
SELECT * FROM emp113;
-- ex) emp114 복사 테이블을 만들되, 다음과 같이 처리하세요.
--		empno ==> no, ename ==> name, hiredate ==> hiqua(입사분기)
CREATE TABLE emp114
AS SELECT empno NO, ename name, to_char(hiredate, 'Q') hiqua,
	to_char(hiredate, 'YYYY-MM-DD') hiredate2
FROM emp;
SELECT * FROM emp114;
/*
# 테이블 고주 변경
1. 개요
	1) alter table 명령문 이용
	2) 컬럼 추가, 삭제, 타입이나 길이의 재정의 같은 작업
2. 컬럼 추가
	1) ALTER TABLE ADD 명령문 사용
	2) 추가된 컬럼은 테이블의 마지막 부분에 생성, 위치 지정 불가능
	3) 추가된 컬럼에도 기본 값을 지정 가능
	4) 수정할 테이블에 기존 데이터가 존재하면 컬럼 값은 null로 입력
	5) 기본 형식
		ALTER TABLE 테이블명
		ADD 컬럼명 데이터유형 default 디폴트설정데이터
3. 컬럼 삭제
	1) ALTER TABLE 테이블명 DROP COLUMN 컬럼명
 */
SELECT * FROM emp100;
ALTER TABLE emp100
ADD (empno number);
ALTER TABLE emp100
ADD (job varchar2(50) DEFAULT '직책없음');
ALTER TABLE emp100
ADD (hiredate DATE, sal NUMBER, comm NUMBER);
ALTER TABLE emp100 DROP COLUMN comm;
SELECT * FROM emp100;
-- ex) emp110 테이블에 부서정보(부서명, 부서위치) 추가, deptno 컬럼 삭제 처리
ALTER TABLE emp110
ADD (dname varchar2(50), loc varchar2(50));
ALTER TABLE emp110
DROP COLUMN deptno;
SELECT * FROM emp110;


