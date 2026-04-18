-- 코드를 입력하세요
select 
    user_id, 
    nickname, 
    concat(city,' ', street_address1,' ', street_address2) as 전체주소,
    CONCAT(
        SUBSTRING(tlno,1,3), '-', 
        SUBSTRING(tlno,4,4), '-', 
        SUBSTRING(tlno,8,4)
    ) AS 전화번호
from used_goods_user
where user_id in (SELECT writer_id
from USED_GOODS_BOARD
group by writer_id having count(BOARD_ID) >= 3)
order by user_id desc;