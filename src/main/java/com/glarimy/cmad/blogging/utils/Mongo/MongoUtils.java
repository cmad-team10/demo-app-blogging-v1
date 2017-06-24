package com.glarimy.cmad.blogging.utils.Mongo;


import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoUtils {
	  private static MongoClient mongoClient = null;
	    private static Morphia morphia = null;
	    private static Datastore dataStore = null;

	    private static MongoClient getMongoClientInstance() {
	        if (mongoClient == null) {
	            String mongoHost = "localhost";
	            String mongoPort = "27017";
	            String connStr = mongoHost + ":" + mongoPort;
	            mongoClient = new MongoClient(connStr);
	        }
	        return mongoClient;
	    }

	    private static Morphia getMorphiaInstance() {
	        getMongoClientInstance();
	        if (morphia == null) {
	            morphia = new Morphia();
	        }
	        return morphia;
	    }

	    public static Datastore getMongoDataStore() {
	        if (dataStore == null) {
	            Morphia morp = getMorphiaInstance();
	            String dbName = "cmad";
	            dataStore = morp.createDatastore(mongoClient, dbName);
	        }
	        return dataStore;
	    }

}