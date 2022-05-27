/*
# 데이터 무결성 제약조건
1. 개념
	1) 데이터의 정확성과 일관성을 보장
	2) 데이터의 정확성을 유지하여 다양한 종류의 업무규칙 고려한 예
		- student 테이블에서 학년 데이터는 1, 2, 3, 4 중에 하나의 값만 입력
		- 모든 학번은 유일
		- student 테이블의 지도교수 번호는 professor 테이블의 교수 번호 중에 하나와 반드시 일치
2. 장점
	1) 테이블 생성 시 무결성 제약조건을 정의 가능
	2) 테이블에 대한 정의, 데이터 딕셔너리에 저장되므로
		응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
	3) 제약조건을 활성화/비활성화 할 수 있는 융통성
3. 무결성 제약조건의 종류
	# 제약조건의 이름을 붙일 때는 constraint 제약명
		컬럼명 데이터유형 [CONSTRAINT 제약명] 제약조건keyword
		ex) studno number CONSTRAINT student_no_pk PRIMARY KEY
	1) not null : 열이 null을 포함할 수 없음
	2) 고유키(unique key) : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을 지정
	3) 기본키(primary key) : 해당 컬럼 값은 반드시 존재해야 하며 유일해야 함
		-- unique not null 제약조건을 결합한 형태
	4) 참조키(foreign key) : 한 열과 참조된 테이블의 열 간에 외래 키 관계를 설정하고 시행
	5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건 지정
		기본 형식
		컬럼명 데이터유형 constraint 제약명 check(컬럼명 in (데이터1, 데이터2))
		cf) check(조건문의 구문)
 */
-- 1. 기본키 생성 예제 : 동일한 데이터 입력 불가, null 불가
CREATE TABLE student01(
	studno char(5) PRIMARY KEY
);
SELECT * FROM student01;
INSERT INTO student01 values('10000');
INSERT INTO student01 values('10001');
INSERT INTO student01 values('10001'); -- 유일하지 못한 데이터는 입력 불가능 (이미 '10001'이 있음)
INSERT INTO student01 values(NULL); -- NULL값도 입력 불가능
-- ex) student02 학생번호, 이름을 설정하고, 학생번호는 primary key로 설정하여 이름과 함께 데이터를 삽입하세요.
CREATE TABLE student02(
	studno char(5) PRIMARY KEY, name varchar2(50)
);
INSERT INTO student02 VALUES ('10005', '최춘식');
INSERT INTO student02 VALUES ('10005', '최춘식'); -- studno가 고유하지 않아서 불가능
INSERT INTO student02 VALUES ('10006', '최춘식'); -- studno가 고유해서 가능
INSERT INTO student02 VALUES ('10007', NULL); -- studno가 고유해서 name이 NULL이어도 가능
SELECT * FROM student02;
-- not null : 동일한 데이터의 입력은 가능하나 반드시 데이터를 입력 처리해야 한다.
CREATE TABLE student03(
	studno NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL	-- 이름을 NOT NULL로 설정
);
SELECT * FROM student03;
INSERT INTO student03 values(1000, '홍길동');
INSERT INTO student03 values(1001, '김길동');
INSERT INTO student03 values(1002, '홍길동');
INSERT INTO student03 values(1003, NULL); -- 위 셋은 다 가능하지만 이건 NOT NULL 자리에 NULL이 들어가서 불가능
-- ex) student04 테이블에 이름과 국어 점수를 절정하되, 이름과 점수를 not null로 설정하고 데이터 입력을 확인하세요.
CREATE TABLE student04 (
	name varchar2(50) NOT NULL, kor NUMBER NOT NULL
);
INSERT INTO student04 VALUES ('김철수', 100); -- 가능
INSERT INTO student04 VALUES ('김철수', 80); -- 가능
INSERT INTO student04 VALUES ('박철수', 100); -- 가능
INSERT INTO student04 VALUES (NULL, 100); -- 불가능
INSERT INTO student04 VALUES ('최철수', NULL); -- 불가능
SELECT * FROM student04;
-- unique : 중복데이터 입력 불가 처리, 단 NULL은 중복 가능하다.
CREATE TABLE student05(
	NO NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	civilnumber char(14) unique
);
INSERT INTO student05 VALUES (1000, '홍길동', '921212-2801727');
INSERT INTO student05 VALUES (1001, '김길동', '931212-2801727');
INSERT INTO student05 VALUES (1002, '신길동', '921212-2801727'); -- civilnumber 중복이라 불가능
INSERT INTO student05 VALUES (1003, '오길동', NULL);
INSERT INTO student05 VALUES (1004, '허길동', NULL);
INSERT INTO student05 VALUES (1005, '신길동', NULL);
SELECT * FROM student05;
/*
	기본 형식
		컬럼명 데이터유형 CONSTRAINT 제약명 CHECK (컬럼명 IN (데이터1, 데이터2))
		cf) CHECK (조건문의 구문)
 */
CREATE TABLE student06(
	NO NUMBER,
	name varchar2(50),
	gender char(1) CONSTRAINT student06_gender_ck CHECK (gender IN ('M', 'F'))
);
INSERT INTO student06 VALUES (1000, '홍길동', 'M');
INSERT INTO student06 VALUES (1001, '신길동', 'M');
INSERT INTO student06 VALUES (1002, '홍영자', 'F');
INSERT INTO student06 VALUES (1003, '하길동', NULL); -- 가능
INSERT INTO student06 VALUES (1004, '마길동', 'K'); -- 불가능, 지정된 문자열과 NULL만 입력 가능
SELECT * FROM student06;
-- ex) product22 테이블에 물건번호, 물건명, 가격, 등급을 설정하되
--		등급은 A~C까지만 입력이 가능하도록 한다.
CREATE TABLE product22 (
	prodnum char(8),
	prodname varchar2(50),
	price NUMBER CHECK (price >= 1), -- CHECK 조건문으로 제약설정
	grade char(1) CONSTRAINT product22_grade_ck CHECK (grade IN ('A', 'B', 'C'))
);
INSERT INTO product22 VALUES ('100-3000', '책상', 100000, 'A');
INSERT INTO product22 VALUES ('100-3001', '책상', 90000, 'B');
INSERT INTO product22 VALUES ('100-3001', '의자', 80000, 'C');
INSERT INTO product22 VALUES ('100-3000', '책상', 60000, 'D'); -- 제약조건을 벗어나서 불가능
INSERT INTO product22 VALUES ('100-3000', '책상', 80000, 'C');
INSERT INTO product22 VALUES ('100-3002', '의자', 0, 'B'); -- X
INSERT INTO product22 VALUES ('100-3002', '의자', NULL, 'B'); -- NULL값도 가능
SELECT * FROM product22;
-- foreign key : 외래키 관계 설정 - 다른 테이블에 있는 특정 컬럼의 데이터만 입력 가능하게 설정할 때 활용된다.
-- ex) 사원정보의 부서번호는 부서테이블의 부서번호만 입력이 가능하다.
CREATE TABLE professor(
	NO NUMBER PRIMARY KEY,
	name varchar2(50)
);
INSERT INTO professor values(10, '홍길동');
INSERT INTO professor values(20, '김길동');
INSERT INTO professor values(30, '신길동');
SELECT * FROM professor;
CREATE TABLE student07(
	NO NUMBER,
	name varchar2(50),
	adno NUMBER REFERENCES professor(NO) -- 참조하려면 그 대상이 PRIMARY KEY여야 한다.
);
INSERT INTO student07 VALUES (1000, '김영수', 10);
INSERT INTO student07 VALUES (1002, '오영수', 20);
INSERT INTO student07 VALUES (1003, '한영수', 40);
