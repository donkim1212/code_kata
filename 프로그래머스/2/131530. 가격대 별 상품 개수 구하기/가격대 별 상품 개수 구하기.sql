SELECT floor(price / 10000) * 10000 PRICE_GROUP,
    count(product_id) PRODUCTS
FROM PRODUCT
GROUP BY 1
ORDER BY 1