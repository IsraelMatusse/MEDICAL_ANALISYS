CREATE TABLE IF NOT EXISTS patients(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name varchar(255) NOT NULL,
    fathers_name varchar(255) NULL,
    mothers_name varchar(255) NULL,
    birth_date date NOT NULL,
    address varchar(255) NOT NULL,
    msisdn varchar(255) NULL,
    email varchar(255) NULL UNIQUE,
    road varchar(255) NULL,
    house_nr varchar(255) NULL,
    height varchar(255) NULL,
    weight varchar(255) NULL,
    document_number varchar(255) NULL,
    blood_type varchar(255) NOT NULL,
    gender varchar(255) NOT NULL,
    province_id  int NULL,
    district_id  int NULL,
    code varchar(255) NOT NULL,

    CONSTRAINT blood_type_check CHECK (blood_type::text = ANY (ARRAY['A+'::character varying, 'A-'::character varying, 'B+'::character varying, 'B-'::character varying, 'AB+'::character varying, 'AB-'::character varying, 'O+'::character varying, 'O-'::character varying, 'Desconhecido'::character varying]::text[])),
    CONSTRAINT gender_check CHECK (gender::text = ANY (ARRAY['MASCULINO'::character varying, 'FEMININO'::character varying, 'OUTROS'::character varying, 'DESCONHECIDO'::character varying]::text[]))
);