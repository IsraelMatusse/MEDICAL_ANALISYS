CREATE TABLE IF NOT EXISTS screenings (
    id varchar(255) PRIMARY KEY DEFAULT gen_random_uuid(),
    screening_date date,
    main_complaint text,
    observations text,

    patient_id varchar(255) NOT NULL,
    vital_signs_id varchar(255) NOT NULL,

    CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_vital_signs FOREIGN KEY (vital_signs_id) REFERENCES vital_signs(id)
);