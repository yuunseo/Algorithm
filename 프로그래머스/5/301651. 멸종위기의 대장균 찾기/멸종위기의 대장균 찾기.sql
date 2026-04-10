WITH RECURSIVE ecoli AS (
    -- 1세대
    SELECT 
        id,
        parent_id,
        1 AS generation
    FROM ecoli_data
    WHERE parent_id IS NULL
    
    UNION ALL
    
    -- 다음 세대
    SELECT 
        c.id,
        c.parent_id,
        p.generation + 1
    FROM ecoli_data c
    JOIN ecoli p
        ON c.parent_id = p.id 
)

SELECT COUNT(*) AS COUNT, generation
FROM ecoli
WHERE id NOT IN (
    SELECT parent_id 
    FROM ecoli_data 
    WHERE parent_id IS NOT NULL
)
GROUP BY generation
ORDER BY generation ASC;