CREATE TABLE ask(
	var varchar2(50) CONSTRAINT ask_var_ck
		CHECK (var IN ('배송', '수거', '사고보상', '이벤트')),
	name varchar2(50),
	phone varchar2(50),
	email varchar2(50),
	password varchar2(50),
	contents varchar2(500)
);

SELECT * FROM ask;
DROP TABLE ask;

INSERT INTO ask VALUES (
	'배송', '전장호', '01012345678', 'totato2203@naver.com', '1q2w3e4r',
	'작년에 시킨 택배가 아직도 안 도착했어요;');
INSERT INTO ask VALUES (
	'수거', '최춘식', '01077777777', 'choonsik@naver.com', '8888',
	'이 택배 수거해가세요.');
INSERT INTO ask VALUES (
	'이벤트', '김철수', '01056568877', 'chulsoo@naver.com', 'chulsoochurch',
	'무료 배송 이벤트인데 배송비가 나갔어요.');

SELECT * FROM ask
WHERE name = '전장호' AND phone = '01012345678' AND password = '1q2w3e4r';

