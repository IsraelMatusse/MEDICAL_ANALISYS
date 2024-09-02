CREATE TABLE IF NOT EXISTS vital_signs(
    id varchar(255) PRIMARY KEY DEFAULT gen_random_uuid(),
    systolic_arterial_pressure float NULL,
    diastolicAterialPressure   float NULL,
    heart_rate                 float NULL,
    respiratory_rate           float NULL,
    oxygen_saturation          float NULL,
    body_temperature           float NOT NULL,
    created_at                 date
);