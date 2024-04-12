

CREATE TABLE countries(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(255)
);

INSERT INTO countries(designation)
VALUES ('Moçambicano'), ('Estrangeiro');