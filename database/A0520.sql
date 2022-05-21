--2022-05-20
--[1단계:개념] 1. 형변환 형태의 2가지와 타입에 따른 유형3가지를 기본 예제를 통하여 기술하세요.
-- 묵시적 형변환
SELECT *
FROM emp
WHERE empno = '7999'; -- 묵시적으로 문자열을 숫자형으로 변환
-- 명시적 형변환
SELECT *
FROM emp
WHERE empno = to_number('7999');
-- to_char() : 날자형/숫자형 데이터 ==> 문자형 데이터로 형변환
SELECT hiredate, to_char(hiredate), to_char(hiredate, 'YYYY') -- YYYY 연도 반환
FROM emp;
SELECT to_char(sal, '99,999') -- 천 자리에 ,로 형변환
FROM emp;
-- to_number() : 문자열 데이터 ==> 숫자형 데이터로 형변환
SELECT ename, sal
FROM emp
WHERE to_number(sal) >= 1000; -- to_number로 형변환을 하지 않으면 문자이기 때문에 크기 비교가 불가능하다.
-- to_date() : 문자열 데이터 ==> 날짜형 데이터로 형변환
SELECT ename, to_date('881212', 'YYMMDD') -- 88년도 12월 12일로 형변환
FROM emp
WHERE sal >= 2000;

--[1단계:확인] 2. 사원 정보 테이블에 입사한 월의 1일을 사원명과 함께 출력하세요
SELECT ename, hiredate, last_day(add_months(hiredate, -1)) + 1
FROM emp;

--[1단계:개념] 3. to_char(날짜데이터,'옵션') 에서 날짜처리하는 옵션 매개변수에 대하여 기술하세요.
SELECT to_char(hiredate, 'YYYY - MM - DD') -- 'YYYY - MM - DD'는 '년년년년 - 월월 - 일일'로 변환되는 매개변수다.
FROM emp;

--[1단계:확인] 4. 사원의 입사분기별로 보너스를 차등 지급하고자 한다. 열단위로 처리하세요.사원명, 급여, 보너스 %, 보너스
--      (급여의 1/4분기 10%, 1/4분기 20%, 1/4분기 30%, 1/4분기 30%)
SELECT ename, sal, hiredate, to_char(hiredate, 'Q') 분기,
to_number(to_char(hiredate, 'Q'))*10 || '%' "보너스%",
sal * to_number(to_char(hiredate, 'Q'))*10 보너스
FROM emp;

--[1단계:확인] 5. 입사월이 4/4분기에 해당하는 사원의 정보를 +9시간 더하여 다음과 같이 출력하세요
--      사원명, @@@년 @@월 @@일 +9 출근
SELECT ename, hiredate + 9/24,
to_char(hiredate, 'YYYY') || '년 ' ||
to_char(hiredate, 'MM') || '월 ' ||
to_char(hiredate, 'DD') || '일 ' ||
to_number(to_char(hiredate, 'HH24')+9) || '시' 출근
FROM emp;


--[1단계:확인] 6. [nvl2활용] comm이 null일때는 sal의 15%로 설정하고, null일 아닐 때는 comm에서 sal의 5%를 더하여 보너스금액을
--              설정하여   사원명 연봉 보너스  를 출력하세요.
SELECT ename, sal, nvl2(comm, comm + sal*  0.05 , sal * 0.15) 보너스, sal + nvl2(comm, comm + sal*  0.05 , sal * 0.15) 총합
FROM emp;

--[1단계:확인] 7. [중첩함수] 사원번호를 기준으로 짝수이면 홍팀, 홀수이면 청팀으로 처리하여 출력하세요.
SELECT empno, MOD(empno, 2) "구분자",
nvl2(to_char(nullif(0, MOD(empno, 2))), '청팀', '홍팀') 팀
FROM emp;







