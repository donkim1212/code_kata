select substring(PRODUCT_CODE, 1,2) CATEGORY,
    count('CATEGORY') PRODUCTS
from PRODUCT
group by 1
order by 1