
--프로시저 생성

CREATE OR PROCEDURE PROC_EMPLOYEES IS
BEGIN
 FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= 3) LOOP
    DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || '|' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/

EXEC PROC_EMPLOYEES;

CREATE OR REPLACE 
PROCEDURE PROC_EMPLOYEES(TOP_N IN NUMBER :=3) IS
BEGIN
 FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= TOP_N) LOOP
    DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || '|' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);

CREATE OR REPLACE 
PROCEDURE PROC_EMPLOYEES(TOP_N IN NUMBER := 3, JOB IN VARCHAR2 := '') IS
BEGIN
 FOR R IN (SELECT * FROM (SELECT * FROM EMPLOYEES 
            WHERE JOB_ID LIKE '%' || JOB || '%')WHERE ROWNUM <= TOP_N) LOOP
    DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || '|' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);
EXEC PROC_EMPLOYEES(5,'IT');

-- 만든 프로시져 소스보기
SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_EMPLOYEES';


-- 히든사용
CREATE OR REPLACE
PROCEDURE PROC_STD_PRO_INFO(hidden IN BOOLEAN := TRUE) IS
    HIDDEN_YN   BOOLEAN;
BEGIN
    HIDDEN_YN := hidden;
    FOR R IN (SELECT * FROM V_STD_PROF_INFO WHERE ROWNUM <= 10) LOOP
        DBMS_OUTPUT.PUT(R.NAME || ' | ');

        IF HIDDEN_YN THEN
            DBMS_OUTPUT.PUT(SUBSTR(R.SSN, 1, 8) || '******' || ' | ');
        ELSE
            DBMS_OUTPUT.PUT(R.SSN);
        END IF;

        DBMS_OUTPUT.PUT(R.ADDR);
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

EXEC PROC_STD_PRO_INFO;
EXEC PROC_STD_PRO_INFO(FALSE);


--- 매개변수값을 OUT 보내준다 (리턴의 의미) 
CREATE OR REPLACE 
PROCEDURE PROC_EMPLOYEES(TOP_N IN NUMBER :=3, TOTAL OUT NUMBER) IS
BEGIN
TOTAL := 0;
 FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= TOP_N) LOOP
    DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || '|' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    TOTAL := TOTAL + R.SALARY;
    END LOOP;
END;
/


VARIABLE RET_VAL NUMBER;
EXEC PROC_EMPLOYEES(5, :RET_VAL);
PRINT RET_VAL;
--EXEC는 외부에서 쓸때 

DECLARE
    RET_VAL NUMBER;

BEGIN
    PROC_EMPLOYEES(5, :RET_VAL); -- 아웃변수 앞에 :
    DBMS_OUTPUT.PUT_LINE(RET_VAL);
END;
/