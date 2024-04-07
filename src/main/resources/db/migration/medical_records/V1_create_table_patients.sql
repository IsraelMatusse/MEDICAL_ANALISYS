CREATE TYPE BloodType AS ENUM (
    'A_POSITIVE', 'A_NEGATIVE', 'B_POSITIVE', 'B_NEGATIVE',
    'AB_POSITIVE', 'AB_NEGATIVE', 'O_POSITIVE', 'O_NEGATIVE', 'UNKNOWN'
);

CREATE TYPE Genders AS ENUM (
    'MALE', 'FEMALE', 'OTHER', 'UNKNOWN'
);

CREATE TABLE patients (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    fathersName VARCHAR(255),
    mothersName VARCHAR(255),
    birthDate DATE,
    neighboorHood VARCHAR(255),
    msisdn VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    roadNr VARCHAR(255),
    houseNr VARCHAR(255),
    height FLOAT,
    weight FLOAT,
    bloodType BloodType,
    gender Genders
);