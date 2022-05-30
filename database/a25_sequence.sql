/*
# 시퀀스
1. 개요
	1) 유일한 식별자
	2) 기본 키 값을 자동으로 생성하기 위하여 일련번호를 생성하는 객체
	ex) 웹 게시판에서 글이 등록되는 순서대로 번호를 하나씩 할당하여
		기본키로 지정하고자 할 때 시퀀스를 이용하면 편리
	3) 여러 테이블에서 공유 가능
2. 기본 형식
	CREATE SEQUENCE 시퀀스명
	INCREMENT BY n
	START WITH n
	MAXVALUE n | NOMAXVALUE
	MINVALUE n | NOMINVALUE
	CYCLE | NOCYCLE
	CACHE n | NOCACHE
	1) INCREMENT BY n : 시퀀스 번호의 증가치, 기본값은 1
	2) START WITH n : 시퀀스 시작번호, 기본값은 1
	3) MAXVALUE n : 생성 가능한 시퀀스의 최대값
	4) MINVALUE n : 시퀀스 번호를 순환적으로 사용하는 CYCLE로 지정한 경우,
		MAXVALUE에 도달한 후 새로 시작하는 시퀀스값
	5) CYCLE | NOCYCLE : MAXVALUE 또는 MINVALUE에 도달한 후
		시퀀스의 순환적인 시퀀스 번호의 생성 여부 지정
	6) CACHE | NOCACHE : 시퀀스 생성 속도 개선을 위해
		메모리에 캐쉬하는 시퀀스 개수, 기본값은 20
 */
CREATE SEQUENCE seq01
	INCREMENT BY 1
	START WITH 1
	MAXVALUE 10
	MINVALUE 1
	CYCLE
	cache 2;
SELECT seq01.nextval FROM dual;
-- ex1) 시퀀스를 시작번호 1000, 증가단위 1, 최대값 9999, 최소값 1000으로 설정하여 확인하세요.
CREATE SEQUENCE seq02
	INCREMENT BY 1
	START WITH 1000
	MAXVALUE 9999
	MINVALUE 1000;
SELECT seq02.nextval FROM dual;
-- ex2) 시퀀스를 시작번호 8888, 증가단위 -2, 최대값 8888, 최소값 8880, 반복 수행 처리로 설정하여 확인하세요.
CREATE SEQUENCE seq03
	INCREMENT BY -2
	START WITH 8888
	MAXVALUE 8888
	MINVALUE 8880
	CYCLE
	cache 2;
SELECT seq03.nextval FROM dual;
/*
# 사용예
1. 테이블을 생성한다.
2. KEY가 필요한 경우 sequence를 생성한다.
3. 문자형 또는 숫자형으로 해당 key에 맞게 입력 처리한다.
 */
CREATE TABLE student10(
	NO NUMBER PRIMARY KEY,
	kor NUMBER
);
CREATE SEQUENCE seq04
	INCREMENT BY 1
	START WITH 1000
	MINVALUE 1000
	MAXVALUE 9999;
INSERT INTO student10 values(seq04.nextval, 80);
SELECT * FROM student10;
-- ex) 사원테이블(employee100 - 사원번호, 사원명, 부서명)을 만들고,
--		사원번호가 5000부터 시작하여 9999까지 입력 가능하게 sequence를 만들고 입력처리하세요.
CREATE TABLE employee100(
	empno NUMBER PRIMARY KEY,
	ename varchar2(50),
	dname varchar2(50)
);
CREATE SEQUENCE seq05
	INCREMENT BY 1
	START WITH 5000
	MAXVALUE 9999;
INSERT INTO employee100 values(seq05.nextval , '안영미', '사업부');
SELECT * FROM employee100;

CREATE TABLE employee101(
	empno char(6) PRIMARY KEY,
	ename varchar2(50),
	dname varchar2(50)
);
-- empno를 문자와 조합하여 6자리로 만들 때, 문자 + sequence와 조합하여
-- PRIMARY KEY를 만들어서 사용할 수 있다.
INSERT INTO employee101 VALUES ('AK' || seq05.nextval, '고길동', '재무팀');
SELECT * FROM employee101;
/*
# 시퀀스의 함수
1. currval : 시퀀스에서 생선된 현재 번호를 확인
	현재 번호를 가져온다.
	ex) 데이터를 두 개 테이블에 입력 시, 부서정보를 등록하고,
	이 등록된 부서정보의 deptno를 바로 사원정보로 등록할 때 활용될 수 있다.
2. nextval : 시퀀스에서 다음 번호 생성
	증가 처리가 됨
 */
SELECT seq05.nextval, seq05.currval FROM dual;
CREATE TABLE dept100(
	deptno NUMBER PRIMARY KEY,
	dname varchar2(50),
	loc varchar2(50)
);
CREATE TABLE emp100(
	ename varchar2(50),
	deptno NUMBER
);
INSERT INTO dept100 VALUES (seq05.nextval, '인사', '서울강남');
INSERT INTO emp100 VALUES ('홍길동', seq05.currval);
SELECT * FROM dept100;
SELECT * FROM emp100;
/*
# 시퀀스 정의 변경
1. 변경
	1) 시퀀스 생성 후 증가치, 최소값, 최대값 등의 정의를 수정
	2) 변경된 시퀀스 정의는 새로 생성되는 시퀀스 값부터 적용
	3) ALTER SEQUENCE 명령문을 사용하여 변경
	4) START WITH 절은 생성 직후의 시작값을 의미, 변경 불가
		==> 시작값을 변경하기 위해서는
		DROP SEQUENCE 시퀀스명; (삭제명령어)
		후 다시 생성 처리
		
2. 사용법
	ALTER SEQUENCE 시퀀스명
	INCREMENT BY n
	MAXVALUE n | NOMAXVALUE
	MINVALUE n | NOMINVALUE
	CYCLE | NOCYCLE
	CACHE n | NOCACHE
# 시퀀스의 삭제
DROP SEQUENCE 시퀀스명;
 */
SELECT seq05.nextval, seq05.currval FROM dual;
ALTER SEQUENCE seq05
	INCREMENT BY 2
	MINVALUE 4000;
DROP SEQUENCE seq05;
CREATE SEQUENCE seq05
	START WITH 4000
	INCREMENT BY 1
	MINVALUE 3000;
-- ex) seq06을 생성, 수정, 삭제 처리하고 다시 생성하세요.
--		생성1		시작번호 1000, 최대값 9999, 최소값 1000
--		수정		최대값 5555, 최소값 800
--		생성2		시작번호 500, 최대값 8888, 최소값 500
CREATE SEQUENCE seq06
	START WITH 1000
	MAXVALUE 9999
	MINVALUE 1000;
ALTER SEQUENCE seq06
	MAXVALUE 5555
	MINVALUE 800;
DROP SEQUENCE seq06;
CREATE SEQUENCE seq06
	START WITH 500
	MAXVALUE 8888
	MINVALUE 500;

