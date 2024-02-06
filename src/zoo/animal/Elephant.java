package zoo.animal;

import zoo.category.Walker;

public class Elephant extends Animal implements Walker {

    public Elephant(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting!");
    }

    @Override
    public void walk() {
        System.out.println("Elephant is walking!");
    }

    @Override
    public void eat() {
        System.out.println("Elephant is eating grass");
    }
}
