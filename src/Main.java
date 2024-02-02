import services.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Zoo zoo = new Zoo();
            Scanner scanner = new Scanner(System.in);

            initiallyAddAnimalsToZoo(zoo);

            addAnimalsToZoo(zoo, scanner);

            sendAllAnimalsToSleep(zoo, scanner);

            wakeUpAllAnimalsFromSleep(zoo, scanner);

            makeAllAnimalsForEat(zoo, scanner);











//            zoo.makeAllAnimalsEat();
//
//            System.out.println("Number of walkers: " + zoo.getNumberOfWalkers());
//            System.out.println("Number of swimmers: " + zoo.getNumberOfSwimmers());
//            System.out.println("Number of flyers: " + zoo.getNumberOfFlyers());
//
//            System.out.println("Making all swimmers swim:");
//            for (Animal swimmer : zoo.getSwimmers()) {
//                ((Swimmer) swimmer).swim();
//            }
//
//            System.out.println("Making all flyers fly:");
//            for (Animal flyer : zoo.getFlyers()) {
//                ((Flyer) flyer).fly();
//            }
//
//            System.out.println("Making all walkers walk:");
//            for (Animal walker : zoo.getWalkers()) {
//                ((Walker) walker).walk();
//            }
//
//            System.out.println(elephant.getName() + " is a walker: " + zoo.isWalker(elephant));
//            System.out.println(fish.getName() + " is a swimmer: " + zoo.isSwimmer(fish));
//            System.out.println(parrot.getName() + " is a flyer: " + zoo.isFlyer(parrot));





        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void initiallyAddAnimalsToZoo(Zoo zoo){
        Animal elephant = new Walker("Elephant");
        Animal fish = new Swimmer("Fish");
        Animal seaBird = new Flyer("Sea Bird");
        Animal parrot = new Flyer("Parrot");

        zoo.addAnimal(elephant);
        zoo.addAnimal(fish);
        zoo.addAnimal(seaBird);
        zoo.addAnimal(parrot);
    }

    private static void addAnimalsToZoo(Zoo zoo, Scanner scanner) {
        System.out.print("Do you want to add an animal to the zoo? (Y/N): ");
        String addAnimalChoice = scanner.nextLine();

        while (addAnimalChoice.equalsIgnoreCase("Yes") || addAnimalChoice.equalsIgnoreCase("Y")) {
            System.out.print("Enter the name of the animal: ");
            String animalName = scanner.nextLine();

            if (zoo.isAnimalAlreadyExists(animalName)) {
                System.out.println("An animal with the name '" + animalName + "' already exists in the zoo. Please choose a different name.");
                continue;
            }

            List<String> categories = new ArrayList<>();

            System.out.println("Enter the categories of the animal (walker/swimmer/flyer), type 'done' when finished:");
            String category;
            while (true) {
                System.out.print("Category: ");
                category = scanner.nextLine().toLowerCase();
                if (category.equals("done")) {
                    break;
                }
                if (!isValidCategory(category)) {
                    System.out.println("Invalid category. Please enter a valid category (walker/swimmer/flyer).");
                    continue;
                }
                categories.add(category);
            }

            Animal newAnimal = createAnimal(animalName, categories);
            zoo.addAnimal(newAnimal);

            System.out.print("Do you want to add another animal to the zoo? (Yes/No): ");
            addAnimalChoice = scanner.nextLine();
            System.out.println("Now all the number of animals in the zoo: " + zoo.getNumberOfAnimals());
        }
    }
    public static Animal createAnimal(String animalName, List<String> categories) {
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("Animal must have at least one category.");
        }

        if (categories.size() == 1) {
            String category = categories.get(0);
            return switch (category) {
                case "walker" -> new Walker(animalName);
                case "swimmer" -> new Swimmer(animalName);
                case "flyer" -> new Flyer(animalName);
                default -> throw new IllegalArgumentException("Invalid category. Animal must be walker, swimmer, or flyer.");
            };
        } else {
            return new MultiCategoryAnimal(animalName, categories);
        }
    }

    private static boolean isValidCategory(String category) {
        return category.equals("walker") || category.equals("swimmer") || category.equals("flyer");
    }

    private static void sendAllAnimalsToSleep(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to send all animals to sleep? (Y/N): ");
        String animalSleepChoice = scanner.nextLine();

        if(animalSleepChoice.equalsIgnoreCase("Yes") || animalSleepChoice.equalsIgnoreCase("Y")){
            zoo.makeAllAnimalsSleep();
        }
    }

    private static void wakeUpAllAnimalsFromSleep(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to wake up all animals from sleep? (Y/N): ");
        String animalWakeUpChoice = scanner.nextLine();

        if(animalWakeUpChoice.equalsIgnoreCase("Yes") || animalWakeUpChoice.equalsIgnoreCase("Y")){
            zoo.makeAllAnimalsWakeUp();
        }
    }

    private static void makeAllAnimalsForEat(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to make all animals for eat? (Y/N): ");
        String animalEatUpChoice = scanner.nextLine();

        if(animalEatUpChoice.equalsIgnoreCase("Yes") || animalEatUpChoice.equalsIgnoreCase("Y")){
            zoo.makeAllAnimalsEat();
        }
    }
}