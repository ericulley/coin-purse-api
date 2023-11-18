package net.coinpurse.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CoinPurseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoinPurseApiApplication.class, args);
	}
}
