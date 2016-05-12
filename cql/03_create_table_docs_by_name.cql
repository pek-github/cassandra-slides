// Query 2)
// Find all information excluding the
// photograph of a Doc by his/her full name,
// ie. by both his/her first name and last name.

// table management

DROP TABLE IF EXISTS hospital.docs_by_name;

CREATE TABLE hospital.docs_by_name (
    last_name  TEXT,
    first_name TEXT,
    doc_id     INT,
    specialty  TEXT,
    title      TEXT,
    PRIMARY KEY ( (last_name, first_name), doc_id )
) WITH CLUSTERING ORDER BY (doc_id ASC);


// data insertion

INSERT INTO 
hospital.docs_by_name (last_name, first_name, doc_id, specialty, title) 
VALUES ('smith', 'john', 1201, 'microbiologist', 'doc');

INSERT INTO 
hospital.docs_by_name (last_name, first_name, doc_id, specialty, title) 
VALUES ('smith', 'john', 1101, 'cardiologist', 'trainee doc');
 
INSERT INTO 
hospital.docs_by_name (last_name, first_name, doc_id, specialty, title) 
VALUES ('house', 'greg', 1011, 'diagnostician', 'head doc');

INSERT INTO 
hospital.docs_by_name (last_name, first_name, doc_id, specialty, title) 
VALUES ('hadley', 'remy', 1013, 'pathologist', 'doc');

INSERT INTO 
hospital.docs_by_name (last_name, first_name, doc_id, specialty, title) 
VALUES ('johnson', 'mary', 1185, 'pediatrician', 'senior doc');
