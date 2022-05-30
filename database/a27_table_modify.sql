/*
# 테이블의 컬럼 변경
1. 기능 
	1) 테이블에서 컬럼의 타입, 크기, 기본값 변경 가능
	2) 기본 형식
		ALTER TABLE 테이블명 MODIFY
		컬럼명 데이터유형 default 데이터
	3) 기존컬럼에 데이터가 없는 경우
		컬럼의 타입이나 크기 변경이 자유로움
	4) 기존컬럼에 데이터가 존재하는 경우
		- 타입 변경은 char와 varchar2만 허용
			다른 유형까지 변경 문자열 ==> 숫자, 숫자 ==> 문자,
				날짜형 ==> 문자열은 불가능하다.
		- 문자열일 경우, 변경한 컬럼의 크기가 저장된 데이터의 크기보다 같거나 클 경우 변경 가능
			실제로 저장된 데이터 기준
			varchar2(최대크기) : 저장할 수 있는 최대 크기를 지정하는 것이기에
				varchar2(50) ==> varchar2(10)으로도 변경이 가능한데,
				해당하는 컬럼에 저장된 데이터의 최고 크기가 10byte 이하일 때 가능하다.
		- 숫자 타입에서는 정밀도 증가 가능
	5) 기본값의 변경은 변경 후에 입력되는 데이터부터 적용
 */
-- 데이터가 없는 경우
SELECT * FROM emp110;
-- 1) 다른 유형으로 변경 가능
ALTER TABLE emp110
MODIFY loc NUMBER;
UPDATE emp110
	SET dname = '부서(초기)';
-- 데이터가 있는 경우
-- ALTER TABLE emp110
-- MODIFY loc number; (X)
-- 1) 	숫자형 ==> 문자열 변경 안 됨
--		문자형 ==> 숫자형 변경 안 됨
--		ps) 숫자 <==> 문자 <==> 날짜 상호 간에 변경 불가능
ALTER TABLE emp110
MODIFY loc varchar2(10);
-- 1) 숫자형 ==> 문자열 변경 안 됨
ALTER TABLE emp110
MODIFY dname varchar2(60);
-- 2) 문자열 ==> 문자열 : 데이터 유형을 더 크게 변경하는 것은 가능
SELECT * FROM emp110;
SELECT max(LENGTHB(dname)) -- dname 컬럼 내 최대 byte 수 확인 : 14
FROM emp110;
ALTER TABLE emp110
MODIFY dname varchar2(14); -- varchar2(1~13)은 안 됨
-- 3) 문자열 ==> 문자열 : 작게도 변경이 가능한데,
--		저장된 문자열의 최대 byte 크기까지만 가능하다.

SELECT * FROM emp02;
-- ex) emp02의 문자열형 데이터를 확인하고, 저장된 최대크기로 데이터유형을 변경하세요.
SELECT * FROM emp02;
SELECT 	max(lengthb(ename)),
		max(lengthb(job))
FROM emp02;
-- 저장된 데이터의 최대 byte수로 변경 처리
ALTER TABLE emp02
MODIFY (ename varchar(6), job varchar2(8));
/*
# 컬럼명 변경
1. 기본 형식
	ALTER TABLE 테이블명 RENAME COLUMN 원컬럼명 TO 변경할컬럼명
 */
SELECT * FROM emp02;
ALTER TABLE emp02
RENAME COLUMN empno TO NO;
/*
# 테이블 이름 변경
1. 기본 형식
	RENAME 명령문 사용
	ex) RENAME 이전객체명 TO 새로운객체명
	1) 객체의 이름을 변경하는 DDL 명령문
	2) 뷰, 시퀀스, 동의어 등과 같은 데이터베이스 객체의 이름을
		변경할 때도 동일하게 사용 가능
 */
RENAME emp02 TO emp00002;
SELECT * FROM emp00002;
/*
# 테이블 삭제
1. 기본 형식
	DROP TABLE 테이블명;
2. 제한 사항
	1) 삭제된 테이블과 관련된 뷰와 동의어는 invalid 상태
	2) 삭제된 테이블의 기본 키나 고유키를 다른 테이블에서 참조하는 경우 삭제 불가능
		- 참조하는 테이블(자식 테이블)을 먼저 삭제
		- DROP TABLE 명령문 마지막에 cacade constraints 옵션을
			사용하여 무결성 제약조건을 동시에 삭제
 */
DROP TABLE emp00002;
-- ex) emp8888로 복사테이블을 만들어, 컬럼명을 바꾸고 컬럼명을 삭제,
--		테이블명 emp9999로 바꾸고, 테이블을 삭제 처리하세요.
CREATE TABLE emp8888 AS SELECT * FROM emp;
SELECT * FROM emp8888;

ALTER TABLE emp8888
RENAME COLUMN empno TO nonono;

ALTER TABLE emp8888
DROP COLUMN nonono;

RENAME emp8888 TO emp9999;
DROP TABLE emp9999;


