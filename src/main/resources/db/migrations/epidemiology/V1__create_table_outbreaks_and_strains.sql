CREATE TYPE patogenical_type AS ENUM ('Bacterial', 'Viral', 'Fungi', 'Helminth', 'Other', 'Unknown');


CREATE TABLE IF NOT EXISTS strains (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    description TEXT,
    patogenical_type patogenical_type
);


CREATE TABLE IF NOT EXISTS outbreaks (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    description TEXT,
    start_date DATE,
    end_date DATE,
    total_cases INTEGER,
    total_deaths INTEGER,
    total_recoveries INTEGER,
    strain_id UUID REFERENCES strains(id)
);


