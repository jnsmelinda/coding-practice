package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private static Queue<Animal> shelter;

    public AnimalShelter() {
        shelter = new LinkedList();
    }


    public static void add(Animal animal) {
        shelter.add(animal);
    }

    public static Animal adopt(Animal animal) {
        if (shelter.isEmpty()) {
            return null;
        }
        else {
            return shelterUpdate(animal);
        }
    }

    private static Animal shelterUpdate(Animal animal) {
        int counter = 0;
        Animal taken = null;
        while (counter < shelter.size()) {
            Animal currentAnimal = shelter.peek();
            if (animal.getName() == currentAnimal.getName() && animal.getID() == currentAnimal.getID()) {
                taken = shelter.remove();
                counter--;
            } else {
                if (animal.getName() == currentAnimal.getName()) {
                    currentAnimal.setID(currentAnimal.getID() - 1);
                }
                shelter.add(shelter.remove());
            }
            counter++;
        }

        return taken;
    }

    @Override
    public String toString() {
        return shelter.toString();
    }

    public static void main(String[] args) {
        Animal[] arr = {new Animal("cat",1), new Animal("cat", 2),
                new Animal("dog", 1), new Animal("dog", 2), new Animal("cat", 3),
                new Animal("dog", 3), new Animal("nyuszi", 1)};
        AnimalShelter test = new AnimalShelter();
        for (Animal animal : arr) {
            add(animal);
        }
        System.out.println(test);
        System.out.println(adopt(new Animal("dog", 1)));
        System.out.println(test);
    }
}

class Animal{
    private int ID;
    private String name;

    public Animal(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return name + "" + ID;
    }
}

