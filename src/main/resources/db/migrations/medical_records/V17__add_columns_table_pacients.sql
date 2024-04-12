CREATE TABLE countries(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(255)
);

INSERT INTO countries(designation)
VALUES ('Moçambicano'), ('Estrangeiro');

CREATE TABLE ocupations(
    id VARCHAR(255) PRIMARY KEY DEFAULT gen_random_uuid(),
    description TEXT
);

ALTER TABLE patients
    ADD COLUMN marital_status VARCHAR(255),
    ADD COLUMN province VARCHAR(255),
    ADD COLUMN district VARCHAR(255),
    ADD COLUMN nationality INT REFERENCES countries(id),
    ADD COLUMN ocupation_id VARCHAR(255) REFERENCES ocupations(id);