package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.demo")
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class,
                args);

        StudentService studentService = context.getBean(StudentService.class);

        System.out.println(studentService.getRandomStudent());

        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");

        mysql.connect();

        DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");

        mongodb.connect();

    }
}