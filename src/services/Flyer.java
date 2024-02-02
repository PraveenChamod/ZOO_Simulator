package services;

import java.util.Collections;
import java.util.List;

public class Flyer implements Animal {
    private final String name;

    public Flyer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getCategories() {
        return Collections.singletonList("flyer");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    @Override
    public void wakeUp() {
        System.out.println(name + " is waking up.");
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void fly() {
        System.out.println(name + " is flying.");
    }
}
