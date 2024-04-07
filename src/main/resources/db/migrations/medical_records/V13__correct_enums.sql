ALTER TABLE screening
drop column blood_type;

ALTER TABLE patients
ADD column blood_type blood_type;