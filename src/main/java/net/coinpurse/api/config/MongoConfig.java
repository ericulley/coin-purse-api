package net.coinpurse.api.config;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Bean
    public MongoClient mongoClient() throws MongoException {
        // Create a new client and connect to the server
        try {
            MongoClient mongoClient = MongoClients.create(mongoURI);
            MongoDatabase database = mongoClient.getDatabase(mongoDatabaseName);
            return mongoClient;
        } catch (MongoException e) {
            System.err.println(e);
            throw e;
        }
    }
}
