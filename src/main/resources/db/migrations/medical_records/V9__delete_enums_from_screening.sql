ALTER TABLE screening
drop column gender;
ALTER TABLE screening
drop column blood_type;

ALTER TABLE patients
ADD column gender gender;
ALTER TABLE screening
ADD column blood_type blood_type;