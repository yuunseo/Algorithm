-- 1. 1번형질: 1
--    2번형질: 2
--    3번형질: 4
--    4번형질: 8
SELECT COUNT(*) AS "COUNT"
FROM ECOLI_DATA
WHERE GENOTYPE & 5 > 0 AND GENOTYPE & 2 = 0;