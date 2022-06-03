--2022-06-02
--[1단계:개념] 1. 잘못된 설계에 의한 이상현상을 종류 기술하세요
/*
	1. 삭제 이상 : 튜블 삭제 시 다른 데이터까지 연쇄 삭제되는 현상
	2. 삽입 이상 : 튜플 삽입 시 특정 속성에 해당하는 값이 없어 null값을 입력하는 현상
	3. 수정 이상 : 튜플 수정 시 중복된 데이터의 일부만 수정되어 데이터 불일치가 일어나는 현상
 */

--[1단계:확인] 2. 오늘 만든 수강테이블의 삭제이상의 경우를 처리하고 문제점을 기술하세요
DROP TABLE stdlesn;
CREATE TABLE stdlesn (
	stdno NUMBER,
	stdname varchar2(50),
	subject varchar2(50),
	address varchar2(50),
	lesnname varchar2(50),
	lectroom varchar2(50)
);
INSERT INTO stdlesn VALUES (501, '박지성', '컴퓨터과', '영국 맨체스터', '데이터베이스', '공학관 110');
INSERT INTO stdlesn VALUES (401, '김연아', '체육학과', '대한민국 서울', '데이터베이스', '공학관 110');
INSERT INTO stdlesn VALUES (402, '장미란', '체육학과', '대한민국 강원도', '스포츠경영학', '체육관 103');
INSERT INTO stdlesn VALUES (502, '추신수', '컴퓨터과', '미국 클리블랜드', '자료구조', '공학관 111');
INSERT INTO stdlesn VALUES (501, '박지성', '컴퓨터과', '영국 맨체스터', '자료구조', '공학관 111');
SELECT * FROM stdlesn;

DELETE FROM stdlesn
WHERE stdname = '장미란';
SELECT * FROM stdlesn;
-- 학생이름 '장미란'만 삭제했는데 '대한민국 강원도', '스포츠경영학', '체육관 103' 등의 속성도 연쇄 삭제 되었다.
INSERT INTO stdlesn VALUES (402, '장미란', '체육학과', '대한민국 강원도', '스포츠경영학', '체육관 103');
-- 학생수강 테이블을 학생 테이블과 강의 테이블로 나누어 학생 테이블에서 '장미란' 학생을 삭제하면 된다.
CREATE TABLE student001
AS
SELECT stdno, stdname, subject, lesnname
FROM stdlesn;
CREATE TABLE lesson001
AS
SELECT lesnname, lectroom, stdno
FROM stdlesn;
SELECT * FROM student001;
SELECT * FROM lesson001;

DELETE FROM student001 WHERE stdname = '장미란';

--[1단계:확인] 3. 수강테이블의 등록이상의 경우를 처리하고 문제점을 기술하세요
INSERT INTO stdlesn VALUES (503, '김철수', '무역학과', '대한민국 서울', '', '');
SELECT * FROM stdlesn; -- lesnname, lectroom에 null값이 들어감
-- 삭제 이상과 마찬가지로 학생 테이블과 강의 테이블로 나누어 학생 테이블에서 '김철수'의 데이터를 삽입하면 된다.
CREATE TABLE student002
AS
SELECT stdno, stdname, subject, address
FROM stdlesn;
CREATE TABLE lesson002
AS
SELECT lesnname, lectroom, stdno
FROM stdlesn;

INSERT INTO student002 VALUES (503, '김철수', '무역학과', '대한민국 서울');
SELECT * FROM student002;

--[1단계:확인] 4. 수강테이블의 수정이상의 경우를 처리하고 문제점을 기술하세요
UPDATE stdlesn
	SET lectroom = '공학관 113'
	WHERE stdno = 501;
SELECT * FROM stdlesn; -- 데이터베이스의 수업만 강의실을 공학관 113 으로 수정하려고 했지만 자료구조 수업의 강의실도 같이 수정되었다.
-- 수정할 때 조건을 더 구체적으로 설정한다.
UPDATE stdlesn
	SET lectroom = '공학관 111'
	WHERE stdno = 501 AND lesnname = '자료구조'; -- 자료구조 수업만 공학관 111로 수정
SELECT * FROM stdlesn;

--[1단계:확인] 5. 수강테이블의 이상현상을 없애기 위한 테이블 구조를 erd를 통해 분리시키고, 테이블을 작성하고 데이터를 입력하세요
CREATE TABLE student003
AS
SELECT stdno, stdname, subject, address
FROM stdlesn;
INSERT INTO student003 VALUES (501, '박지성', '컴퓨터과', '영국 맨체스터');
INSERT INTO student003 VALUES (401, '김연아', '체육학과', '대한민국 서울');
INSERT INTO student003 VALUES (402, '장미란', '체육학과', '대한민국 강원도');
INSERT INTO student003 VALUES (502, '추신수', '컴퓨터과', '미국 클리블랜드');
INSERT INTO student003 VALUES (501, '박지성', '컴퓨터과', '영국 맨체스터');
SELECT * FROM student003;

CREATE TABLE lesson003
AS
SELECT lesnname, lectroom, stdno
FROM stdlesn;
INSERT INTO lesson003 VALUES ('데이터베이스', '공학관 110', 501);
INSERT INTO lesson003 VALUES ('데이터베이스', '공학관 110', 401);
INSERT INTO lesson003 VALUES ('스포츠경영학', '체육관 103', 402);
INSERT INTO lesson003 VALUES ('자료구조', '공학관 111', 502);
INSERT INTO lesson003 VALUES ('자료구조', '공학관 111', 501);
SELECT * FROM lesson003;

--[1단계:확인] 6. 분리된 테이블에서 이상 현상이 더 이상 발생하지 않음을 sql을 통해 처리결과를 출력해보세요.
DELETE FROM student003 WHERE stdname = '장미란';
SELECT * FROM lesson003; -- 스포츠경영학 여전히 존재

INSERT INTO student003 VALUES (503, '김철수', '무역학과', '대한민국 서울');
SELECT * FROM student003; -- null값이 생기지 않음

UPDATE lesson003
	SET lectroom = '공학관 113'
	WHERE stdno = 501 AND lesnname = '데이터베이스';
SELECT * FROM lesson003; -- 데이터베이스 수업의 강의실만 수정됨


-- 해설
CREATE TABLE student004
AS
SELECT DISTINCT stdno, stdname, subject, address
FROM stdlesn;
SELECT * FROM student004;

CREATE TABLE lesson004
AS
SELECT DISTINCT stdno cno, lesnname, lectroom
FROM stdlesn
WHERE 1 = 0;
SELECT * FROM lesson004;
INSERT INTO lesson004 VALUES (101, '데이터베이스', '공학관 110');
INSERT INTO lesson004 VALUES (101, '데이터베이스', '공학관 110');
INSERT INTO lesson004 VALUES (102, '스포츠경영학', '공학관 103');
INSERT INTO lesson004 VALUES (100, '자료구조', '공학관 111');
INSERT INTO lesson004 VALUES (100, '자료구조', '공학관 111');

	-- join 하여 전체 내용 출력
CREATE TABLE signup004(
	stdno NUMBER,
	cno NUMBER
);
INSERT INTO signup004 values(501, 101);
INSERT INTO signup004 values(401, 101);
INSERT INTO signup004 values(402, 102);
INSERT INTO signup004 values(502, 100);
INSERT INTO signup004 values(501, 100);
SELECT * FROM student004;
SELECT * FROM lesson004;
SELECT * FROM signup004;

SELECT DISTINCT s.*, l.*
FROM student004 s, lesson004 l, signup004 u
WHERE s.stdno = u.stdno
AND l.cno = u.cno;


-- 삭제이상 : 이상현상 발생하지 않음
--	장미란 데이터 402를 삭제해도 스포츠 경영학이 없어지지 않는다.
DELETE FROM student004
WHERE stdno = 402;
SELECT * FROM student004;
SELECT * FROM lesson004;
-- 수정이상 :
--	박지성(501)의 주소 1 row만 변경해도 모든 조인 데이터에 반영된다.
UPDATE student004
	SET address = '대한민국 서울'
WHERE stdno = 501;
SELECT * FROM student004;
SELECT * FROM lesson004;
-- 삽입이상 :
--	박세리(403, 박세리)를 삽입하여도 null이 생성되지 않는다.
INSERT INTO student004 VALUES (403, '박세리', '체육학과', '대한민국 대전');
SELECT * FROM student004;
SELECT * FROM lesson004;
