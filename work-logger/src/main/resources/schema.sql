CREATE TABLE content (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    job_fk INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    content_type_fk INTEGER NOT NULL,
    content VARCHAR,
    create_time TIMESTAMP(0) WITHOUT TIME ZONE,
    update_time TIMESTAMP(0) WITHOUT TIME ZONE
);

CREATE TABLE content_type (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE job_type (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE job_status (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE job (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    job_status_fk INTEGER NOT NULL,
    link VARCHAR(255),
    create_time TIMESTAMP(0) WITHOUT TIME ZONE
);

CREATE TABLE attached_file (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    file_name VARCHAR(255) NOT NULL,
    file_url VARCHAR(255) NOT NULL
)

CREATE TRIGGER CON_TYP AFTER INSERT ON content_type FOR EACH ROW CALL "com.sander.worklogger.trigger.H2Trigger";

ALTER TABLE job ADD CONSTRAINT job_status_to_job_fk FOREIGN KEY (job_status_fk) REFERENCES job(id);