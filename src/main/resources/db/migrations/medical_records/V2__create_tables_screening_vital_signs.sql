
CREATE TYPE level_urgency AS ENUM ('LOW', 'MEDIUM', 'HIGH');

ALTER TABLE patients
add column code VARCHAR(255) UNIQUE;

CREATE TABLE IF NOT EXISTS vital_signs (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    systolic_arterial_pressure DOUBLE PRECISION,
    diastolic_arterial_pressure DOUBLE PRECISION,
    heart_rate DOUBLE PRECISION,
    respiratory_rate DOUBLE PRECISION,
    oxygen_saturation DOUBLE PRECISION,
    body_temperature DOUBLE PRECISION,
    date DATE DEFAULT CURRENT_DATE,
    time TIME DEFAULT CURRENT_TIME
);

CREATE TABLE IF NOT EXISTS screening (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    date DATE DEFAULT CURRENT_DATE,
    main_complaint VARCHAR(255),
    urgency level_urgency,
    observations TEXT,
    patient_id UUID REFERENCES patients(id),
    vital_signs_id UUID REFERENCES vital_signs(id)
);


