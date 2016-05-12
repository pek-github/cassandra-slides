The CQL scripts are numbered so as to indicated some logical order of precedence when running them.
As expected, we first need to create a KeySpace, then the Tables, then populate them, then query them.

Note that data samples for Table heart_rate_by_patient_and_time are only a few.
More will be created by a Java Application, so that the queries of the 9th script make more sense.

You can enjoy executing these scripts in your running Cassandra, via either one of the tools:
cqlsh, DevCenter.

The first one comes with Cassandra (both Apache and DataStax) by default.

The last one comes only with DataStax Cassandra but it is way more user friendly.
You can find it here:
http://www.datastax.com/what-we-offer/products-services/devcenter

Enjoy!
