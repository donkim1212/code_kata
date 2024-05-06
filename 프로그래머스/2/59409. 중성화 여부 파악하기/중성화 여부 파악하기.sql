select ANIMAL_ID,
    NAME,
    if(SEX_UPON_INTAKE like "Sp%" or SEX_UPON_INTAKE like "Neu%", "O", "X") "중성화"
from ANIMAL_INS