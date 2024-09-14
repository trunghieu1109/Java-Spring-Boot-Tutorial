package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoAopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoAopApplication.class, args);

		context.start();

	}

}
