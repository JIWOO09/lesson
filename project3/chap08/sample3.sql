
-- FUNCTION

CREATE OR REPLACE FUNCTION CALC_YEAR_SALARY(SALARY NUMBER) RETURN NUMBER 
IS

BEGIN
    RETURN SALARY * 12;
END;
/

SELECT CALC_YEAR_SALARY(5000) FROM DUAL;

-------------------------------------------------------------

CREATE OR REPLACE FUNCTION CALC_YEAR_SALARY(SALARY NUMBER, COMMISSION NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN SALARY * (1 + COMMISSION) * 12;
END;
/

SELECT CALC_YEAR_SALARY(5000, 0.05) FROM DUAL;
SELECT EMPLOYEE_ID,
    SALARY,
    CALC_YEAR_SALARY(SALARY, NVL(COMMISSION_PCT,0)) AS 연봉
FROM EMPLOYEES;

---------------------------------------------------------------

CREATE OR REPLACE FUNCTION FULL_NAME(FIRST_NAME VARCHAR2, LAST_NAME VARCHAR2) RETURN VARCHAR2
IS
BEGIN
    RETURN FIRST_NAME || ' ' || LAST_NAME;
END;
/

SELECT EMPLOYEE_ID,
    FULL_NAME(FIRST_NAME, LAST_NAME) AS 이름,
    SALARY,
    CALC_YEAR_SALARY(SALARY, NVL(COMMISSION_PCT,0)) AS 연봉
FROM EMPLOYEES;

-----------------------------------------------------------------

CREATE OR REPLACE FUNCTION FULL_NAME(FIRST_NAME VARCHAR2, LAST_NAME VARCHAR2) RETURN VARCHAR2
IS
BEGIN
    RETURN FIRST_NAME || ' ' || LAST_NAME;
END;
/

SELECT EMPLOYEE_ID,
    FULL_NAME(FIRST_NAME, LAST_NAME) AS 이름,
    SALARY,
    CALC_YEAR_SALARY(SALARY, NVL(COMMISSION_PCT,0)) AS 연봉
FROM EMPLOYEES;

-------------------------------------------------------------------


SELECT EMPLOYEE_ID
     , FULL_NAME(FIRST_NAME, LAST_NAME) AS "이름"
     , SALARY
     , CALC_YEAR_SALARY(SALARY, NVL(COMMISSION_PCT, 0)) AS "연봉"
  FROM EMPLOYEES;

CREATE OR REPLACE FUNCTION CONVERT_DEPT(dept_code NUMBER) RETURN VARCHAR2
IS
    DEPT_NAME   DEPARTMENTS.DEPARTMENT_NAME%TYPE;
BEGIN
    SELECT DEPARTMENT_NAME
      INTO DEPT_NAME
      FROM DEPARTMENTS
     WHERE DEPARTMENT_ID = dept_code;
    RETURN DEPT_NAME;
END;
/

SELECT EMPLOYEE_ID
     , FULL_NAME(FIRST_NAME, LAST_NAME) AS "이름"
     , CONVERT_DEPT(DEPARTMENT_ID) AS "부서명"
     , SALARY
     , CALC_YEAR_SALARY(SALARY, NVL(COMMISSION_PCT, 0)) AS "연봉"
  FROM EMPLOYEES;

SELECT * FROM USER_SOURCE WHERE NAME = 'CONVERT_DEPT';