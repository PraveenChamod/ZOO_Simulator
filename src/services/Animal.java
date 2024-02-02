package services;

import java.util.List;

public interface Animal {
    String getName();
    List<String> getCategories();

    void sleep();
    void wakeUp();
    void eat();
}