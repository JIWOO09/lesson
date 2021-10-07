
-- 시퀀스 생성
CREATE SEQUENCE TEMP_SEQ;

--시퀀스 객체를 처음 생성 후에는 NEXTVAL를 하여 값의 생성이 필요하다.
SELECT TEMP_SEQ.NEXTVAL FROM DUAL;
-- 실행할때마다 값이 올라감

SELECT TEMP_SEQ.CURRVAL FROM DUAL;
-- 현재 값 확인

SELECT * FROM USER_SEQUENCES;
-- 생성된 시퀀스의 형태보기

-- 테이블 생성 ---
CREATE TABLE TEMP_T(
    ID     NUMBER PRIMARY KEY,
    NAME   VARCHAR(10),
    GENDER CHAR(1) DEFAULT('W') CHECK(GENDER IN ('M', 'W')) 

);

INSERT INTO TEMP_T VALUES(1, 'AAAA','W');
INSERT INTO TEMP_T VALUES(2, 'AAAA','W');
INSERT INTO TEMP_T VALUES(3, 'AAAA','W');

INSERT INTO TEMP_T VALUES(TEMP_SEQ.NEXTVAL,'AAAA','W');
-- 3 이어서 실행 할 때마다 추가로 행이 생성된다. > 4 > 5 > ...

SELECT * FROM TEMP_T;

--내가 입력한 3줄 만큼 3줄 추가 하여 업데이트
UPDATE TEMP_T
SET ID = TEMP_SEQ.NEXTVAL;

-------------------------------------------------------------------------

--- 비공개 동의어 만들기---

GRANT CREATE SYNONYM TO USER1; 
-- ADMIN 계정(시스템 계정)으로 접속 후 동의어를 만들기 위한 권한 생성

CREATE SYNONYM EMP FOR EMPLOYEES; 
--> 권한 생성 후 다시 USER1으로 접속하고 실행 > 동의어 만들어짐


SELECT * FROM EMPLOYEES;
SELECT * FROM EMP; -- 동의어로도 조회가능해진다.



--- 공개 동의어 만들기---

-- ADMIN(시스템계정)으로 접속 후 아래 구문 실행
CREATE PUBLIC SYNONYM EMPS FOR USER1.EMPLOYEES; 

SELECT * FROM USER1.EMPLOYEES;
SELECT * FROM EMPS;
-- USER1으로 접속해서 EMPS 실행해도 조회가능 

SELECT * FROM USER_SYNONYMS;



/*
   1.TB_STUDENT 테이블의 테이터를 사용하여 휴학중인 학생의 정보를 저장하기 위한 테이블과 뷰 생성
   (테이블 이름은 STUDENT_ABSENCE_TABLE)
   2. 생성한 테이블은 ID, 학번, 학과코드, 이름, 담당교수의 정보를 저장될 수 있게 한다.
   (ID는 식별값으로 사용하기 위한 컬럼으로 시퀀스를 사용한다.)
   3. 생성한 테이블은 STD_ABC 이름의 동의어로도 사용할수있게 한다.
   생성한 뷰는 V_STD_ABC 이름의 동의어로도 사용 할 수 있도록 만든다.
*/

CREATE TABLE STUDENT_ABSENCE_TABLE (
        ID       NUMBER,
        학번     VARCHAR2(10),
        학과코드 VARCHAR2(10),
        이름     VARCHAR2(50),
        담당교수 VARCHAR2(10)
);

ALTER TABLE STUDENT_ABSENCE_TABLE ADD CONSTRAINT SAB_ID_PK PRIMARY KEY(ID);
ALTER TABLE STUDENT_ABSENCE_TABLE MODIFY 학번 CONSTRAINT SAB_학번_NN NOT NULL;
ALTER TABLE STUDENT_ABSENCE_TABLE MODIFY 학과코드 CONSTRAINT SAB_학과코드_NN NOT NULL;
ALTER TABLE STUDENT_ABSENCE_TABLE MODIFY 이름 CONSTRAINT SAB_이름_NN NOT NULL;



CREATE SEQUENCE SAB_SEQUENCE;

INSERT INTO STUDENT_ABSENCE_TABLE(
SELECT SAB_SEQUENCE.NEXTVAL AS ID,
    STUDENT_NO AS 학번,
    DEPARTMENT_NO AS 학과코드,
    STUDENT_NAME AS 이름,
    COACH_PROFESSOR_NO AS 담당교수코드
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
);

CREATE SYNONYM STD_ABC FOR STUDENT_ABSENCE_TABLE;
 
SELECT * FROM STUDENT_ABSENCE_TABLE;
SELECT * FROM STD_ABC;

--- 뷰 생성---

CREATE VIEW STUDENT_ABSENCE_VIEW AS
SELECT ROWNUM AS ID,
    STUDENT_NO AS 학번,
    DEPARTMENT_NO AS 학과코드,
    STUDENT_NAME AS 이름,
    COACH_PROFESSOR_NO AS 담당교수코드
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y';

CREATE SYNONYM V_STD_ABC FOR STUDENT_ABSENCE_VIEW;

SELECT * FROM STUDENT_ABSENCE_VIEW;
SELECT * FROM V_STD_ABC;


SELECT * FROM TB_STUDENT WHERE ABSENCE_YN = 'Y';
SELECT * FROM TB_STUDENT;


-------INDEX---------------

SELECT ROWID,
    STUDENT_NO,
    STUDENT_NAME
FROM TB_STUDENT;


