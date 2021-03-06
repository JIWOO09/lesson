/*
    1. 가계부 작성을 위한 테이블 생성
        테이블 명 : ACCOUNTS
        컬럼명   데이터타입      제약조건       비고
            ID   NUMBER          Primary Key    Sequence를 사용하여 1씩 자동증가 되도록 한다.
        AMOUNT   NUMBER          NOT NULL       DEFAULT 를 사용하여 기본값으로 0 이 사용되게 한다.
      ACC_TYPE   CHAR(1)         CHECK          I 는 입금, O 는 출금 내역으로 구분한다.
      ACC_DATE   DATE            NOT NULL       입출금 날짜를 기록하기 위한 컬럼이다.
       HISTORY   CHAR(3)         Foreign Key    입출금 내역을 위한 컬럼으로 HISTORYS 테이블을 참조한다.
*/
CREATE TABLE ACCOUNTS (
      ID            NUMBER
    , AMOUNT        NUMBER      DEFAULT(0)
    , ACC_TYPE      CHAR(1)
    , ACC_DATE      DATE        DEFAULT(SYSDATE)
    , HISTORY       CHAR(3)
);
COMMENT ON COLUMN ACCOUNTS.ID IS 'ACCOUNTS 테이블의 데이터를 식별하기 위한 용도로 사용하는 ID 컬럼';
COMMENT ON COLUMN ACCOUNTS.AMOUNT IS '입/출금액을 저장하기 위한 컬럼';
COMMENT ON COLUMN ACCOUNTS.ACC_TYPE IS '입금/출금을 구분하기 위한 컬럼으로 I는 입금, O 는 출금으로 구분한다.';
COMMENT ON COLUMN ACCOUNTS.ACC_DATE IS '입금/출금 일자용 컬럼으로 기본값으로는 현재날짜가 저장된다.';
COMMENT ON COLUMN ACCOUNTS.HISTORY IS '입금/출금의 상세 내역을 위한 컬럼으로 HISTORYS 테이블의 데이터를 참조한다.';

ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_ID_PK PRIMARY KEY(ID);
ALTER TABLE ACCOUNTS MODIFY AMOUNT CONSTRAINT ACCOUNTS_AMOUNT_NN NOT NULL;
ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_ACC_TYPE_CK CHECK(ACC_TYPE IN ('I', 'O'));
ALTER TABLE ACCOUNTS MODIFY ACC_DATE CONSTRAINT ACCOUNTS_ACC_DATE_NN NOT NULL;
/*
        테이블 명 : HISTORYS
        컬럼명   데이터타입      제약조건        비고
            ID   CHAR(3)         Primary Key     문자와 숫자의 조합으로 만들어진 입출금 코드를 사용한다.
        H_TYPE   VARCHAR2(150)   NOT NULL        입출금 내역을 한글 기준 50자 내로 작성
*/
CREATE TABLE HISTORYS (
      ID        CHAR(3)
    , H_TYPE    VARCHAR2(150)
);
COMMENT ON COLUMN HISTORYS.ID IS 'HISTORYS 테이블의 데이터를 식별하기 위한 용도로 사용하는 ID 컬럼';
COMMENT ON COLUMN HISTORYS.H_TYPE IS '입/출금 내역의 상세정보 종류를 기록하기 위한 컬럼';

ALTER TABLE HISTORYS ADD CONSTRAINT HISTORYS_ID_PK PRIMARY KEY(ID);
ALTER TABLE HISTORYS MODIFY H_TYPE CONSTRAINT HISTORYS_H_TYPE_NN NOT NULL;
ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_HISTORY_FK FOREIGN KEY(HISTORY) REFERENCES HISTORYS(ID);

CREATE SEQUENCE ACCOUNTS_ID_SEQ;
/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - HISTORYS 테이블에는 다음의 데이터를 추가한다.
            ID:A01,     H_TYPE:급여   | ID:A02,     H_TYPE:불로소득
            ID:A03,     H_TYPE:통신비 | ID:A04,     H_TYPE:교통비
            ID:A05,     H_TYPE:주유비 | ID:A06,     H_TYPE:식비
            ID:A07,     H_TYPE:여가비 | ID:A08,     H_TYPE:의류구입

        - ACCOUNTS 테이블에는 다음의 데이터를 추가한다.
            2021년 01월 05일에 급여 3,000,000 원이 들어왔다.
            2021년 01월 16일에 여가비로 150,000 원을 사용하였다.
            2021년 01월 25일에 통신비로 125,000 원 지출되었다.
            2021년 01월 25일에 교통비로 85,200 원이 지출되었다.
            2021년 01월 한달간 매 주일(5일) 식비로 6,500원이 지출되었다.
*/
INSERT INTO HISTORYS VALUES('A01', '급여');
INSERT INTO HISTORYS VALUES('A02', '불로소득');
INSERT INTO HISTORYS VALUES('A03', '통신비');
INSERT INTO HISTORYS VALUES('A04', '교통비');
INSERT INTO HISTORYS VALUES('A05', '주유비');
INSERT INTO HISTORYS VALUES('A06', '식비');
INSERT INTO HISTORYS VALUES('A07', '여가비');
INSERT INTO HISTORYS VALUES('A08', '의류구입');

INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 3000000, 'I', TO_DATE('20210105', 'yyyymmdd'), 'A01');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 150000, 'O', TO_DATE('20210116', 'yyyymmdd'), 'A07');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 125000, 'O', TO_DATE('20210125', 'yyyymmdd'), 'A03');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 85200, 'O', TO_DATE('20210125', 'yyyymmdd'), 'A04');

INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210101', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210104', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210105', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210106', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210107', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210108', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210111', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210112', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210113', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210114', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210115', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210118', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210119', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210120', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210121', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210122', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210125', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210126', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210127', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210128', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210129', 'yyyymmdd'), 'A06');

-- DECLARE
-- BEGIN
-- END;
-- /
-- SELECT * FROM ACCOUNTS;

/*
    3. 1월 1달간 지출내역을 조회하시오.(항목별 지출내역과 총합계가 같이 조회되도록 한다.)
*/
SELECT DECODE(H_TYPE, NULL, '총합계', H_TYPE) AS 지출항목
     , SUM(AMOUNT) AS 지출내역
  FROM ACCOUNTS A JOIN HISTORYS B
    ON A.HISTORY = B.ID
 WHERE ACC_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                    AND TO_DATE('20210131', 'yyyymmdd')
   AND ACC_TYPE = 'O'
 GROUP BY ROLLUP(H_TYPE);

/*
    4. 1월 1달간의 입/출금 내역을 다음과 같이 나오도록 조회하시오.
        내역        입금액      출금액
        급여        3,000,000
        통신비                  125,000
        교통바                  85,200
        여가비                  150,000
        ...
        총합        3,000,000   xxx,xxx
*/
SELECT DECODE(H_TYPE, NULL, '총합', H_TYPE) AS 내역
     , TO_CHAR(SUM(DECODE(ACC_TYPE, 'I', AMOUNT, NULL)), '999,999,999') AS 입금액
     , TO_CHAR(SUM(DECODE(ACC_TYPE, 'O', AMOUNT, NULL)), '999,999,999') AS 출금액
  FROM ACCOUNTS A JOIN HISTORYS B
    ON A.HISTORY = B.ID
 WHERE TO_CHAR(ACC_DATE, 'yyyymm') = '202101'
 GROUP BY ROLLUP(H_TYPE);