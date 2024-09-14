package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.DatabaseConnector;

@Configuration
public class AppConfig {

    @Value("${local.mysql.url}")
    private String mysqlUrl;

    @Bean("mysqlConnector")
    public DatabaseConnector mysqlConnectorConfigure() {
        DatabaseConnector mysqlConnector = new MySQLConnector();
        mysqlConnector.setUrl(mysqlUrl);
        return mysqlConnector;
    }

    @Bean("mongodbConnector")
    public DatabaseConnector mongoDBConnectorConfigure() {
        DatabaseConnector mongoDBConnector = new MongoDBConnector();
        mongoDBConnector.setUrl("mongodb");
        return mongoDBConnector;
    }

}
