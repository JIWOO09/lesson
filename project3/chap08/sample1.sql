SET SERVEROUTPUT ON;
-- 결과물을 보기 위한 (기본적으로 OFF)

DECLARE
-- 선언

BEGIN
-- 실행

EXCEPTION
-- 예외처리

END;


-- 출력하기
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO PL/SQL');
END;
/

--- := 대입연산자
DECLARE -- 변수선언과 동시에 데이터 초기화하기
    ID   NUMBER := 5;
    NAME VARCHAR2(10) := '서지우';

BEGIN
    --ID := 5;  
    --NAME := '서지우';
        DBMS_OUTPUT.PUT_LINE('번호 : ' || ID );
        DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME );
END;
/


DECLARE -- 변수선언과 동시에 데이터 초기화하기
    ID   NUMBER := 5;
    NAME VARCHAR2(10) := '서지우';

BEGIN
    ID := ID + 1; -- 연산식도 가능하다.
    NAME := '서지우';
        DBMS_OUTPUT.PUT_LINE('번호 : ' || ID );
        DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME );
END;
/



-- 스캐너 같은 기능 입력값 받기
DECLARE 
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM; 
        DBMS_OUTPUT.PUT_LINE('입력 한 정수값 : ' || VAL );
        
END;
/

-- IF문으로 입력 받은 값 홀짝
DECLARE 
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    IF(MOD(VAL,2) = 0) THEN  --MOD 나머지 구하기 함수
        DBMS_OUTPUT.PUT_LINE('짝수를 입력했습니다.');
    ELSIF(MOD(VAL,2) = 1) THEN    
        DBMS_OUTPUT.PUT_LINE('홀수를 입력했습니다.');
    END IF;    
END;
/

-- 반복문
DECLARE 
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    LOOP
        DBMS_OUTPUT.PUT_LINE('반복문 입니다.' || VAL);
        VAL := VAL - 1;
        IF VAL = 0 THEN EXIT;
        END IF;
    END LOOP;    
END;
/

BEGIN
    FOR I IN 0..3 LOOP -- 0부터 3까지 반복
        DBMS_OUTPUT.PUT_LINE('반복문 입니다.' || I);
    END LOOP;    
END;
/

BEGIN
    FOR I IN REVERSE 0..3 LOOP -- 0부터 3까지  반대로 반복 3부터
        DBMS_OUTPUT.PUT_LINE('반복문 입니다.' || I);
    END LOOP;    
END;
/

--WHILE문
DECLARE
    VAL NUMBER;
BEGIN
    VAL := 0;
    WHILE VAL < 3 LOOP
        DBMS_OUTPUT.PUT_LINE('WHILE 반복문 입니다.' || VAL);
        VAL := VAL + 1;
    END LOOP;    
END;
/

DECLARE
 FNAME EMPLOYEES.FIRST_NAME%TYPE; -- 컬럼에 있는 타입이 바껴도 자동으로 맞춰지게
 LNAME EMPLOYEES.LAST_NAME%TYPE; --데이터베이스 테이블의 컬럼 데이터 타입을 모를 경우 사용

 SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT FIRST_NAME,
            LAST_NAME,
            SALARY
    INTO FNAME, LNAME, SALARY
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('성 : ' || LNAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || FNAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);
END;
/


DECLARE
 EMP EMPLOYEES%ROWTYPE; --테이블이나 뷰 내부의 컬럼 데이터형, 크기, 속석등을 그대로 사용
 
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || EMP.SALARY);


END;
/


DECLARE
 EMP EMPLOYEES%ROWTYPE; --테이블이나 뷰 내부의 컬럼 데이터형, 크기, 속석등을 그대로 사용
 
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || EMP.SALARY);

--예외처리
EXCEPTION
WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.'); -- 없는 ID를 입력할 시
WHEN TOO_MANY_ROWS THEN
    DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/

DECLARE
DEP_NAME TB_DEPARTMENT.DEPARTMENT_NAME%TYPE;
CAT TB_DEPARTMENT.CATEGORY%TYPE;
OPEN TB_DEPARTMENT.OPEN_YN%TYPE;
CAP TB_DEPARTMENT.CAPACITY%TYPE; 

BEGIN
   -- TB_STUDENT, TB_DEPARTMENT..
   -- 학과번호를 입력하면 해당 학과의 이름, 카테고리, 개설여부, 최대인원, 실인원
   -- 정보가 출력될 수 있도록 한다.
SELECT DEPARTMENT_NAME,
            CATEGORY,
            OPEN_YN,
            CAPACITY
        
    INTO DEP_NAME, CAT, OPEN, CAP
    FROM TB_DEPARTMENT
    WHERE DEPARTMENT_NO = 001;

    DBMS_OUTPUT.PUT_LINE('학과이름 : ' || DEP_NAME);
    DBMS_OUTPUT.PUT_LINE('카테고리 : ' || CAT);
    DBMS_OUTPUT.PUT_LINE('개설여부 : ' || OPEN);
    DBMS_OUTPUT.PUT_LINE('최대인원 : ' || CAP);
    

--예외처리
EXCEPTION
WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.'); -- 없는 ID를 입력할 시
WHEN TOO_MANY_ROWS THEN
    DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/

SELECT * FROM TB_DEPARTMENT;


---- 강사님 풀이 --- 

CREATE VIEW V_DEPT_INFO AS
    SELECT A.DEPARTMENT_NO AS 학과코드
         , A.DEPARTMENT_NAME AS 학과명
         , A.CATEGORY AS 분류
         , A.OPEN_YN AS 개설여부
         , A.CAPACITY AS 정원
         , COUNT(*) AS 현재인원
      FROM TB_DEPARTMENT A JOIN TB_STUDENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
     GROUP BY A.DEPARTMENT_NO, A.DEPARTMENT_NAME
            , A.CATEGORY, A.OPEN_YN, A.CAPACITY;

DECLARE
    R V_DEPT_INFO%ROWTYPE;
    DEPT_CODE V_DEPT_INFO.DEPARTMENT_NO%TYPE;
BEGIN
    SELECT *
      INTO R
      FROM V_DEPT_INFO
     WHERE 학과코드 = &DEPT_CODE;

    DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/



-- 다중행 배열 사용

BEGIN
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/

DECLARE
    TYPE NAME_ARRAY IS TABLE OF V_DEPT_INFO.학과명%TYPE INDEX BY BINARY_INTEGER;
    ARR_NAME NAME_ARRAY;
    IDX BINARY_INTEGER := 0;  -- 인덱스 저장 하기 위한 변수
BEGIN
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        IDX := IDX + 1; -- 인덱스 1씩 증가
        ARR_NAME(IDX) := R.학과명;-- 1부터 시작
    END LOOP;

    FOR I IN 1..IDX LOOP-- 1부터 반복
        DBMS_OUTPUT.PUT_LINE(ARR_NAME(I));
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/


--TB_PROFESSOR, TB_STUDENT 의 이름, 주민번호,주소를 출력하는 PL/SQL 작성
-- 주민전호의 경우 마지막 7가지에 대해 *******로 처리 될 수 있도록 한다.
-- 사용자 입력으로 숨김이라는 입력을 받으면 *******로 처리되게 한다.

CREATE VIEW V_STD_PROF_INFO AS
    SELECT STUDENT_NAME AS NAME
        , STUDENT_SSN AS SSN
        , STUDENT_ADDRESS AS ADDR
    FROM TB_STUDENT
    UNION ALL
    SELECT PROFESSOR_NAME AS NAME
        , PROFESSOR_SSN AS SSN
        , PROFESSOR_ADDRESS AS ADDR
    FROM TB_PROFESSOR;

SELECT * FROM V_STD_PROF_INFO;

DECLARE
    HIDDEN_YN   CHAR(1);
    INPUT       VARCHAR2(10);
    INPUT_VAL   VARCHAR2(10);
BEGIN
    INPUT := '&INPUT';
    IF INPUT_VAL = '숨김' THEN
        HIDDEN_YN := 'Y';
    ELSE
        HIDDEN_YN := 'N';
    END IF;

    FOR R IN (SELECT * FROM V_STD_PROF_INFO WHERE ROWNUM <= 10) LOOP
        DBMS_OUTPUT.PUT(R.NAME || ' | ');

        IF HIDDEN_YN = 'Y' THEN
            DBMS_OUTPUT.PUT(SUBSTR(R.SSN, 1, 8) || '******' || ' | ');
        ELSE
            DBMS_OUTPUT.PUT(R.SSN);
        END IF;

        DBMS_OUTPUT.PUT(R.ADDR);
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/



-- 구구단을 출력하는 PL/SQL 작성DECLARE 

SET SERVEROUTPUT ON;
DECLARE

BEGIN
    FOR I IN 1..9 LOOP
        FOR J IN 1..9 LOOP
        DBMS_OUTPUT.PUT(I || '*' || J || '=' || I * J || '   '); -- PUT은 개행없이
        END LOOP;
        DBMS_OUTPUT.PUT_LINE(''); -- PUT_LINE은 개행
        END LOOP;
END;
/

--- WHILE문 구구단

DECLARE
    I NUMBER := 1;
    J NUMBER := 1;

BEGIN
    WHILE I <= 9 LOOP
        WHILE J <= 9 LOOP
        DBMS_OUTPUT.PUT(I || '*' || J || '=' || I * J || '   '); -- PUT은 개행없이
        J := J + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE(''); -- PUT_LINE은 개행
        I := I + 1;
        J := 1;
    END LOOP;
END;
/


DECLARE
    TYPE NUM_ARRY IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
    RESULTS NUM_ARRY;
    IDX BINARY_INTEGER := 1;
BEGIN
    FOR I IN 1..9 LOOP
        FOR J IN 1..9 LOOP
       RESULTS(IDX) := I * J;
        IDX := IDX + 1;
        END LOOP;
    END LOOP;

    FOR N IN 1..IDX-1 LOOP
    DBMS_OUTPUT.PUT_LINE(RESULTS(N) || '  ');
    END LOOP;
END;
/

-- EMPLOYEES 테이블에서 직원들의 급여와 직원이름을 출력할 때 커미션이 있는 직원은
-- 계산하여 출력할 때"(커미션 포함)" 이라는 내용과 같이 출력되도록