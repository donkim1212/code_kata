select count(AGE)
from USER_INFO
where AGE between 20 and 29
    and JOINED like '2021%'