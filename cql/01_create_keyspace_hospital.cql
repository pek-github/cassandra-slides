// Keyspace 'hospital' creation

DROP KEYSPACE IF EXISTS hospital;

CREATE KEYSPACE hospital 
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };
 
