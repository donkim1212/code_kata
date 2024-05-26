SELECT *
FROM (
    SELECT ugu.USER_ID,
        ugu.NICKNAME,
        sum(if(ugb.status like 'DONE', ugb.price, 0)) TOTAL_SALES
    FROM used_goods_board as ugb
    LEFT JOIN used_goods_user as ugu
    ON ugb.writer_id=ugu.user_id
    GROUP BY 1
    ) a
WHERE TOTAL_SALES >= 700000
ORDER BY 3