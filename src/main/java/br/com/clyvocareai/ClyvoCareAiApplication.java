package br.com.clyvocareai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClyvoCareAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClyvoCareAiApplication.class, args);
	}

}
