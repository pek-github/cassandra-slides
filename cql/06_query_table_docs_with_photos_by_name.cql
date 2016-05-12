// Query 1)
// Find all information of a Doc by his/her full name,
// ie. by both his/her first name and last name.


SELECT * 
FROM hospital.docs_w_photos_by_name
WHERE last_name = 'smith' AND first_name = 'john';

SELECT * 
FROM hospital.docs_w_photos_by_name
WHERE last_name = 'smith' AND first_name = 'john' AND doc_id = 1201;

SELECT * 
FROM hospital.docs_w_photos_by_name
WHERE last_name = 'hadley' AND first_name = 'remy';
 
