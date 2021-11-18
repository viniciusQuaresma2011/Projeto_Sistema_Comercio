package com.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
//@ComponentScan(basePackages ={"com.springboot.repository.ProdutoRepository"})

public class ProjetoBasicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBasicoApplication.class, args);
	}

}
