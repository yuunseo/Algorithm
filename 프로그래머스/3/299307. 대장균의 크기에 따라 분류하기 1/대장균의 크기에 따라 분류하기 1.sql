-- 1. size-of-colony의 값의 범위에 따라 그룹화
-- 2. 그룹화할 때,그룹명을 지정
-- 3. ID 오름차순으로 정렬
SELECT ID, 
        CASE
           WHEN SIZE_OF_COLONY <= 100 THEN "LOW"
           WHEN 100 < SIZE_OF_COLONY AND SIZE_OF_COLONY <=1000 THEN "MEDIUM"
           ELSE "HIGH"
        END AS "SIZE"
FROM ECOLI_DATA
ORDER BY ID ASC;