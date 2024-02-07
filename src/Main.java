import zoo.animal.Elephant;
import zoo.animal.Fish;
import zoo.animal.Parrot;
import zoo.animal.SeaBird;
import zoo.zooActions.Zoo;


public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Elephant elephant = new Elephant("Elephant");
        Fish fish = new Fish("Fish");
        SeaBird seaBird = new SeaBird("Sea Bird");
        Parrot parrot = new Parrot("Parrot");

        zoo.addAnimal(elephant);
        zoo.addAnimal(fish);
        zoo.addAnimal(seaBird);
        zoo.addAnimal(parrot);

        zoo.sendAllToSleep();

        zoo.wakeAllUp();

        zoo.eatAll();

        zoo.getNumberOfAnimals();

        zoo.makeSwimmersSwim(true);

        zoo.makeFlyersFly(true);

        zoo.makeWalkersWalk(true);

        zoo.getNumberOfCategoriesSeparately();

    }
}