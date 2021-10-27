/**
 * Java 1. Homework 6
 * 
 * @author Butakova A.O.
 * @version 28.10.2021
 */

class HomeWork6 {

    public static void main(String[] args) {
        Cat cat = new Cat (200, -1);
        Dog dog = new Dog (500, 10);
        
        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(199));
            System.out.println(animal.run(200));
            System.out.println(animal.run(201));
            System.out.println(animal.run(499));
            System.out.println(animal.run(500));
            System.out.println(animal.run(501));
            System.out.println(animal.swim(9));
            System.out.println(animal.swim(10));
            System.out.println(animal.swim(11));
        }
    }
}

class Cat extends Animal {

    Cat (int limRun, int limSwim) {
        super (limRun, limSwim);
    }

    @Override
    public String swim(int distance) {
        return "Cat can't swim.";
    }
}

class Dog extends Animal {

    Dog (int limRun, int limSwim) {
        super (limRun, limSwim);
    }
}

abstract class Animal implements IAnimal {
    protected int limRun;
    protected int limSwim;
    protected String animalType;

    Animal (int limRun, int limSwim) {
        this.limRun = limRun;
        this.limSwim = limSwim;
        animalType = getClass().getSimpleName();
    }

    public String getAnimalType() {
        return animalType;
    }

    @Override
    public String run (int distance) {
        return (distance > limRun)? animalType + " could't run " + distance : animalType + " run " + distance; 
    }

    @Override
    public String swim (int distance) {
        return (distance > limSwim)? animalType + " could't swim " + distance : animalType + " swim " + distance; 
    }

    @Override
    public String toString () {
        return (limSwim > 0)? animalType + " maximum running distance:" + limRun + "; maximum swimming distance:" + limSwim : animalType + " maximum running distance:" + limRun + ". Cat can't swim."; 
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}