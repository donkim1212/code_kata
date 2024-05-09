select HOUR,
    count(HOUR) COUNT
from (
    select cast(time_format(DATETIME, '%H') as decimal) HOUR
    from ANIMAL_OUTS
) a
where HOUR > 8 and HOUR < 20
group by 1
order by 1