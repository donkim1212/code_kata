SELECT CAR_ID,
    MAX(IF(20221016 BETWEEN START_DATE AND END_DATE, '대여중', '대여 가능')) AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY 1
ORDER BY 1 DESC