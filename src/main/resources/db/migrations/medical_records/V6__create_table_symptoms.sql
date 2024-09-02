CREATE TABLE IF NOT EXISTS symptoms(
    id varchar(255) PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at date NOT NULL,
    description text NULL,
    simptom_intensity varchar(255) NOT NULL,
    duration  int NOT NULL,
    screenings_id varchar(255) NOT NULL,

    CONSTRAINT fk_screening FOREIGN KEY(screenings_id) REFERENCES screenings(id),
    CONSTRAINT simptom_intensity_check CHECK (simptom_intensity::text = ANY (ARRAY['ALTA'::character varying, 'MEDIA'::character varying, 'BAIXA'::character varying]::text[]))
);