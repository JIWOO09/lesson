/*
    1. 재고관리를 위한 테이블 생성
        테이블 명 : PRODUCTS
        컬럼명  데이터타입      제약조건        비고
           PID  VARCHAR2(6)     Primary Key     문자와 숫자의 조합으로 만들어진 코드를 사용한다.
         PNAME  VARCHAR2(30)    NOT NULL        제품 이름
        AMOUNT  NUMBER          NOT NULL        제품의 단가
           CNT  NUMBER          NOT NULL        제품의 수량
        
*/


--  PRODUCTS 테이블 만들기
CREATE TABLE PRODUCTS (
           PID  VARCHAR2(6),     
         PNAME  VARCHAR2(30),  
        AMOUNT  NUMBER,         
           CNT  NUMBER          
);

-- 테이블 확인
SELECT * FROM ALL_ALL_TABLES
WHERE OWNER ='USER1'
AND TABLE_NAME = 'PRODUCTS';

-- 컬럼 확인
SELECT * FROM ALL_TAB_COLUMNS
WHERE TABLE_NAME ='PRODUCTS';

-- 코멘트 달기
--                테이블 명. 컬럼명
COMMENT ON COLUMN PRODUCTS.PID IS '문자와 숫자 조합';
COMMENT ON COLUMN PRODUCTS.PNAME IS '제품의 이름';
COMMENT ON COLUMN PRODUCTS.AMOUNT IS '제품이 단가';
COMMENT ON COLUMN PRODUCTS.CNT IS '제품의 수량';


-- 제약조건 걸기
ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_PID_PK PRIMARY KEY(PID);
ALTER TABLE PRODUCTS MODIFY PNAME CONSTRAINT PRODUCTS_PNAME_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY AMOUNT CONSTRAINT PRODUCTS_AMOUNT_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY CNT CONSTRAINT PRODUCTS_CNT_NN NOT NULL;


/*
테이블 명 : PROD_INOUT
        컬럼명  데이터타입      제약조건        비고
            ID  NUMBER          Primary Key     제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능을 활용한다.
        IN_OUT  CHAR(1)         CHECK           I:입고, O:출고 임을 구분하는 컬럼
           PID  VARCHAR2(6)     Foreign Key     PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분한다.
        AMOUNT  NUMBER          NOT NULL        입출고 시점의 제품 단가
           CNT  NUMBER          NOT NULL        입출고된 제품의 수량, DEFAULT(1)
         PRICE  NUMBER          NOT NULL        입출고 시점의 제품 전체 금액(단가 x 수량)
                                                입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                                출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                                소수점은 절삭한다.
    INOUT_DATE  DATE                            입출고 날짜, DEFAULT(SYSDATE)

*/

-- PROD_INOUT 테이블 만들기
CREATE TABLE PROD_INOUT(
        
            ID  NUMBER,          
        IN_OUT  CHAR(1),         
           PID  VARCHAR2(6),     
        AMOUNT  NUMBER,  
           CNT  NUMBER       DEFAULT(1),   
         PRICE  NUMBER,
         INOUT_DATE  DATE     DEFAULT(SYSDATE)    
);




-- 테이블 확인
SELECT * FROM ALL_ALL_TABLES
WHERE OWNER ='USER1'
AND TABLE_NAME = 'PROD_INOUT';

-- 컬럼 확인
SELECT * FROM ALL_TAB_COLUMNS
WHERE TABLE_NAME ='PROD_INOUT';

--코멘드 달기
COMMENT ON COLUMN PROD_INOUT.ID IS '제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능을 활용';
COMMENT ON COLUMN PROD_INOUT.IN_OUT IS 'I:입고, O:출고 임을 구분하는 컬럼';
COMMENT ON COLUMN PROD_INOUT.PID IS 'PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분';
COMMENT ON COLUMN PROD_INOUT.AMOUNT IS '입출고 시점의 제품 단가';
COMMENT ON COLUMN PROD_INOUT.CNT IS '입출고된 제품의 수량, DEFAULT(1';
COMMENT ON COLUMN PROD_INOUT.PRICE IS '입출고 시점의 제품 전체 금액(단가 x 수량)
                                                입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                                출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                                소수점은 절삭한다.';
COMMENT ON COLUMN PROD_INOUT.INOUT_DATE IS '입출고 날짜, DEFAULT(SYSDATE)';

-- 제약조건 걸기
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_ID_PK PRIMARY KEY(ID);
ALTER TABLE PROD_INOUT ADD CONSTRAINT IN_OUT_CK CHECK (IN_OUT IN ('I' , 'O'));
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_PID_FK FOREIGN KEY(PID) REFERENCES PRODUCTS(PID);
ALTER TABLE PROD_INOUT MODIFY AMOUNT CONSTRAINT PROD_INOUT_AMOUNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY CNT CONSTRAINT PROD_INOUT_CNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY PRICE CONSTRAINT PROD_INOUT_PNAME_NN NOT NULL;


SELECT * FROM PROD_INOUT;

CREATE SEQUENCE PROD_INOUT_SEQ;


/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - PRODUCTS 테이블에는 다음의 데이터를 추가한다.
            PID:A00001  PNAME:투명박스       AMOUNT:15,000   CNT:10
            PID:A00002  PNAME:텀블러         AMOUNT:10,000   CNT:15
            PID:A00003  PNAME:마스크(10개입) AMOUNT:5,000    CNT:20
            PID:A00004  PNAME:투명테이프     AMOUNT:1,000    CNT:30
            PID:A00005  PNAME:종이컵(355ml)  AMOUNT:2,000    CNT:40

*/

INSERT INTO PRODUCTS (PID, PNAME, AMOUNT, CNT) VALUES('A00001', '투명박스', 15000, 10);
INSERT INTO PRODUCTS (PID, PNAME, AMOUNT, CNT) VALUES('A00002', '텀블러', 10000, 15);
INSERT INTO PRODUCTS (PID, PNAME, AMOUNT, CNT) VALUES('A00003', '마스크(10개입)', 5000, 20);
INSERT INTO PRODUCTS (PID, PNAME, AMOUNT, CNT) VALUES('A00004', '투명테이프', 1000, 30);
INSERT INTO PRODUCTS (PID, PNAME, AMOUNT, CNT) VALUES('A00005', '종이컵(355ml)', 2000, 40);

SELECT * FROM PRODUCTS;

/*
    - PROD_INOUT과 PRODUCTS 테이블에는 다음 설명에 맞게 데이터가 추가 및 변경될 수 있게 한다.
            투명박스 2개를 2021년 01월 02일에 출고하였다.
            텀블러 1개를 2021년 01월 03일에 출고하였다.
            마스크 10개를 2021년 01월 05일에 출고하였다.
            종이컵 5개를 2021년 01월 12일에 출고하였다.
            마스크 20개를 2021년 01월 15일에 입고하였다.
            투명테이프 2개를 2021년 01월 17일에 출고하였다.
            종이컵 10개를 2021년 01월 21일에 출고하였다.
            투명박스 7개를 2021년 01월 25일에 입고하였다.
*/


-- 초기데이터 입력 
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 2, 0, TO_DATE('20210102', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '텀블러')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '텀블러')
                            , 1, 0, TO_DATE('20210103', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 10, 0, TO_DATE('20210105', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 5, 0, TO_DATE('20210112', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 20, 0, TO_DATE('20210115', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , 2, 0, TO_DATE('20210117', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 10, 0, TO_DATE('20210121', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 7, 0, TO_DATE('20210125', 'yyyymmdd'));

UPDATE PROD_INOUT
   SET PRICE = (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
 WHERE IN_OUT = 'I';

UPDATE PROD_INOUT
   SET PRICE = (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
 WHERE IN_OUT = 'O';

UPDATE PROD_INOUT
   SET PRICE = (CASE WHEN IN_OUT = 'I' THEN
                         (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
                     WHEN IN_OUT = 'O' THEN
                         (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
                 END);

SELECT * FROM PROD_INOUT;
/*
    3. 1월 1달간 출고 내역을 조회하시오.
        제품코드    제품명      단가        수량        금액
        A00001      투명박스    15,000      2           33,000
        A00002      텀블러      10,000      1           11,000
        A00003      마스크      5,000       10          55,000
        ....
*/

-- JOIN
SELECT A.PID,
       B.PNAME,
       B.AMOUNT,
       SUM(A.CNT) AS 총수량,
       SUM(A.PRICE) AS 총금액
FROM PROD_INOUT A JOIN PRODUCTS B
ON A.PID = B.PID
WHERE A.IN_OUT = 'O'
AND TO_CHAR(INOUT_DATE, 'YYYYMM') = '202101'
GROUP BY A.PID, B.PNAME, B.AMOUNT;

-- VIEW

CREATE OR REPLACE VIEW V_PROD_IN_TOTAL_LIST AS 
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS 년,
       EXTRACT(MONTH FROM INOUT_DATE) AS 월,
       A.PID AS 제품코드,
       B.PNAME AS 제품명,
       B.AMOUNT AS 단가,
       TO_CHAR(SUM(A.CNT), '999,999,999') AS 총수량,
       TO_CHAR(SUM(A.PRICE),'999,999,999') AS 총금액
FROM PROD_INOUT A JOIN PRODUCTS B
ON A.PID = B.PID
WHERE A.IN_OUT = 'I'
AND TO_CHAR(INOUT_DATE, 'YYYYMM') = '202101'
GROUP BY EXTRACT(YEAR FROM INOUT_DATE),
       EXTRACT(MONTH FROM INOUT_DATE), A.PID, B.PNAME, B.AMOUNT;

CREATE OR REPLACE VIEW V_PROD_OUT_TOTAL_LIST AS 
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS 년,
       EXTRACT(MONTH FROM INOUT_DATE) AS 월,
       A.PID AS 제품코드,
       B.PNAME AS 제품명,
       B.AMOUNT AS 단가,
       TO_CHAR(SUM(A.CNT), '999,999,999') AS 총수량,
       TO_CHAR(SUM(A.PRICE),'999,999,999') AS 총금액
FROM PROD_INOUT A JOIN PRODUCTS B
ON A.PID = B.PID
WHERE A.IN_OUT = 'I'
AND TO_CHAR(INOUT_DATE, 'YYYYMM') = '202101'
GROUP BY EXTRACT(YEAR FROM INOUT_DATE),
       EXTRACT(MONTH FROM INOUT_DATE), A.PID, B.PNAME, B.AMOUNT;


CREATE OR REPLACE VIEW V_PROD_INOUT_TOTAL_LIST AS
    SELECT EXTRACT(YEAR FROM INOUT_DATE) AS y
         , EXTRACT(MONTH FROM INOUT_DATE) AS m
         , A.PID AS 제품코드
         , B.PNAME AS 제품명
         , TO_CHAR(SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)), '999,999') AS 입고량
         , TO_CHAR(SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)), '999,999') AS 출고량
      FROM PROD_INOUT A JOIN PRODUCTS B
        ON A.PID = B.PID
     GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE), A.PID, B.PNAME
    UNION
    SELECT EXTRACT(YEAR FROM INOUT_DATE) AS y
         , EXTRACT(MONTH FROM INOUT_DATE) AS m
         , '총합' AS 제품코드
         , NULL AS 제품명
         , TO_CHAR(SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)), '999,999') AS 입고량
         , TO_CHAR(SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)), '999,999') AS 출고량
      FROM PROD_INOUT A JOIN PRODUCTS B
        ON A.PID = B.PID
     GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE);


SELECT 제품코드, 제품명, 단가, 총수량, 총금액 FROM V_PROD_IN_TOTAL_LIST WHERE 년 = 2021 AND 월 = 1;
SELECT 제품코드, 제품명, 단가, 총수량, 총금액 FROM V_PROD_OUT_TOTAL_LIST WHERE 년 = 2021 AND 월 = 1;
SELECT 제품코드, 제품명, 입고량, 출고량 FROM V_PROD_INOUT_TOTAL_LIST WHERE y = 2021 AND m = 1;

/*
    4. 1월 1달간의 입/출고 내역을 다음과 같이 나오도록 조회하시오.
        제품코드    제품명      입고량      출고량
        A00001      투명박스    7           2
        A00002      텀블러      0           1
        A00003      마스크      20          10
        ...
        총합                    xx          xx
*/

SELECT A.PID AS 제품코드,
       B.PNAME AS 제품명,
       TO_CHAR(SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)), '999,999' AS 입고량,
       TO_CHAR(SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)), '999,999' AS 출고량
FROM PROD_INOUT A JOIN PRODUCTS B
ON A.PID = B.PID
WHERE A.IN_OUT = 'O'
AND TO_CHAR(INOUT_DATE, 'YYYYMM') = '202101'
GROUP BY A.PID, B.PNAME, ROLLUP;


/*
    5. 3번, 4번 조회 쿼리를 VIEW 로 만들어본다.
*/

/*
    6. 5번에서 생성한 VIEW 를 프로시져로 만들어서 월별 또는 년도별로도 조회할 수 있게 만들어본다.
*/

/*
    7. 제품을 출고할 때 PRODUCTS 에 기록된 수량도 같이 반영이 될 수 있도록 프로시저를 만들어 동작시킨다.
       단 수량이 부족하면 출고 작업이 이루어지지 않게 ROLLBACK 을 동작시키는 것으로 한다.
*/

CREATE OR REPLACE PROCEDURE PROC_PROD_OUT(I_PID IN VARCHAR2. I_PNAME IN VARCHAR2. I_CNT NUMBER)
IS
    VAR_COUNT   NUMBER;
BEGIN
    SELECT CNT
    INTO VAR_COUNT
    FROM PRODUCTS
    WHERE PID = 'A00001'
    AND PNAME = '투명박스';
    IF VAR_COUNT >= I_CNT THEN
        DBMS_OUTPUT.PUT_LINE('수량이 충분합니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('수량이 부족합니다')
    ELSE IF;
END;
/

EXEC PROC_PROD_OUT('A00001', '투명박스', 3);
EXEC PROC_PROD_OUT('A00002', '텀블러', 2);
EXEC PROC_PROD_OUT('A00003', '마스크', 10);

/*
    8. 제품 출고 단가는 PRODUCTS 테이블의 금액을 기준으로 사용하지만 입고의 경우 별도의 입고 단가액을 작성하면
       PRODUCTS 테이블의 금액이 변경되게 할 것이다. 그리고 기존에 존재하지 않은 제품을 입고하는 경우에도 자동
       적으로 PRODUCT 테이블에 새로운 제품 정보가 저장되도록 할 것이다.
       위에서 설명하는 내용대로 동작할 수 있는 프로서저를 만들어 제고관리가 이루어 질 수 있도록 하시오.
       PROC_PROD_IN('제품코드', '제품명', 수량, 단가) 형식으로 사용
            A. 기존에 존재하는 제품코드, 제품명의 경우 해당 제품에 대한 수량을 입력한 수량만큼 증가시킨다.
            B. 기존에 존재하는 제품코드, 제품명이나 단가가 입력된 단가와 다른 경우 입력된 단가로 수정한다.
            C. 기존에 존재하지 않는 제품코드인 경우 새로운 제품으로 추가한다.
            D. 기존에 존재하는 제품코드이나 제품명이 다른 경우 어떠한 작업도 수행하지 않는다.
*/