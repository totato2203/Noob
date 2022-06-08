CREATE TABLE ask(
	var varchar2(50) CONSTRAINT ask_var_ck CHECK (ask IN ('배송', '수거', '사고보상', '이벤트')), -- (배송, 수거, 사고보상, 이벤트) 만 입력 가능
	name varchar2(50),
	phone varchar2(50),
	email varchar2(50),
	password varchar2(50),
	contents varchar2(500)
);




