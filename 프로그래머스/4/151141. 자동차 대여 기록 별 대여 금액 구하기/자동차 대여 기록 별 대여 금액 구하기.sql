WITH truck_plans AS (
    SELECT CAST(REPLACE(DURATION_TYPE,'일 이상', '') AS UNSIGNED) DURATION_TYPE,
        (100 - CAST(REPLACE(DISCOUNT_RATE, '%', '') AS UNSIGNED)) / 100 AS DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE LIKE '트럭'
    ORDER BY 1 DESC
),
trucks AS (
    SELECT rh.HISTORY_ID,
        c.DAILY_FEE,
        DATEDIFF(rh.END_DATE, rh.START_DATE) + 1 DURATION
    FROM CAR_RENTAL_COMPANY_CAR c
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
        ON c.CAR_ID = rh.CAR_ID
    WHERE c.CAR_TYPE LIKE '트럭'
)

SELECT t.HISTORY_ID,
    CAST(t.DAILY_FEE * t.DURATION * COALESCE((
        SELECT tp.DISCOUNT_RATE
        FROM truck_plans tp
        WHERE t.DURATION >= tp.DURATION_TYPE
        LIMIT 1
    ), 1) AS UNSIGNED) FEE
FROM trucks t
ORDER BY 2 DESC, 1 DESC