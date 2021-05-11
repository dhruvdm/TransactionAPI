package com.xbank.txnapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.xbank.txnapi.repository.TransactionRepository;

@SpringBootApplication
public class TxnApiApplication {

    @Autowired
    TransactionRepository repository;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(TxnApiApplication.class, args);
	}

    /*
     * This function is created to populate dummy data in the repository
     */
    private void createDummyData() {

	}
}
