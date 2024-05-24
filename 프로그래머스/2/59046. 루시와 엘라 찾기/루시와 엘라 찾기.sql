SELECT animal_id,
    name,
    sex_upon_intake
FROM animal_ins
WHERE (name LIKE 'Lucy'
      OR name LIKE 'Ella'
      OR name LIKE 'Pickle'
      OR name LIKE 'Rogan'
      OR name LIKE 'Sabrina'
      OR name LIKE 'Mitty')
ORDER BY 1