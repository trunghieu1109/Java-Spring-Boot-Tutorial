package com.example.demo;

public abstract class DatabaseConnector {
    public String url;

    abstract public void connect();

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

class MySQLConnector extends DatabaseConnector {
    public void connect() {
        System.out.println("Connected to MYSQL Database at " + this.getUrl());
    }
}

class MongoDBConnector extends DatabaseConnector {
    public void connect() {
        System.out.println("Connected to MongoDB Database at " + this.getUrl());
    }
}