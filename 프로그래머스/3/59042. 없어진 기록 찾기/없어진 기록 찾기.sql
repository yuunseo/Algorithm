/*
1. 입양을 간 기록 테이블, 동물 정보 테이블
2. 입양 간 친구 중 보호소에 들어온 기록이 없는 친구 id, name 조회하기

1. outs에다가 right join하고 
2. join 테이블에서 ins.datetime이 없고 and outs.datetime은 있는 id 조회
*/
SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_INS INS
RIGHT JOIN ANIMAL_OUTS OUTS
ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.DATETIME IS NULL
ORDER BY OUTS.ANIMAL_ID;