--2022-05-27
--[1단계:개념] 1. 무결성 제약조건을 설정하는 목적을 기술하세요.
--	데이터의 정확성과 일관성을 보장하여 다양한 종류의 업무규칙을 고려하기 위함이다.

--[1단계:개념] 2. not null 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
CREATE TABLE student00 (
	stdno char(9) PRIMARY KEY,
	stdname varchar(50) NOT NULL,
	stdsub varchar(50)
);
-- NOT NULL 제약조건이 있는 컬럼에는 NULL값이 들어갈 수 없다.
INSERT INTO student00 VALUES (201610677, '전장호', '산업공학과'); -- 가능
INSERT INTO student00 VALUES (201610678, NULL, '산업공학과'); -- stdname은 NOT NULL 조건이 있기 때문에 불가능
INSERT INTO student00 VALUES (201610679, '김철수', NULL); -- 가능

--[1단계:개념] 3. unique 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
-- UNIQUE 제약조건이 있는 컬럼에는 고유하지 않은 값이 들어갈 수 없다.
INSERT INTO student00 VALUES (201610680, '송도환', '산업공학과'); -- stdsub은 고유하지 않은 값이라도 삽입 가능
INSERT INTO student00 VALUES (201610680, '안영희', '산업공학과');
-- stdno는 PRIMARY KEY 조건을 갖고 있고, PRIMARY KEY 조건은 UNIQUE 조건을 포함하므로 고유하지 않은 값은 삽입 불가능

--[1단계:확인] 4. 회원테이블에서 id, pass, 이름, 권한, 포인트를 설정하되,
--      제약조건의 이름은 모두가 설정하고,
--      id : not null, unique, pass : not null, 이름: not null
--      권한 : 관리자/일반사용자/슈퍼유저 만등록, 포인트 : 0이상 등록 가능
CREATE TABLE member00 (
	id varchar2(50) PRIMARY KEY,
	pass varchar2(50) NOT NULL,
	name varchar2(50) NOT NULL,
	auth varchar2(50) CONSTRAINT member00_auth_ck CHECK (auth IN ('관리자', '일반사용자', '슈퍼유저')),
	point NUMBER CHECK (point >= 0)
);
SELECT * FROM member00;

--[1단계:개념] 5. 무결성 제약 조건의 null의 관계를 기술하세요.
/*
	1) PRIMARY KEY : NULL값 불가능, 다른 값은 모두 고유해야 함
	2) NOT NULL : NULL값 불가능
	3) UNIQUE : 다른 값은 모두 고유해야 하나, NULL값만 중복 가능
 */

--[1단계:개념] 6. 무결성 제약조건의 이름을 쓰는 경우와 쓰지 않는 경우 형식의 차이를 기술하세요.
CREATE TABLE student000 (
	stdno char(9) PRIMARY KEY,
	stdname varchar2(50) NOT NULL,
	point NUMBER CHECK (point >= 0),
	grade char(1) CONSTRAINT student000_grade_ck CHECK (grade IN ('A', 'B', 'C'))
); -- 특정한 조건이 필요할 때 제약조건의 이름을 쓴다.

--[1단계:확인] 7. 물건(물건번호, 이름, 가격, 단위, 분류번호) 제품구분(분류번호, 분류명, 우선순위)
--      1000 사과   3000 개  10     10 과일류 1
--      1001 소고기 10000 g  20     20 육류  2
--        제품구분의 분류번호와 물건의 분류번호는 foreign key 관계로 설정하세요.
DROP TABLE product00;
DROP TABLE product000;
CREATE TABLE product00 (
	prdno char(6),
	prdname varchar2(50),
	price NUMBER,
	danwi varchar(50),
	clsf char(6) PRIMARY KEY
);
CREATE TABLE product000 (
	clsf2 char(6) REFERENCES product00(clsf),
	clsfname varchar2(50),
	frst NUMBER CHECK (frst >= 1 AND frst < 100)
);
INSERT INTO product00 VALUES ('15-777', '전자레인지', 100000, '원', '10-233');
INSERT INTO product00 VALUES ('15-787', '책상', 80000, '원', '10-234');
INSERT INTO product00 VALUES ('15-788', '의자', 50000, '원', '10-235');
INSERT INTO product000 VALUES ('10-233', '가전제품', 1);
INSERT INTO product000 VALUES ('10-234', '가구', 2);
INSERT INTO product000 VALUES ('10-235', '가구', 3);

SELECT * FROM product00;
SELECT * FROM product000;
