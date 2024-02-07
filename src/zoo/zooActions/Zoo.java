package zoo.zooActions;

import zoo.animal.Animal;
import zoo.category.Flyer;
import zoo.category.Swimmer;
import zoo.category.Walker;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void sendAllToSleep() {
        for (Animal animal : animals) {
            System.out.println("Putting " + animal.getName() + " to sleep");
        }
    }

    public void wakeAllUp() {
        for (Animal animal : animals) {
            System.out.println("Waking up " + animal.getName());
        }
    }

    public void eatAll() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void getNumberOfAnimals() {
        System.out.println("All the number of animals in the zoo: " + animals.size());
    }

    public int makeSwimmersSwim(boolean makeSwim) {
        int swimmerCount = 0;
        for (Animal animal : animals) {
            if (animal instanceof Swimmer) {
                if(makeSwim) { ((Swimmer) animal).swim(); }
                swimmerCount++;
            }
        }
        return swimmerCount;
    }

    public int makeFlyersFly(boolean makeFly) {
        int flyerCount = 0;
        for (Animal animal : animals) {
            if (animal instanceof Flyer) {
                if(makeFly){ ((Flyer) animal).fly(); }
                flyerCount++;
            }
        }
        return flyerCount;
    }

    public int makeWalkersWalk(boolean makeWalk) {
        int walkerCount = 0;
        for (Animal animal : animals) {
            if (animal instanceof Walker) {
                if(makeWalk){ ((Walker) animal).walk(); }
                walkerCount++;
            }
        }
        return walkerCount;
    }

    public void getNumberOfCategoriesSeparately() {
        int walkerCount = makeWalkersWalk(false);
        int flyerCount = makeFlyersFly(false);
        int swimmerCount = makeSwimmersSwim(false);

        System.out.println("Number of Walkers: " + walkerCount);
        System.out.println("Number of Flyers: " + flyerCount);
        System.out.println("Number of Swimmers: " + swimmerCount);
    }
}