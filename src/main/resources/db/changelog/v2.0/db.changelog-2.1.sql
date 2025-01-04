--liquibase formatted sql
--changeset morrs:1

ALTER TABLE scanners_data DROP CONSTRAINT scanners_data_sensor_name_fkey;

DELETE FROM scanners;
ALTER TABLE scanners DROP CONSTRAINT scanners_pkey;

ALTER TABLE scanners ADD COLUMN id UUID;
ALTER TABLE scanners ADD CONSTRAINT scanners_pkey PRIMARY KEY(id);

ALTER TABLE scanners_data ADD COLUMN sensor_id UUID;
ALTER TABLE scanners_data ADD CONSTRAINT f_key FOREIGN KEY(sensor_id) REFERENCES scanners(id);
ALTER TABLE scanners_data DROP COLUMN sensor_name;