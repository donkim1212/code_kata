select ANIMAL_INS.NAME,
    ANIMAL_INS.DATETIME
from ANIMAL_INS left join ANIMAL_OUTS on ANIMAL_INS.ANIMAL_ID=ANIMAL_OUTS.ANIMAL_ID
where ANIMAL_OUTS.DATETIME is NULL
order by 2
limit 3