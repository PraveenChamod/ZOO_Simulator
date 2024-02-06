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

    public void makeSwimmersSwim() {
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Swimmer")) {
                ((Swimmer) animal).swim();
            }
        }
    }

    public void makeFlyersFly() {
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Flyer")) {
                ((Flyer) animal).fly();
            }
        }
    }

    public void makeWalkersWalk() {
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Walker")) {
                ((Walker) animal).walk();
            }
        }
    }

    public void getNumberOfCategoriesSeparately() {
        int walkerCount = countWalkers();
        int flyerCount = countFlyers();
        int swimmerCount = countSwimmers();

        System.out.println("Number of Walkers: " + walkerCount);
        System.out.println("Number of Flyers: " + flyerCount);
        System.out.println("Number of Swimmers: " + swimmerCount);
    }

    public int countWalkers() {
        int walkerCount = 0;
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Walker")) {
                walkerCount++;
            }
        }
        return walkerCount;
    }

    public int countFlyers() {
        int flyerCount = 0;
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Flyer")) {
                flyerCount++;
            }
        }
        return flyerCount;
    }

    public int countSwimmers() {
        int swimmerCount = 0;
        for (Animal animal : animals) {
            if (identifyCategory(animal).contains("Swimmer")) {
                swimmerCount++;
            }
        }
        return swimmerCount;
    }

    public List<String> identifyCategory(Animal animal) {
        List<String> categories = new ArrayList<>();
        if (animal instanceof Walker) {
            categories.add("Walker");
        }
        if (animal instanceof Flyer) {
            categories.add("Flyer");
        }
        if (animal instanceof Swimmer) {
            categories.add("Swimmer");
        }
        return categories;
    }
}