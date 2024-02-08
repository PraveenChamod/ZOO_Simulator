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

    public List<Animal> filterByCategory(List<Animal> animals, String categoryName) {
        List<Animal> filteredAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (("Swimmer".equalsIgnoreCase(categoryName) && animal instanceof Swimmer) ||
                    ("Walker".equalsIgnoreCase(categoryName) && animal instanceof Walker) ||
                    ("Flyer".equalsIgnoreCase(categoryName) && animal instanceof Flyer)) {
                filteredAnimals.add(animal);
            }
        }
        return filteredAnimals;
    }

    public List<Animal> getSwimmers(){
        return filterByCategory(animals, "Swimmer");
    }

    public List<Animal> getFlyers(){
        return filterByCategory(animals, "Flyer");
    }

    public List<Animal> getWalkers(){
        return filterByCategory(animals, "Walker");
    }

    public void makeSwimmersSwim() {
        List<Animal> swimmers = getSwimmers();
        for (Animal animal : swimmers) {
            ((Swimmer) animal).swim();
        }
    }

    public void makeFlyersFly() {
        List<Animal> flyers = getFlyers();
        for (Animal animal : flyers) {
            ((Flyer) animal).fly();
        }
    }

    public void makeWalkersWalk() {
        List<Animal> walkers = getWalkers();
        for (Animal animal : walkers) {
            ((Walker) animal).walk();
        }
    }

    public void getNumberOfCategoriesSeparately() {
        int walkerCount = getSwimmers().size();
        int flyerCount = getFlyers().size();
        int swimmerCount = getWalkers().size();

        System.out.println("Number of Walkers: " + walkerCount);
        System.out.println("Number of Flyers: " + flyerCount);
        System.out.println("Number of Swimmers: " + swimmerCount);
    }
}