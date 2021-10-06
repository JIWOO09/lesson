
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;

/*
 아직 부서 배정을 받지 못한 직원을 찾아서 적절한 부서로 배정 받을 수 있는 프로시저를 생성한다.
  - 부서는 없지만 담당 관리직원이 있는 경우 관리직원의 부서로 배정한다.
  - 담당 관리 직원도 없는 경우 직무코드에 맞는 부서로 배정한다.
  - 작업이 완료 된 후에는 배정이 완료된 인원 수를 알 수 있도록 메세지를 출력한다.
*/

CREATE OR REPLACE PROCEDURE 부서배정(count OUT NUMBER)
IS
    -- 초기 변수 선언
    DEPT_CODE   EMPLOYEES.DEPARTMENT_ID%TYPE;
    CNT         NUMBER := 0;
    no_data     EXCEPTION;
    -- 사용자 정의 EXCEPTION
BEGIN
    -- 부서가 없는 직원들을 반복적으로 조회
    FOR rec IN (SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NULL) LOOP
        CNT := CNT + 1;
        -- 부서가 없는 직원중에 관리자 ID가 있는지 있으면 조회 
        IF rec.MANAGER_ID IS NOT NULL THEN
            SELECT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM EMPLOYEES
             WHERE EMPLOYEE_ID = rec.MANAGER_ID;
             --관리자 ID로 직원을 찾는다. 있으면 INTO DEPT_CODE에 저장
        ELSE
            SELECT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM DEPARTMENTS
             WHERE DEPARTMENT_NAME = (SELECT SUBSTR(JOB_TITLE, 1, INSTR(JOB_TITLE, ' ') - 1)
                                        FROM JOBS
                                       WHERE JOB_ID = rec.JOB_ID);
        END IF;

        IF DEPT_CODE IS NULL THEN
            RAISE no_data;
        ELSE
            UPDATE EMPLOYEES
               SET DEPARTMENT_ID = DEPT_CODE
             WHERE EMPLOYEE_ID = rec.EMPLOYEE_ID;

            DEPT_CODE := NULL;
        END IF;
    END LOOP;

    count := CNT;
    -- COMMIT;
    ROLLBACK;
EXCEPTION
    WHEN no_data THEN
        DBMS_OUTPUT.PUT_LINE('작업 중 문제가 발생하여 롤백하였습니다.');
        ROLLBACK;
END;
/

SELECT * FROM EMPLOYEES;
SELECT * FROM JOB;
SELECT * DEPARTMENTS;




/*
 KOR_DATE 함수를 만들어서 모든 날짜 관련 데이터는 XXXX년 XX월 XX일로 변환 될 수 있는 함수를 생성한다.

*/

CREATE OR REPLACE FUNCTION KOR_DATE(d DATE) RETURN VARCHAR
IS
BEGIN
    RETURN TO_CHAR(d, 'yyyy"년" mm"월" dd"일"');
END;
/


SELECT KOR_DATE(HIRE_DATE)
  FROM EMPLOYEES;