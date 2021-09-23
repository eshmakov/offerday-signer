CREATE TABLE recording_right
(
    id BIGSERIAL PRIMARY KEY,
    recording_id BIGINT REFERENCES recording (id),
    company_id BIGINT REFERENCES company (id),
    start_time TIMESTAMP,
    end_time TIMESTAMP
);
