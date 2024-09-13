package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import main.java.com.example.demo.Address;

public class Student {
    private String name;
    private int age;
    private Address address;
    private List<String> quote;

    private Map<String, Integer> score;

    public String getName() {
        return name;
    }

    public Student() {

    }

    public Student(int age) {
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, Address address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(List<String> quote) {
        this.quote = quote;
    }

    public Student(Map<String, Integer> score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello: " + name + ", you are " + age);
    }

    public void show() {
        System.out.println("Hello: " + name + ", you are " + age);
        System.out.println(address.toString());
    }

    public void showQuote() {
        Iterator<String> it = quote.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void showScore() {
        Set<Entry<String, Integer>> entries = score.entrySet();

        Iterator<Entry<String, Integer>> it = entries.iterator();

        while (it.hasNext()) {

            Entry<String, Integer> entry = it.next();

            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
