/*
# 데이터베이스 보안을 위한 권한 설정
1. 데이터베이스 관리자(DBA)는 사용자가 데이터베이스 객체(테이블, view, sequence)에 대한 특정 권한을 가질 수 있게 하여,
	다수의 사용자가 데이터베이스에 저장된 정보를 공유하면서 정보에 대한 보안이 이루어지도록 한다.
2. DB 서버에 접근 시 필요한 사용자 계정/암호를 통해 로그인 인증을 받는다.
3. 권한의 역할과 종류
	1) CREATE USER : 사용자를 새롭게 생성하는 권한
	2) DROP USER : 사용자를 삭제하는 권한
	3) DROP ANY TABLE : 테이블을 삭제하는 권한
	4) QUERY REWRITE : 함수 기반 인덱스 생성 권한
	5) BACKUP ANY TABLE : 테이블 함수 백업 권한
	6) CREATE SESSION : 데이터베이스에 접속할 수 있는 권한
	7) CREATE TABLE/VIEW/SEQUENCE/PROCEDURE 데이터베이스의 객체들을 생성하는 권한
	8) RESOURCE : 여러 객체들을 생성/사용 가능한 권한
	9) DBA : 관리자 권한으로 계정을 생성하고, 권한을 부여할 수 있는 권한
 */
/*
# 사용자 생성하기
1. system 관리자 계정으로 접근하여 scott에 DBA 권한을 부여하여
	계정 생성과 권한 부여가 가능하게 해야 한다.
2. 권한 부여
	cmd
	sqlplus
	system/1111
	grant dba to scott;
3. 사용자 생성
	CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
4. 권한 부여
	GRANT 권한명 TO 계정명
	CREATE SESSION - 접속권한
 */
CREATE USER orauser100 IDENTIFIED BY user100;
GRANT CREATE SESSION TO orauser100;
/*
ex) orauser200/user200으로 계정과 비밀번호를 선언하여 계정을 생성하고,
	해당 계정에 접근 권한을 주고 접근하세요. (cmd 창에서)
 */



