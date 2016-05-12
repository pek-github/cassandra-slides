// Query 1)
// Find all information of a Doc by his/her full name,
// ie. by both his/her first name and last name.

// table management

DROP TABLE IF EXISTS hospital.docs_w_photos_by_name;

CREATE TABLE hospital.docs_w_photos_by_name (
    last_name  TEXT,
    first_name TEXT,
    doc_id     INT,
    specialty  TEXT,
    title      TEXT,
    photo      BLOB,
    PRIMARY KEY ( (last_name, first_name), doc_id )
) WITH CLUSTERING ORDER BY (doc_id ASC);


// data insertion

INSERT INTO 
hospital.docs_w_photos_by_name (last_name, first_name, doc_id, specialty, title, photo) 
VALUES ('smith', 'john', 1201, 'microbiologist', 'doc', 0x0BEE);

INSERT INTO 
hospital.docs_w_photos_by_name (last_name, first_name, doc_id, specialty, title, photo) 
VALUES ('smith', 'john', 1101, 'cardiologist', 'trainee doc', 0x0F00);
 
INSERT INTO 
hospital.docs_w_photos_by_name (last_name, first_name, doc_id, specialty, title, photo) 
VALUES ('house', 'greg', 1011, 'diagnostician', 'head doc', 0xC0FFEE);

INSERT INTO
hospital.docs_w_photos_by_name (last_name, first_name, doc_id, specialty, title, photo) 
VALUES ('hadley', 'remy', 1013, 'pathologist', 'doc', 0x0BE11A);

INSERT INTO 
hospital.docs_w_photos_by_name (last_name, first_name, doc_id, specialty, title, photo) 
VALUES ('johnson', 'mary', 1185, 'pediatrician', 'senior doc', 0x0D0C); 
