package zoo.animal;

import zoo.category.Flyer;
import zoo.category.Walker;

public class SeaBird extends Animal implements Flyer, Walker {
    public SeaBird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Sea bird is squawking!");
    }

    @Override
    public void fly() {
        System.out.println("Sea bird is flying!");
    }

    @Override
    public void walk() { System.out.println("Sea bird is walking!"); }

    @Override
    public void eat() {
        System.out.println("Sea bird is eating fish");
    }
}
