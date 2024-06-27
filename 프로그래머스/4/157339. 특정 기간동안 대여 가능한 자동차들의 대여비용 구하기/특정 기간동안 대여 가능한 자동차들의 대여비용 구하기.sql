WITH crcdp AS (
    SELECT CAR_TYPE,
        REPLACE(DISCOUNT_RATE, '%', '') DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE (CAR_TYPE LIKE '세단'
        OR CAR_TYPE LIKE 'SUV')
        AND DURATION_TYPE LIKE '3%'
),
crcrh AS (
    SELECT DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE >= 20221101
)

SELECT crcc.CAR_ID,
    crcc.CAR_TYPE,
    crcc.DAILY_FEE * 30 * (100 - crcdp.DISCOUNT_RATE) / 100 AS FEE
FROM CAR_RENTAL_COMPANY_CAR crcc
LEFT JOIN crcrh
ON crcc.CAR_ID = crcrh.CAR_ID
INNER JOIN crcdp
ON crcc.CAR_TYPE = crcdp.CAR_TYPE
WHERE crcrh.CAR_ID IS NULL
GROUP BY 1
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY 3 DESC, 2, 1 DESC