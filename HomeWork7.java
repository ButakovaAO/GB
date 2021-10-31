/**
 * Java 1. Homework 7
 * 
 * @author Butakova A.O.
 * @version 01.11.2021
 */

public class HomeWork7 {
    public static void main(String[] args) {
        Plate plate = new Plate(10);
        System.out.println(plate);

        System.out.println();

        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Felix", 3);
        catArray[2] = new Cat("Boris", 3);
        catArray[3] = new Cat("Murzik", 4);
        catArray[4] = new Cat("Lev", 6);
        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eat(plate);
            System.out.println(catArray[i]);
        }
        System.out.println(plate);

        System.out.println();
        System.out.println(plate.add(20));
        System.out.println(plate);
        System.out.println();

        for (int i = 0; i < catArray.length; i++) {
            catArray[i].setSatiety(false);
            catArray[i].eat(plate);
            System.out.println(catArray[i]);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    void setSatiety(boolean status) {
        satiety = status;
    }

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    void eat(Plate plate) { 
        if (!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString () {
        return "Cat " + name + " eat " + appetite + ", satiety " + satiety + "."; 
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    int getFood() {
        return food;
    }

    boolean decreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        } else {
            return false;
        }
    }

    String add(int food) {
        this.food += food;
        return "In a plate added " + food + ".";
    }

    @Override
    public String toString () {
        return "In a plate: " + food + "."; 
    }
}