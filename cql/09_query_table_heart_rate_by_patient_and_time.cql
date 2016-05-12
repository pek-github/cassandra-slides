// Queries 4 and 5)
// Q4) Find the average heart rate for a given Patient –
//     known by his/her patient-id – on a single given
//     date and given hour range
//
// Q5) Find the average heart rate for a given Patient –
//     known by his/her patient-id – on a given date range.
//     Assume that the date range will have at most ten days.

// Q4 - for a single given day and given hour range

SELECT patient_id, patient_last_name, patient_first_name, bed_id, avg(heart_rate) 
FROM hospital.heart_rate_by_patient_and_time
WHERE patient_id = '12111988K45' 
  AND when_date = '2016-04-25+0000'
  AND when_day_minutes >= 420 
  AND when_day_minutes < 480;

SELECT patient_id, patient_last_name, patient_first_name, bed_id, avg(heart_rate) 
FROM hospital.heart_rate_by_patient_and_time
WHERE patient_id = '12111988K45' 
  AND when_date = '2016-04-25+0000'
  AND when_day_minutes >= 420;  

// Q4 - for a single day but without any hour range

SELECT patient_id, patient_last_name, patient_first_name, bed_id, avg(heart_rate)
FROM hospital.heart_rate_by_patient_and_time
WHERE patient_id = '17101991S49'
  AND when_date = '2016-04-25+0000';


// Q5 - for a given date range

SELECT patient_id, patient_last_name, patient_first_name, avg(heart_rate) 
FROM hospital.heart_rate_by_patient_and_time
WHERE patient_id = '12111988K45' 
  AND when_date > '2016-04-23+0000' 
  AND when_date < '2016-04-27+0000';
  
SELECT patient_id, patient_last_name, patient_first_name, avg(heart_rate) 
FROM hospital.heart_rate_by_patient_and_time
WHERE patient_id = '12111988K45' 
  AND when_date > '2016-04-23+0000';
