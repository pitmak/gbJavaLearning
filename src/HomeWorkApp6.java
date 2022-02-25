/**
 * ДЗ №6
 *
 * @author pitmak
 * @version 25.02.2022
 */
public class HomeWorkApp6 {
    public static void main(String[] args) {
        InterAnimalActions[] animals = {
                new Cat("Мурзик"),
                new Dog("Бобик"),
                new Cat("Гарфилд"),
                new Dog("Шарик")
        };

        int[] testData = {100, 100, 300, 5, 300, 300, 600, 50};
        int i = 0;
        for (InterAnimalActions animal : animals) {
            System.out.println(animal.run(testData[i++]));
            System.out.println(animal.swim(testData[i++]));
        }

        System.out.println("----------------------------------");

        int animalsCount = 0;
        int catsCount = 0;
        int dogsCount = 0;
        for (InterAnimalActions animal : animals) {
            if (animal.getClass() == Cat.class) {
                animalsCount++;
                catsCount++;
            } else if (animal.getClass() == Dog.class) {
                animalsCount++;
                dogsCount++;
            }
        }
        System.out.println("Животных в массиве: " + animalsCount);
        System.out.println("Кошек в массиве: " + catsCount);
        System.out.println("Собак в массиве: " + dogsCount);
    }
}

interface InterAnimalActions {
    String run(int distance);

    String swim(int distance);
}

abstract class Animal implements InterAnimalActions {
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    Animal(String name) {
        this.name = name;
    }

    public String run(int distance) {
        if (distance <= maxRunDistance) {
            return name + " успешно пробежал " + distance;
        } else {
            return name + " смог пробежать " + maxRunDistance + " и упал(";
        }
    }

    public String swim(int distance) {
        if (distance <= maxSwimDistance) {
            return name + " успешно проплыл " + distance;
        } else {
            return name + " смог проплыть " + maxSwimDistance + " и утонул(";
        }
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
        maxRunDistance = 200;
    }

    public String swim(int distance) {
        return name + " сразу утонул(((";
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
        maxRunDistance = 500;
        maxSwimDistance = 10;
    }
}


