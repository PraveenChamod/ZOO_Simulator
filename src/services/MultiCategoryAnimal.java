package services;

import java.util.List;

public class MultiCategoryAnimal implements Animal {
    private final String name;
    private final List<String> categories;

    public MultiCategoryAnimal(String name, List<String> categories) {
        this.name = name;
        this.categories = categories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getCategories() {
        return categories;
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
}
