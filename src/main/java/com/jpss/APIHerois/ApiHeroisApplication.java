package com.jpss.APIHerois;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class ApiHeroisApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiHeroisApplication.class, args);
		System.out.println("tcheca com tcheca balança essa perereca");
	}

}
