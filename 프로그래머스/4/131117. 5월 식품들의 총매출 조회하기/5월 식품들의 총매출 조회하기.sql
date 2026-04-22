-- 코드를 입력하세요
SELECT O.product_id, P.product_name, sum(O.amount * P.price) as TOTAL_SALES
from food_order O
join food_product P
on O.product_id = P.product_id
and year(O.PRODUCE_DATE) = 2022 
and month(O.PRODUCE_DATE) = 5
group by O.product_id
order by TOTAL_SALES desc, O.product_Id asc;