select PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    coalesce(TLNO, 'NONE') TLNO
from PATIENT
where AGE <= 12 and GEND_CD like 'W'
order by 4 desc, 1