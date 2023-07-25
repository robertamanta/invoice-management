package com.roberta.invoicemanagementbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InvoiceManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceManagementBackendApplication.class, args);
	}

}
