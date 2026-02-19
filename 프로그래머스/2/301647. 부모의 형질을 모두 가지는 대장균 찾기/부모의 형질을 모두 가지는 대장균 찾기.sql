/*
1. 두 테이블을 조인하여 부모의 형질을 하나의 열에 넣는다 
    - ID와 PARENT ID 조인 후, select genotype?
2. ID별로 본인 형질이 & 부모형질 >0 인 행들만 출력하기

*/
SELECT CHILD.ID, CHILD.GENOTYPE, PARENT.GENOTYPE AS "PARENT_GENOTYPE"
FROM ECOLI_DATA CHILD
JOIN ECOLI_DATA PARENT 
ON CHILD.PARENT_ID = PARENT.ID -- 나의 부모랑 ID가 같은 개체를 찾자
WHERE CHILD.GENOTYPE & PARENT.GENOTYPE = PARENT.GENOTYPE -- 부모의 개체를 포함하는 경우만 추출
ORDER BY CHILD.ID ASC;