--2022-05-31
--[1단계:개념] 1. 데이터베이스의 생명주기를 예시와 함께 설명하세요.
/*
1. 요구사항 수집 및 분석
2. 설계 (개념적/논리적/물리적 설계)
3. 구현
4. 운영
5. 감시 및 개선

데이터베이스를 설계하고 운영 및 관리하는 과정을 말한다.
 */

--[1단계:개념] 2. 개념적모델링/논리적모델링/물리적 모델링의 차이점을 기술하세요
/*
1. 개념적 모델링 : 테이블과 데이터만 존재하고 테이블 간의 관계는 존재하지 않는다.
2. 논리적 모델링 : 상세 속성을 정하고 테이블 간의 관계를 표시한다.
3. 물리적 모델링 : DB 객체와 데이터타입을 정한다.
 */

--[1단계:확인] 3. 아래와 같은 요구사항에 합당한 개념/논리/물리 모델링을 처리하세요.
--               회사는 네개의 부서를 운영한다. 부서는(부서번호, 부서이름)을 저장한다.
--               부서는 1명 이상의 직원(직원번호,직원이름,직책)을 있다. 각 직원은 하나의 부서에 소속된다.
--               직원은 부양가족(이름, 나이)이 있을 수 있다

--[1단계:확인] 3. 사원테이블 내에 사원번호와 관리자번호와 1:1관계로 설정한 엔티티타입을 erd로 만드세요.

--[1단계:확인] 4. 커플사이트에 회원들 간에 남녀 매칭하는 테이블을 구현할려고 한다. erd를 만들고, 카디넬러티를 
--            만든후, 실제 테이블을 만들고 데이터를 입력처리하여 조인결과를 확인하세요.
CREATE TABLE male(
	maleno NUMBER PRIMARY KEY,
	mname varchar2(50),
	mjob varchar2(50),
	wantfjob varchar2(50)
);
CREATE TABLE female(
	femaleno NUMBER PRIMARY KEY,
	fname varchar2(50),
	fjob varchar2(50),
	wantmjob varchar2(50)
);
CREATE TABLE matching(
	matchingno NUMBER PRIMARY KEY,
	maleno varchar2(50),
	femaleno varchar2(50)
);
INSERT INTO male VALUES (1000, '김가혁', '의사', '공무원');
INSERT INTO male VALUES (1001, '김나준', '개발자', '작가');
INSERT INTO male VALUES (1002, '김다환', '공인중개', '꽃집');
INSERT INTO female VALUES (2000, '김가희', '공무원', '의사');
INSERT INTO female VALUES (2001, '김나은', '꽃집', '공인중개');
INSERT INTO female VALUES (2002, '김다영', '작가', '개발자');
INSERT INTO matching VALUES (1, 1000, 2000);
INSERT INTO matching VALUES (2, 1001, 2002);
INSERT INTO matching VALUES (3, 1002, 2001);
SELECT * FROM male;
SELECT * FROM female;
SELECT * FROM matching;

SELECT m.mname, f.fname
FROM male m, female f, matching mch
WHERE m.maleno = mch.maleno AND f.femaleno = mch.femaleno;

--[1단계:개념] 5. DB권한과 역할을 종류를 기술하세요
/*
1. CREATE USER : 사용자를 새롭게 생성하는 권한
2. DROP USER : 사용자를 삭제하는 권한
3. DROP ANY TABLE : 테이블을 삭제하는 권한
4. QUERY REWRITE : 함수 기반 인덱스 생성 권한
5. BACKUP ANY TABLE : 테이블 함수 백업 권한
6. CREATE SESSION : 데이터베이스에 접속할 수 있는 권한
7. CREATE TABLE/VIEW/SEQUENCE/PROCEDURE : 데이터 베이스에 객체들을 생성하는 권한
8. RESOURCE : 여러 객체들을 생성/사용 가능한 권한
9. DBA : 관리자 권한으로 계정을 생성하고, 권한을 부여할 수 있는 권한
 */

--[1단계:확인] 6. 관리자 권한에서 scott3계정을 만들고, 해당 계정으로 접근하게 처리하세요
