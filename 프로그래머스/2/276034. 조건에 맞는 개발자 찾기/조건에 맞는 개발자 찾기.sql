-- 1. 두 테이블을 조인 2. code가 python 혹은 c#인 행들만 남기기 3. 그 테이블과 조인하기 --

SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S
ON D.SKILL_CODE & S.CODE > 0
WHERE S.NAME IN ("Python","C#")
ORDER BY D.ID ASC;

