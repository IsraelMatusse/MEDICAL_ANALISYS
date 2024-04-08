

CREATE TABLE symptoms(
id varchar(255) PRIMARY KEY DEFAULT gen_random_uuid(),
description TEXT,
screening_id varchar(255) REFERENCES screening(id)
);
