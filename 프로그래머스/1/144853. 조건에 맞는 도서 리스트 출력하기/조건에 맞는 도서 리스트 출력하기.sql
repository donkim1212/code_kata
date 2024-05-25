SELECT book_id,
    substring(published_date, 1, 10) PUBLISHED_DATE
FROM book
WHERE category like '인문'
    and published_date like '2021%'
ORDER BY 2