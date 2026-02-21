/*
1. book_sales의 sales_data가 2022-01인 book_id
2. book의 author_id별, category별 매출액 > total_sales=book_sales.sales * book.price
3. 그러게 뽑은 매출액에 대해서 리스트 출력
4. author_id asc, category desc

*/
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(BS.SALES * B.PRICE) AS 'TOTAL_SALES'
FROM BOOK B
JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN BOOK_SALES BS
ON B.BOOK_ID = BS.BOOK_ID AND BS.SALES_DATE LIKE '2022-01%'
GROUP BY A.AUTHOR_ID, B.CATEGORY
ORDER BY A.AUTHOR_ID ASC, B.CATEGORY DESC;