--liquibase formatted sql

--changeset morrs:1
CREATE TABLE scanners(
                         name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE scanners_data(
                              sensor_name VARCHAR(255) REFERENCES scanners(name),
                              value FLOAT,
                              raining BOOLEAN
)

