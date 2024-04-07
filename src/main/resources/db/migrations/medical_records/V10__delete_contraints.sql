

ALTER TABLE screening
drop constraint screening_patient_id_fkey;
ALTER TABLE screening
drop constraint screening_vital_signs_id_fkey;

ALTER TABLE screening
drop column patient_id;

ALTER TABLE screening
drop column vital_signs_id;

