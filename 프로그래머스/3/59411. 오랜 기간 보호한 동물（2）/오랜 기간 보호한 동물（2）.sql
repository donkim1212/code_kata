select ANIMAL_INS.ANIMAL_ID,
    ANIMAL_INS.NAME
from ANIMAL_INS inner join ANIMAL_OUTS on ANIMAL_INS.ANIMAL_ID=ANIMAL_OUTS.ANIMAL_ID
order by ANIMAL_INS.DATETIME - ANIMAL_OUTS.DATETIME
limit 2