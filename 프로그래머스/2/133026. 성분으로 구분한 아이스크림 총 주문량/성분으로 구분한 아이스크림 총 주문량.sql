SELECT ii.ingredient_type, 
    sum(fh.total_order) TOTAL_ORDER
FROM first_half as fh
LEFT JOIN icecream_info as ii
    on fh.flavor=ii.flavor
GROUP by 1
