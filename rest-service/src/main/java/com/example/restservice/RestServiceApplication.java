package com.example.restservice;

import com.example.restservice.user.User;
import com.example.restservice.user.UserHttpClient;
import com.example.restservice.user.UserRestClient;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RestServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}

//	@Bean
//	CommandLineRunner runner(UserRestClient client) {
//		return args -> {
//			List<User> users = client.findAll();
//			System.out.println(users);
//		};
//	}

}
