package miau.dona.petshop;

import miau.dona.petshop.Animals.Bird;
import miau.dona.petshop.Animals.Cat;
import miau.dona.petshop.Animals.Dog;
import miau.dona.petshop.Animals.Rat;

import java.util.Objects;

public class Extra {
    private int nPets = 0;
    private Pet[] pets;



    public static Animal[] declareAnimals() {
        Rat rat = new Rat(1, 20, 'f', 10.3f, 2.1f);
        Cat cat = new Cat(2, 243, 'm', "blue", "persa", "Suave", 2);
        Dog dog = new Dog(3, 243, 'm', "naranja", "labrador", "Suave", true, 3);
        Bird bird = new Bird(4, 34, 'f', "rojo", "Loro");
        Rat rat2 = new Rat(5, 15, 'm', 9.1f, 1.8f);
        Cat cat2 = new Cat(6, 222, 'f', "green", "siamés", "Lento", 6);
        Dog dog2 = new Dog(7, 365, 'f', "marrón", "golden retriever", "Activo", false, 7);
        Bird bird2 = new Bird(8, 24, 'm', "amarillo", "canario");
        Rat rat3 = new Rat(9, 18, 'f', 8.7f, 1.9f);
        Cat cat3 = new Cat(10, 101, 'm', "negro", "maine coon", "Lento", 10);
        Dog dog3 = new Dog(11, 320, 'f', "gris", "beagle", "Activo", true, 11);
        Bird bird3 = new Bird(12, 29, 'm', "verde", "periquito");
        Rat rat4 = new Rat(13, 14, 'm', 10.2f, 2.4f);
        Cat cat4 = new Cat(14, 132, 'f', "blanco", "ragdoll", "Suave", 14);
        Dog dog4 = new Dog(15, 412, 'm', "negro", "bulldog", "Suave", false, 15);
        Bird bird4 = new Bird(16, 40, 'f', "azul", "cotorra");
        Rat rat5 = new Rat(17, 22, 'm', 12.5f, 2.2f);
        Cat cat5 = new Cat(18, 213, 'm', "gris", "bengalí", "Rápido", 18);
        Dog dog5 = new Dog(19, 298, 'f', "blanco", "poodle", "Suave", true, 19);
        Bird bird5 = new Bird(20, 19, 'm', "morado", "canario");
        
        return new Animal[] {rat, dog, bird, cat, rat2, rat3, rat4, rat5, dog2, dog3, dog4, dog5, bird2,
                bird3, bird4, bird5, cat2, cat3, cat4, cat5};
    }

    public void countPets(Animal[] animals) {
        for (Animal animal : animals) {
            if (Objects.requireNonNull(animal) instanceof Pet) {
                this.nPets++;
            }
        }
    }


    public void classifyPets(Animal[] animals) {
        this.pets = new Pet[this.nPets];
        
        for (Animal animal : animals) {
            if (Objects.requireNonNull(animal) instanceof Pet pet) {
                nPets--;
                pets[nPets] = pet;
            }
        }
    }

    public Pet[] getPets() {
        return pets;
    }
}
