package zoo.animal;

import zoo.category.Swimmer;

public class Fish extends Animal implements Swimmer {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Fish is bubbling!");
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming!");
    }

    @Override
    public void eat() {
        System.out.println("Fish is eating plants");
    }
}
