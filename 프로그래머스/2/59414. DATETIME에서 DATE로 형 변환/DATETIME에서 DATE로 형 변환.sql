select ANIMAL_ID,
    NAME,
    date_format(date(DATETIME),'%Y-%m-%d') '날짜'
from ANIMAL_INS
order by 1