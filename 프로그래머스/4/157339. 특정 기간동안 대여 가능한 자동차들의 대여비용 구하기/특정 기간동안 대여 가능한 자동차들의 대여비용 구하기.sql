/*
1. 테이블
- 대여중인 자동차 정보: car rental compny car
- 자동차 대여 기록: car rental company rental history
- 자동차 종류 별, 대여기간 종류 별, 할인 정책 정보: car rental company discount plan
2. 조건
- 자동차 종류 = 세단 또는 suv
- 대여 가능 기간 = 2022-11-01 ~ 2022-11-30
- 30일간 대여했을 때의 금액
- 대여 금액 = 50만원 이상 200만원 미만
3. 조회
- 자동자 id, 자동차 종류, 대여 금액 as fee
4. 정렬
- 대여금액 desc, 자동자 종류 asc, 자동차 id desc
*/
SELECT 
    CAR.CAR_ID, 
    CAR.CAR_TYPE, 
    FLOOR(CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR CAR
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN PLAN
    ON CAR.CAR_TYPE = PLAN.CAR_TYPE
    AND PLAN.DURATION_TYPE ='30일 이상'
WHERE 
    CAR.CAR_TYPE IN ('세단','SUV')
    /*그런데 하나라도 false인 차라면 결과적으로 false로 처리하는 방법 = select 1*/
    AND NOT EXISTS(
        SELECT 1
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY RENTAL
        WHERE CAR.CAR_ID = RENTAL.CAR_ID 
        AND RENTAL.START_DATE <= '2022-11-30'
        AND RENTAL.END_DATE >= '2022-11-01'
    )
    AND FLOOR(CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE)/100) >= 500000 
    AND FLOOR(CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE)/100) < 2000000
ORDER BY 
    FEE DESC, 
    CAR.CAR_TYPE ASC, 
    CAR.CAR_ID DESC;