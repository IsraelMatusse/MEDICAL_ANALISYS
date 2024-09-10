CREATE TABLE especialities(
    id int PRIMARY KEY NOT NULL,
    designation varchar(255) NOT NULL,
    status bool DEFAULT true,
    created_at Date NOT NULL
);