SELECT MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (CAR_ID) IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= 20220801
        AND START_DATE < 20221101
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
) AND START_DATE >= 20220801
    AND START_DATE < 20221101
GROUP BY 1, 2
ORDER BY 1, 2 DESC