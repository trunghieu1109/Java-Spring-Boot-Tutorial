package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = (Student) context.getBean("studentbean");
        student.displayInfo();

        Student specialStudent = (Student) context.getBean("specialstudentbean");
        specialStudent.displayInfo();

        Student a = (Student) context.getBean("a");
        a.displayInfo();

        Student b = (Student) context.getBean("b");
        b.displayInfo();

        Student c = (Student) context.getBean("s1");
        c.show();

        Student d_list = (Student) context.getBean("s2");
        d_list.showQuote();

        Student e_map = (Student) context.getBean("s3");
        e_map.showScore();

        Student e_setter = (Student) context.getBean("s4");
        e_setter.displayInfo();

    }
}
