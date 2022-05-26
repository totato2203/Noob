/*
# 데이터 타입
1. 개요
	1) 데이터베이스에 저장되는 데이터는 문자, 숫자, 날짜, 이미지 등과 같은 다양한 형식으로 표현
	2) 실무에선 컬럼에 대한 데이터 타입이나 길이의 결정은 데이터베이스 설계 단게에서 신중하게 고려해야 하는 중요한 사항
	3) 데이터베이스 설계 단계에서 잘못 선정된 데이터 타입은 응용프로그램 개발을 어렵게 하거나 성능을 저하시키는 요인이 된다.
2. 종류
	1) 사용자 정의 : pl/sql에서 사용자 정의로 선언하여 사용한다.
	2) 내장
		- 스칼라 : *char(n), nchar(n),
				*varchar2(n), *nvarchar2(n)
				*number(p,s)
				*date
				raw(n)
				blob, clob, nclob, bfile
				long, long raw
				rowid
		- 모음(collection) : 주로 pl/sql에서 사용된다.
			varray
			table
		- 관계 : pl/sql에서 사용
			ref
3. 가장 많이 활용되는 oracle 데이터 타입의 종류(version에 따라 차이가 있음)
	1) char(size) :
		- size 크기의 고정 길이 문자 데이터 타입
		- 최대 크기 : 2000byte
		- 최소 크기 : 1byte
		ex) 주민번호, 학번, 코드성 데이터
	2) varchar2(size)
		- size 크기의 가변 길이 문자 데이터 타입
		- 최대 크기 : 4000byte
		- 최소 크기 : 1byte
	3) nvarchar2(size)
		- 국가별 문자 집합에 따른 size 크기의 문자 또는 바이트의 가변길이 문자 데이터 타입
		- 최대 크기 : 40000 byte
		- 최소 크기 : 1byte
	4) number(p,s)
		- 정밀도(p)와 스케일(s)로 표현되는 숫자 데이터 타입
		- p : 1~38
		- s : -84 ~ 127 : 소수점 이하 자리수
	5) date : 날짜 형식을 저장하기 위한 데이터 타입
4. 기타 데이터 유형
	1) rowid : 테이블 내 행의 고유 주소를 가지는 64진수 문자 타입
		행당 6byte(제한된 rowid) 또는 10byte(확장된 rowid)
	2) blob : 대용량의 바이너리 데이터를 저장하기 위한 데이터 타입 최대 크기 4GB
	3) *clob : 대용량의 텍스트 데이터를 저장하기 위한 데이터 타입 최대 크기 4GB
	4) bfile : 대용량의 바이너리 데이터를 파일 형태로 저장하기 위한 데이터 타입 최대 크기 4GB
	5) *timestamp(n) : date 데이터 타입의 확장된 형태, n은 milli second 자리수로 최대 9자리까지 표현가능
	6) interval year to month : 년과 월을 이용하여 기간을 저장
	7) interval day to second : 일, 시, ㅅ분, 초를 이용하여 기간을 저장, 두 날짜 값의 정확한 차이를 표현하는데 유용
 */
-- 회원 정보 테이블		921212-1702611
CREATE TABLE member101(
	id varchar2(50),
	pass varchar2(50),
	civilnumber char(14),
	point NUMBER,
	auth varchar2(20)
);
SELECT * FROM member101;
INSERT INTO member101 values('himan', '7777', '921212-1702611', 1000, '관리자');
-- ex) 물건정보 테이블을 만들되 물건의 일련번호(자리수 - 8)를 포함해서 물건명, 가격, 제품소개 로 만들고 데이터를 입력하세요.
CREATE TABLE stfInfo(
	stfNum char(8),
	name varchar(50),
	price NUMBER,
	intro varchar(500)
);
SELECT * FROM stfInfo;
INSERT INTO stfInfo values('101-2222', '책상', 100000, '은행나무로 만들어짐');



