// Query 3)
// Retrieve the names (ie. last name and first name) and ids of the Doctors
// treating a given Patient, who is known by his/her patient-id.
// Sort them alphabetically.


// table management

DROP TABLE IF EXISTS hospital.docs_by_patient;

CREATE TABLE hospital.docs_by_patient (
    patient_id     TEXT,
    doc_last_name  TEXT,
    doc_first_name TEXT,
    doc_id         INT,
    PRIMARY KEY( (patient_id), doc_last_name, doc_first_name, doc_id)
) WITH CLUSTERING ORDER BY (doc_last_name ASC, doc_first_name ASC, doc_id ASC);


// data insertion

INSERT INTO 
hospital.docs_by_patient (patient_id, doc_last_name, doc_first_name, doc_id) 
VALUES ('12111988K45', 'smith', 'john', 1101);

INSERT INTO 
hospital.docs_by_patient (patient_id, doc_last_name, doc_first_name, doc_id) 
VALUES ('12111988K45', 'smith', 'john', 1201);

INSERT INTO 
hospital.docs_by_patient (patient_id, doc_last_name, doc_first_name, doc_id) 
VALUES ('12111988K45', 'house', 'greg', 1011);

INSERT INTO 
hospital.docs_by_patient (patient_id, doc_last_name, doc_first_name, doc_id) 
VALUES ('25061984KP52', 'hadley', 'remy', 1013);

