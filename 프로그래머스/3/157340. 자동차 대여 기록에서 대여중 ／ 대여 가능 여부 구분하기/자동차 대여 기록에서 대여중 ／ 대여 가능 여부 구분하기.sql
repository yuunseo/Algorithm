/*
어느 날에 대여 중이다 -> 대여 종료일보다 작고, 대여 시작일보다 크다
대여 중이지 않다 -> 대여 종료일이 더 이르다(적다)

*/
SELECT H.CAR_ID, 
CASE
    WHEN MAX('2022-10-16' BETWEEN H.START_DATE AND H.END_DATE) = 1 
    THEN "대여중"
    ELSE "대여 가능"
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
GROUP BY H.CAR_ID
ORDER BY H.CAR_ID DESC;