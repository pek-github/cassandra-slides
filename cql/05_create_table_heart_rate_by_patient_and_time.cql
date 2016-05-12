// Queries 4 and 5)
// Q4) Find the average heart rate for a given Patient –
//     known by his/her patient-id – on a single given
//     date and given hour range
//
// Q5) Find the average heart rate for a given Patient –
//     known by his/her patient-id – on a given date range.
//     Assume that the date range will have at most ten days.


// table management

DROP TABLE IF EXISTS hospital.heart_rate_by_patient_and_time;

CREATE TABLE hospital.heart_rate_by_patient_and_time (
    patient_id         TEXT,
    patient_last_name  TEXT STATIC,
    patient_first_name TEXT STATIC,
    bed_id             TEXT,
    when_date          TIMESTAMP,
    when_day_minutes   INT,
    heart_rate         INT,
    PRIMARY KEY ((patient_id), when_date, when_day_minutes)
) WITH CLUSTERING ORDER BY (when_date DESC, when_day_minutes DESC);


// data insertion 
// These are only a few samples. More would be created with the Application.

INSERT INTO
hospital.heart_rate_by_patient_and_time (
    patient_id, patient_last_name, patient_first_name, 
    bed_id,
    when_date, when_day_minutes,
    heart_rate
) VALUES ('12111988K45', 'summers', 'alex',
          'E45',
          '2016-04-25+0000', 450,
          88
);

INSERT INTO
hospital.heart_rate_by_patient_and_time (
    patient_id, patient_last_name, patient_first_name, 
    bed_id,
    when_date, when_day_minutes,
    heart_rate
) VALUES ('12111988K45', 'summers', 'alex',
          'E45',
          '2016-04-25+0000', 452,
          90
);

INSERT INTO
hospital.heart_rate_by_patient_and_time (
    patient_id, patient_last_name, patient_first_name, 
    bed_id,
    when_date, when_day_minutes,
    heart_rate
) VALUES ('12111988K45', 'summers', 'alex',
          'F29',
          '2016-04-25+0000', 475,
          100
);

INSERT INTO
hospital.heart_rate_by_patient_and_time (
    patient_id, patient_last_name, patient_first_name, 
    bed_id,
    when_date, when_day_minutes,
    heart_rate
) VALUES ('12111988K45', 'summers', 'alex',
          'F29',
          '2016-04-25+0000', 481,
          94
);

