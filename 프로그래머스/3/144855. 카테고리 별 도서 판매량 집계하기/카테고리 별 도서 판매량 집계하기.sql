SELECT
    b.category,
    SUM(bs.SALES) AS total_sales
FROM
    BOOK AS b
JOIN
    BOOK_SALES AS bs ON b.book_id = bs.book_id
    AND bs.sales_date LIKE '2022-01%'
GROUP BY
    b.category
ORDER BY
    b.category