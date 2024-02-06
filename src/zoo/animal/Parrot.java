package zoo.animal;

import zoo.category.Flyer;

public class Parrot extends Animal implements Flyer {

    public Parrot(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Parrot is talking!");
    }

    @Override
    public void fly() {
        System.out.println("Parrot is flying!");
    }

    @Override
    public void eat() {
        System.out.println("Parrot is eating seeds");
    }
}
