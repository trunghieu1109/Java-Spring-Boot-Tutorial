package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface Outfit {
    public void wear();
}

@Component("skirt")
class Skirt implements Outfit {
    public void wear() {
        System.out.println("I'm wearing skirt");
    }
}

@Component("naked")
class Naked implements Outfit {
    public void wear() {
        System.out.println("I'm naked");
    }
}