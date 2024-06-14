SELECT ri.REST_ID,
    ri.REST_NAME,
    ri.FOOD_TYPE,
    ri.FAVORITES,
    ri.ADDRESS,
    ROUND(AVG(rr.REVIEW_SCORE), 2) SCORE
FROM REST_INFO ri
JOIN REST_REVIEW rr
ON ri.REST_ID=rr.REST_ID
WHERE ri.ADDRESS LIKE '서울%'
GROUP BY 1
ORDER BY 6 DESC, 4 DESC