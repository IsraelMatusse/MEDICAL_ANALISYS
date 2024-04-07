ALTER TABLE patients
ALTER COLUMN id TYPE varchar(255);
ALTER TABLE patients
ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE vital_signs
ALTER COLUMN id TYPE varchar(255);
ALTER TABLE vital_signs
ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE screening
ADD COLUMN patient_id varchar(255);
ALTER TABLE screening
ADD COLUMN vital_signs_id varchar(255);




