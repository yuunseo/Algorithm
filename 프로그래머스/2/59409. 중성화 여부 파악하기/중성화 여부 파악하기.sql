-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, 
    CASE
        WHEN ANIMAL_ID IN (
            SELECT ANIMAL_ID
            FROM ANIMAL_INS
            WHERE SEX_UPON_INTAKE LIKE '%Neutered%' 
            OR SEX_UPON_INTAKE LIKE'%Spayed%')
        THEN 'O'
        ELSE 'X'
    END AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;