package net.coinpurse.api.config;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabaseName;
    @Value("${spring.data.mongodb.uri}")
    private String mongoURI;

    @Override
    protected String getDatabaseName() {
        return mongoDatabaseName;
    }

    @Override
    public MongoClient mongoClient() {
        // Replace the placeholder with your Atlas connection string
        String uri = mongoURI;
        // Create a new client and connect to the server
        System.out.println("Mongo Connection String: " + uri);
        try (
                MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("coin-purse-db");
            try {
                // Send a ping to confirm a successful connection
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Pinged your deployment. You successfully connected to MongoDB! " + commandResult);
            } catch (MongoException me) {
                System.err.println(me);
            }
            return mongoClient;
        }
    }
}
