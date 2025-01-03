--liquibase formatted sql
--changeset morrs:1

ALTER TABLE scanners_data ADD COLUMN id UUID;
ALTER TABLE scanners_data ADD CONSTRAINT pk_id PRIMARY KEY(id);
