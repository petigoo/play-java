package com.countdown;

import org.bson.Document;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import play.Configuration;

public class Module extends AbstractModule {

    @Override
    public void configure() {
    }

    private MongoClient createMongoClient() {
        return new MongoClient();
    }

    @Provides
    @Singleton
    public MongoDatabase getMongoDatabase(Configuration configuration) {
        return createMongoClient().getDatabase(configuration.getString("mongodb.dbName"));
    }

    @Provides
    @Singleton
    public MongoCollection<Document> getMongoCollection(MongoDatabase database, Configuration configuration) {
        return database.getCollection(configuration.getString("mongodb.collection"));
    }

}
