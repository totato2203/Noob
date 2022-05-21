/*
# 날짜형 데이터
1. 형식
	DATE : 날짜와 시간을 처리하는 데이터 유형
2. 포함 내용
	YYYY : 연도
	MM : 월
	DD : 일
	DAY : 요일
	AM/PM : 오전/오후 A.M/P.M
	HH/HH12 : 시간(1~12) 표시
	HH24 : 24시간(0~23)  표시
	MI : 분
	SS : 초
3. 형변환 형식
	1) to_char(날짜데이터, '형식')
	2) to_date('문자열데이터', '형식지정')
		날짜 형식으로 데이터 등록, 수정할 때나, 조건문에서 날짜를 검색할 때 주로 활용된다.
		cf) 회원 생일을 날짜 타입으로 설정할 때,
			생일[YYYY-MM-DD] 이렇게 문자열로 된 데이터 날짜로 변경해서 입력해야 한다.
			to_date('1995-12-12', 'YYYY-MM-DD')
			==> 입력하는 문자열이 어떤 형식으로 날짜 데이터에 입력하는지를 선언하고,
			형변환에 의해 변환처리하여 입력/조회/수정할 수 있게 한다.
*/
SELECT to_char(sysdate, 'AM HH:MI:SS') "현재시간(12)"
FROM dual;
-- ex) 사원정보 테이블에서 사원명, 입사일 + 현재시간표현 @@@년 @@월 @@일
--		24시간표 @@시 @@분 @@초 표현하여 출력하세요.
-- 표현 시 /, - 처럼 기본적으로 지원되는 문자 이외에는 "문자"로 추가하여 처리가 가능하다.
SELECT ename, hiredate,
to_char(hiredate, 'YYYY"년" MM"월" DD"일"') "날짜",
to_char(sysdate, 'HH24"시" MI"분" SS"초"') "시간",
to_char(hiredate, 'YYYY"년" MM"월" DD"일 "') ||
to_char(sysdate, 'HH24"시" MI"분" SS"초"') "날짜와 현재시간",
to_date(to_char(hiredate, 'YYYYMMDD ') ||
		to_char(sysdate, 'HH24MISS'),'YYYYMMDD HH24MISS') "날짜형 변경"
FROM emp;
/*
# 숫자형 데이터를 문자열 형식 변환처리
1. 기본형식 : to_char(숫자형 데이터, '형식')
2. 주요형식
	해당 자리수 이상의 데이터가 처리될 때 ###으로 표기된다.
		9999 : 기본 자리수에 맞게 처리
		0000 : 해당 자리수 이하일 때, 0으로 채워짐
		$ : 앞에 $표기 처리, \
		. : 특정한 자리를 표기 소수점
		, : X특정한 위치 ,를 표기 (천 단위 표기)
 */
SELECT ename, sal,
	to_char(sal, '99999') "형식 1",
	to_char(sal, '00000') "형식 2",
	to_char(sal, '$9999') "형식 3",
	to_char(sal, '9,999') "형식 4",
	to_char(sal, '9,999.999') "형식 5",
	to_char(sal * 1000000, '9,999.999') "형식 6"
FROM emp;





