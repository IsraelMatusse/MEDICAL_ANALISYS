-- Adiciona a coluna 'neighboor_hood'
ALTER TABLE patients
ADD COLUMN neighboor_hood varchar(255) NULL;

-- Remove a coluna 'address'
ALTER TABLE patients
DROP COLUMN address;