select ANIMAL_TYPE, coalesce(NAME, "No name") "NAME", SEX_UPON_INTAKE
from ANIMAL_INS
order by ANIMAL_ID