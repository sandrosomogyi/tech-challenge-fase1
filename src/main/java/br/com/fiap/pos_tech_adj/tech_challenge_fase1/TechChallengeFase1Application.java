package br.com.fiap.pos_tech_adj.tech_challenge_fase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities")
public class TechChallengeFase1Application {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengeFase1Application.class, args);
	}
}
