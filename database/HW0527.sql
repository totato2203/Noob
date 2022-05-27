--2022-05-27
--[1단계:개념] 1. 무결성 제약조건을 설정하는 목적을 기술하세요.
--	데이터의 정확성과 일관성을 보장하여 다양한 종류의 업무규칙을 고려하기 위함이다.

--[1단계:개념] 2. not null 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
DROP TABLE student00;
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
	id varchar2(50),
	pass varchar2(50),
	name varchar2(50),
	auth 
);

--[1단계:개념] 5. 무결성 제약 조건의 null의 관계를 기술하세요.


--[1단계:개념] 6. 무결성 제약조건의 이름을 쓰는 경우와 쓰지 않는 경우 형식의 차이를 기술하세요.


--[1단계:확인] 7. 물건(물건번호, 이름, 가격, 단위, 분류번호) 제품구분(분류번호, 분류명, 우선순위)
--      1000 사과   3000 개  10     10 과일류 1
--      1001 소고기 10000 g  20     20 육류  2
--        제품구분의 분류번호와 물건의 분류번호는 foreign key 관계로 설정하세요.