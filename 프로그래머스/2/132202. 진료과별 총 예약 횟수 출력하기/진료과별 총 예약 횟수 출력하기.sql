select MCDP_CD '진료과 코드',
    count(APNT_YMD) '5월예약건수'
from APPOINTMENT
where date_format(APNT_YMD, '%m') like '05'
group by 1
order by 2 , 1