package net.coinpurse.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.coinpurse")
public class CoinPurseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoinPurseApiApplication.class, args);
	}
}
