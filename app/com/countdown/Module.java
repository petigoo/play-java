package com.countdown;

import com.countdown.repository.CollectionToJacksonCollection;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import play.Configuration;

public class Module extends AbstractModule {

    @Override
    public void configure() {
    }

    private MongoClient createMongoClient(Configuration configuration) {
        return new MongoClient(
                new ServerAddress(configuration.getString("mongodb.host"), configuration.getInt("mongodb.port")));
    }

    @Provides
    @Singleton
    public DB getMongoDatabase(Configuration configuration) {
        return createMongoClient(configuration).getDB(configuration.getString("mongodb.dbName"));
    }

    @Provides
    @Singleton
    public DBCollection getMongoCollection(DB db, Configuration configuration) {
        return db.getCollection(configuration.getString("mongodb.collection"));
    }

    @Provides
    @Singleton
    public CollectionToJacksonCollection getCollectionToJacksonCollection(DBCollection collection) {
        return new CollectionToJacksonCollection(collection);
    }

}
