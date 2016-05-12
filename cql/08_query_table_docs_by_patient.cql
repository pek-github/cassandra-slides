// Query 3)
// Retrieve the names (ie. last name and first name) and ids of the Doctors
// treating a given Patient, who is known by his/her patient-id.
// Sort them alphabetically.
 

SELECT *
FROM hospital.docs_by_patient
WHERE patient_id = '12111988K45';

SELECT *
FROM hospital.docs_by_patient
WHERE patient_id = '25061984KP52';

SELECT *
FROM hospital.docs_by_patient 
WHERE patient_id IN ('12111988K45', '25061984KP52');
