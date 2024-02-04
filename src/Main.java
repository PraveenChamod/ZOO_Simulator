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

            getNumberAllTheAnimals(zoo, scanner);

            getNumberAllTheSwimmers(zoo, scanner);

            makeAnimalsForSwim(zoo, scanner);

            getNumberAllTheFlyers(zoo, scanner);

            makeAnimalsForFly(zoo, scanner);

            getNumberAllTheWalkers(zoo, scanner);

            makeAnimalsForWalk(zoo, scanner);

            getAllNumberOfEachAnimal(zoo, scanner);

            checkAnimalCategory(zoo, scanner);

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

            System.out.print("Do you want to add another animal to the zoo? (Y/N): ");
            addAnimalChoice = scanner.nextLine();
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

    private static void getNumberAllTheAnimals(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to get all the number of animals in zoo? (Y/N): ");
        String animalsCountChoice = scanner.nextLine();

        if(animalsCountChoice.equalsIgnoreCase("Yes") || animalsCountChoice.equalsIgnoreCase("Y")) {
            System.out.println("All the number of animals in the zoo: " + zoo.getNumberOfAnimals());
        }
    }

    private static void getNumberAllTheSwimmers(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to get all the number of swimmers in zoo? (Y/N): ");
        String swimmerCountChoice = scanner.nextLine();

        if(swimmerCountChoice.equalsIgnoreCase("Yes") || swimmerCountChoice.equalsIgnoreCase("Y")) {
            System.out.println("All the number of swimmers in the zoo: " + zoo.getNumberOfSwimmers());
            zoo.displaySwimmerNames();
        }
    }

    private static void makeAnimalsForSwim(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to make swim all the of swimmers in zoo? (Y/N): ");
        String swimChoice = scanner.nextLine();

        if(swimChoice.equalsIgnoreCase("Yes") || swimChoice.equalsIgnoreCase("Y")) {
            zoo.makeSwimmersSwim();
        }
    }

    private static void getNumberAllTheFlyers(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to get all the number of flyers in zoo? (Y/N): ");
        String flyersCountChoice = scanner.nextLine();

        if(flyersCountChoice.equalsIgnoreCase("Yes") || flyersCountChoice.equalsIgnoreCase("Y")) {
            System.out.println("All the number of flyers in the zoo: " + zoo.getNumberOfFlyers());
        }
    }

    private static void makeAnimalsForFly(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to make fly all the of flyers in zoo? (Y/N): ");
        String flyChoice = scanner.nextLine();

        if(flyChoice.equalsIgnoreCase("Yes") || flyChoice.equalsIgnoreCase("Y")) {
            zoo.makeFlyersFly();
        }
    }

    private static void getNumberAllTheWalkers(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to get all the number of walkers in zoo? (Y/N): ");
        String walkersCountChoice = scanner.nextLine();

        if(walkersCountChoice.equalsIgnoreCase("Yes") || walkersCountChoice.equalsIgnoreCase("Y")) {
            System.out.println("All the number of walkers in the zoo: " + zoo.getNumberOfWalkers());
        }
    }

    private static void makeAnimalsForWalk(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to make walk all the of walkers in zoo? (Y/N): ");
        String walkChoice = scanner.nextLine();

        if(walkChoice.equalsIgnoreCase("Yes") || walkChoice.equalsIgnoreCase("Y")) {
            zoo.makeWalkersWalk();
        }
    }

    private static void getAllNumberOfEachAnimal(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to get all the number of each animals in zoo? (Y/N): ");
        String eachAnimalsCountChoice = scanner.nextLine();

        if(eachAnimalsCountChoice.equalsIgnoreCase("Yes") || eachAnimalsCountChoice.equalsIgnoreCase("Y")) {
            System.out.println("All the number of walkers in the zoo: " + zoo.getNumberOfWalkers());
            System.out.println("All the number of flyers in the zoo: " + zoo.getNumberOfFlyers());
            System.out.println("All the number of swimmers in the zoo: " + zoo.getNumberOfSwimmers());
        }
    }

    private static void checkAnimalCategory(Zoo zoo, Scanner scanner){
        System.out.print("Do you want to check if a animal is walker, flyer and swimmer for each animals in zoo? (Y/N): ");
        String checkAnimalChoice = scanner.nextLine();

        if(checkAnimalChoice.equalsIgnoreCase("Yes") || checkAnimalChoice.equalsIgnoreCase("Y")) {
            zoo.displayAnimalNames();
            System.out.print("Enter a name for check: ");
            String animalNameChoice = scanner.nextLine();
            if(animalNameChoice != null) {
                zoo.checkCategoriesByAnimalName(animalNameChoice);
            }
        }
    }
}