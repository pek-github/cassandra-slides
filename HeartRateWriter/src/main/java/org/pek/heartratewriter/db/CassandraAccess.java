package org.pek.heartratewriter.db;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public final class CassandraAccess {
		
	/* the Cassandra Cluster */
	private static Cluster CLUSTER = null;
	
	/* Each session maintains multiple connections to the cluster nodes,
	 * and it is thread-safe. 
	 * Usually a single instance is enough per application. 
	 * Read the relevant javadoc */
	private static Session SESSION = null;

	
	public static Session getSession() {

		if (SESSION == null) {
			SESSION = createSession();
		}

		return SESSION;
	}	
	
	private static Session createSession() {
		Session s = getCluster().connect();
		return s;
	}
	
	private static Cluster getCluster() {

		if (CLUSTER == null) {
			CLUSTER = Cluster.builder()
							 .addContactPoint("localhost")
							 .build();
		}

		return CLUSTER;
	}

}
