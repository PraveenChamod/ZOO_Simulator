package services;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Cannot add null animal to the zoo.");
        }else{
            animals.add(animal);
            System.out.println("Successfully added the animal.");
        }
    }

    public boolean isAnimalAlreadyExists(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return true;
            }
        }
        return false;
    }

    public void makeAllAnimalsSleep() {
        for (Animal animal : animals) {
            if (animal.getCategories().size() > 1) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).sleep();
                } else {
                    System.out.println("Unable to determine sleep action for " + animal.getName());
                }
            } else {
                animal.sleep();
            }
        }
    }

    public void makeAllAnimalsWakeUp() {
        for (Animal animal : animals) {
            if (animal.getCategories().size() > 1) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).wakeUp();
                } else {
                    System.out.println("Unable to determine wake up action for " + animal.getName());
                }
            } else {
                animal.wakeUp();
            }
        }
    }


    public void makeAllAnimalsEat() {
        for (Animal animal : animals) {
            if (animal.getCategories().size() > 1) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).eat();
                } else {
                    System.out.println("Unable to determine eat action for " + animal.getName());
                }
            } else {
                animal.eat();
            }
        }
    }

    public void makeSwimmersSwim() {
        for (Animal animal : animals) {
            if (isSwimmer(animal)) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).swim();
                } else if(animal instanceof Swimmer) {
                    ((Swimmer) animal).swim();
                } else {
                    System.out.println("Unable to determine swim action for " + animal.getName());
                }
            }
        }
    }

    public void makeFlyersFly() {
        for (Animal animal : animals) {
            if (isFlyer(animal)) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).fly();
                } else if(animal instanceof Flyer) {
                    ((Flyer) animal).fly();
                } else {
                    System.out.println("Unable to determine swim action for " + animal.getName());
                }
            }
        }
    }

    public void makeWalkersWalk() {
        for (Animal animal : animals) {
            if (isWalker(animal)) {
                if (animal instanceof MultiCategoryAnimal) {
                    ((MultiCategoryAnimal) animal).walk();
                } else if(animal instanceof Walker) {
                    ((Walker) animal).walk();
                } else {
                    System.out.println("Unable to determine swim action for " + animal.getName());
                }
            }
        }
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<Animal> getSwimmers() {
        return getAnimalsByCategory("swimmer");
    }

    public List<Animal> getFlyers() {
        return getAnimalsByCategory("flyer");
    }

    public List<Animal> getWalkers() {
        return getAnimalsByCategory("walker");
    }

    public List<Animal> getAnimalsByCategory(String category) {
        List<Animal> categoryAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getCategories().contains(category)) {
                categoryAnimals.add(animal);
            }
        }
        return categoryAnimals;
    }

    public void displayAnimalNames() {
        System.out.println("Animal names in the zoo:");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    public void displaySwimmerNames() {
        List<Animal> swimmers = getSwimmers();

        if (swimmers.isEmpty()) {
            System.out.println("No swimmer animals in the zoo.");
        } else {
            for (Animal swimmer : swimmers) {
                System.out.println(swimmer.getName() + " is swimming");
            }
        }
    }

    public void checkCategoriesByAnimalName(String animalName) {
        boolean found = false;

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                found = true;
                System.out.println("Categories for " + animal.getName() + ": " + animal.getCategories());
                break;
            }
        }

        if (!found) {
            System.out.println("Animal with the name '" + animalName + "' not found in the zoo.");
        }
    }

    public int getNumberOfWalkers() {
        return getWalkers().size();
    }

    public int getNumberOfFlyers() {
        return getFlyers().size();
    }

    public int getNumberOfSwimmers() {
        return getSwimmers().size();
    }

    public boolean isSwimmer(Animal animal) {
        return animal.getCategories().contains("swimmer");
    }

    public boolean isWalker(Animal animal) {
        return animal.getCategories().contains("walker");
    }

    public boolean isFlyer(Animal animal) {
        return animal.getCategories().contains("flyer");
    }
}