This small Java Web Application exposes a REST interface 
that allows to make queries to Table 'heart_rate_by_patient_and_time' 
of Keyspace 'hospital'. 

Examples of these queries are given in the end of this document, 
but in order to become familiar with the purpose of this Web App,
as well as the Cassandra DB Schema Design, one should look 
at the accompanying slides, in file 'ThessJM_CassandraDb.pdf'.
Especially useful is section 'Data Modeling for Cassandra (C*)',
because this Web App implements discussed queries 4 and 5:

Q4) Find the average heart rate for a given Patient –
known by his/her patient-id – on a single given
date and given hour range

Q5) Find the average heart rate for a given Patient –
known by his/her patient-id – on a given date range. 
Assume that the date range will have at most ten days.

Before running the application, ensure you have populated the Table, 
preferably with the accompanying Java application named "HeartRateWriter".

The app does not perform any serious error checking/handling
- in fact you can easily make it crash with invalid input.

Finally, it was tested in a Cluster with a single node.
Web Server was Tomcat 7.0.


Example queries (against a local web server), 
given that patient Alex id is '12111988K45' 
and patient Jane id is '17101991S49':

1) Ask for Alex, for a date range
http://localhost:8080/HeartRateReader/rest/heartrates/patients/12111988K45/dates/2016-04-25/2016-04-27
2) Ask for Alex, for a specific date
http://localhost:8080/HeartRateReader/rest/heartrates/patients/12111988K45/date/2016-04-25
3) Ask for Alex, for a specific date and an hour range
http://localhost:8080/HeartRateReader/rest/heartrates/patients/12111988K45/date/2016-04-25?fromHour=4&toHour=12

4) Ask for Jane, for a date range
http://localhost:8080/HeartRateReader/rest/heartrates/patients/17101991S49/dates/2016-04-23/2016-04-27
5) Ask for Jane, for a specific date
http://localhost:8080/HeartRateReader/rest/heartrates/patients/17101991S49/date/2016-04-25
6) Ask for Jane, for a specific date and an hour range
http://localhost:8080/HeartRateReader/rest/heartrates/patients/17101991S49/date/2016-04-25?fromHour=8&toHour=12

