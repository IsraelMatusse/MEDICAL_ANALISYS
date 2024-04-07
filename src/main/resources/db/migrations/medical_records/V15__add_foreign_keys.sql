ALTER TABLE screening
ALTER COLUMN id TYPE varchar(255);
ALTER TABLE screening
ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE screening
ADD CONSTRAINT screenings_patient_id_fkey
FOREIGN KEY (patient_id)
REFERENCES patients(id);

ALTER TABLE screening
ADD CONSTRAINT screenings_vital_signs_id_fkey
FOREIGN KEY (vital_signs_id)
REFERENCES vital_signs(id);
