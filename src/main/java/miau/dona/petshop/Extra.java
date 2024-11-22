package miau.dona.petshop;

import miau.dona.petshop.Animals.Bird;
import miau.dona.petshop.Animals.Cat;
import miau.dona.petshop.Animals.Dog;
import miau.dona.petshop.Animals.Rat;

public class Extra {
    private int nPets = 0;
    private int nRats = 0;
    private int nBirds = 0;
    private int nCats = 0;
    private int nDogs = 0;
    private Pet[] pets;
    private Rat[] rats;
    private Bird[] birds;
    private Cat[] cats;
    private Dog[] dogs;
    
    public static Animal[] declareAnimals() {
        Rat rat = new Rat(13241513, 20, 'f', 10.3f, 2.1f);
        Cat cat = new Cat(253245, 243, 'm', "blue", "persa", "Suave", 3241);
        Dog dog = new Dog(25323545, 243, 'm', "naranja", "labrador", "Suave", true, 356);
        Bird bird = new Bird(43523, 34, 'f', "rojo", "Loro");
        Rat rat2 = new Rat(15462134, 15, 'm', 9.1f, 1.8f);
        Cat cat2 = new Cat(423154, 222, 'f', "green", "siamés", "Lento", 1457);
        Dog dog2 = new Dog(768521, 365, 'f', "marrón", "golden retriever", "Activo", false, 456);
        Bird bird2 = new Bird(12365, 24, 'm', "amarillo", "canario");
        Rat rat3 = new Rat(147258, 18, 'f', 8.7f, 1.9f);
        Cat cat3 = new Cat(785612, 101, 'm', "negro", "maine coon", "Lento", 2123);
        Dog dog3 = new Dog(125478, 320, 'f', "gris", "beagle", "Activo", true, 578);
        Bird bird3 = new Bird(568973, 29, 'm', "verde", "periquito");
        Rat rat4 = new Rat(2365478, 14, 'm', 10.2f, 2.4f);
        Cat cat4 = new Cat(987654, 132, 'f', "blanco", "ragdoll", "Suave", 1324);
        Dog dog4 = new Dog(852963, 412, 'm', "negro", "bulldog", "Suave", false, 289);
        Bird bird4 = new Bird(956478, 40, 'f', "azul", "cotorra");
        Rat rat5 = new Rat(7412589, 22, 'm', 12.5f, 2.2f);
        Cat cat5 = new Cat(654321, 213, 'm', "gris", "bengalí", "Rápido", 3012);
        Dog dog5 = new Dog(654987, 298, 'f', "blanco", "poodle", "Suave", true, 435);
        Bird bird5 = new Bird(486395, 19, 'm', "morado", "canario");
        
        return new Animal[] {rat, dog, bird, cat, rat2, rat3, rat4, rat5, dog2, dog3, dog4, dog5, bird2,
                bird3, bird4, bird5, cat2, cat3, cat4, cat5};

    }

    public void countAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            switch (animal) {
                case Pet petTest ->  {
                    if (petTest instanceof Dog) {
                        this.nDogs++;
                    } else if (petTest instanceof Cat) {
                        this.nCats++;
                    }
                    this.nPets++;
                }
                case Rat ignored -> this.nRats++;
                case Bird ignored -> this.nBirds++;
                default -> System.out.println("Animal no reconocido");
            }
        }
    }
    public void classifyAnimals(Animal[] animals) {
        this.pets = new Pet[this.nPets];
        this.rats = new Rat[this.nRats];
        this.birds = new Bird[this.nBirds];
        this.cats = new Cat[this.nCats];
        this.dogs = new Dog[this.nDogs];
        
        for (Animal animal : animals) {
            switch (animal) {
                case Pet petTest ->  {
                    if (petTest instanceof Dog) {
                        this.nDogs--;
                        this.dogs[nDogs] = (Dog) petTest;
                    } else if (petTest instanceof Cat) {
                        nCats--;
                        cats[nCats] = (Cat) petTest;
                    }
                    nPets--;
                    pets[nPets] = petTest;
                }
                case Rat ratTest -> {
                    nRats--;
                    rats[nRats+1] = (Rat) ratTest;
                }
                case Bird birdTest -> {
                    nBirds--;
                    birds[nBirds] = (Bird) birdTest;
                }
                default -> System.out.println("Animal no reconocido");
            }
        }
    }

    public Bird[] getBirds() {
        return birds;
    }

    public Pet[] getPets() {
        return pets;
    }

    public Rat[] getRats() {
        return rats;
    }

    public Dog[] getDogs() {
        return dogs;
    }

    public Cat[] getCats() {
        return cats;
    }
}
