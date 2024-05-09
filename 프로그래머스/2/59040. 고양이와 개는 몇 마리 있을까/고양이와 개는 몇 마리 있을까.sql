select ANIMAL_TYPE,
    count(ANIMAL_TYPE)
from ANIMAL_INS
group by 1
having ANIMAL_TYPE like 'Cat'
    or ANIMAL_TYPE like 'Dog'
order by 1