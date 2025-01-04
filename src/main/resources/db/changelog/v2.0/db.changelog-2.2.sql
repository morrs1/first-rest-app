--liquibase formatted sql
--changeset morrs:1

INSERT INTO scanners (name, id)
VALUES ('Scanner1', '77997d28-08eb-4abf-9a2e-240865514635'),
       ('Scanner2', 'f8828cdf-8157-4747-bd67-1526691fbf58')