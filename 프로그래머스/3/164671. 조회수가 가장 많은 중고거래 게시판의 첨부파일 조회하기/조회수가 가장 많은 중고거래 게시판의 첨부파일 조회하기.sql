select concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as FILE_PATH
from used_goods_file
where board_id = (select BOARD_ID
from USED_GOODS_BOARD
order by views desc
limit 1)
order by file_id desc;
