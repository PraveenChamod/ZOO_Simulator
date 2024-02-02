package services;

import java.util.Collections;
import java.util.List;

public class Swimmer implements Animal {
    private final String name;

    public Swimmer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getCategories() {
        return Collections.singletonList("swimmer");
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

    public void swim() {
        System.out.println(name + " is swimming.");
    }
}