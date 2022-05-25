-- 2022-05-17
-- empno(사원번호), ename(사원명), job(직책), mgr(관리자번호),
-- hiredate(입사일), sal(급여), comm(보너스), deptno(부서번호)

--[1단계:개념] 1. 특정 DB서버에 접속에 필요한 정보는 무엇이 있는가를 기술해 보세요.
			-- username/password?
			-- SELECT * FROM ?
--[1단계:개념] 2. select 구문의 컴럼 선택과 별칭사용에 대하여 예제를 통하여 설명하세요.
SELECT empno FROM emp;
SELECT empno 사원번호 FROM emp; -- empno를 사원번호로 출력
SELECT empno AS 사원번호 FROM emp; -- 위와 동일
SELECT empno "사원 번호" FROM emp; -- 띄어쓰기는 "" 안에 넣어 출력

--[1단계:확인] 3. emp 테이블의 컬럼명을 한글로 표현해보세요. ex) 사원번호, 사원명, 직책, 관리자, 입사일, 급여, 보너스, 부서번호
SELECT empno 사원번호, ename 사원명, job 직책, mgr 관리자번호,
hiredate 입사일, sal 급여, comm 보너스, deptno 부서번호
FROM emp;

--[1단계:확인] 4. sal를 부서번호로 보너스처리하여 급여를 정하기로 했다.  sal==> 기본급여, deptno ==> 보너스, 총급여(기본급여+보너스)
--            로 처리하여 출력하되 alias명도 함께 처리하세요.
SELECT sal 기본급여, deptno 보너스, sal + deptno 총급여
FROM emp;

--[1단계:확인] 5. 아래의 형식으로 컬럼간의 연산과 연결처리를 하여 alias로 출력하세요.
--            1) @@님의 사원번호는 @@이고, 올해 연말보너스는 연봉의 20%인 @@원입니다.  @@님(ename)
SELECT ename || '님의 사원번호는 ' || empno || '이고, 올해 연말보너스는 연봉의 20%인 ' || sal / 5 || '만원입니다.' show
FROM emp;

--            2) @@님의 입사일은 @@이고, 현재 연봉의 1/12인 월급여는 @@만원.   입사일 @@(hiredate)
SELECT ename || '님의 입사일은 ' || hiredate || '이고, 현재 연봉의 1/12인 월급여는 ' || round(sal / 12) || '만원입니다.' show
FROM emp;

--            3) @@님의 이번달 보너스는 연봉(sal)의 deptno%기준으로  @@@만원 지급합니다. 
SELECT ename || '님의 이번달 보너스는 연봉의  ' || deptno || '% 기준으로 ' || sal * deptno / 100 || '만원 지급합니다.' show
FROM emp;

--[1단계:개념] 6. distinct로 데이터를 처리해야 하는 경우를 기본예제를 통해서 설명하세요.
SELECT DISTINCT job 직업명 FROM emp; -- emp 내의 모든 직업의 수를 구할 때
