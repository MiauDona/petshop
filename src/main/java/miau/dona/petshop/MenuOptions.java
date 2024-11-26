package miau.dona.petshop;
/*
The application must perform the following functions:
1. Sell an animal/s and show its final price.
2. Show total animals sold.
3. Show total pets. // No son las ventas, quiere numerar las mascotas
4. Show total dogs, cats, birds and rats sold.
5. Show the owner of a pet entering the owner DNI’s.
6. Show the number chip and name of a pet entering the name. FIXME no se que otro nombre es

7. Showing the characteristics of an animal (sex, age, and its the specific
        characteristics) entering its EAN code.
8. Show if 2 pets can be mated by asking the owner for the chip number.
9. To Know if a dog, cat, or bird likes a type of food.
 */

import miau.dona.petshop.Animals.Bird;
import miau.dona.petshop.Animals.Cat;
import miau.dona.petshop.Animals.Dog;
import miau.dona.petshop.Animals.Rat;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MenuOptions extends Extra {
    private float moneyAccount = 0;
    private int ratSells = 0;
    private int catSells = 0;
    private int birdSells = 0;
    private int dogSells = 0;
    private int petSells = catSells + birdSells + dogSells;
    private int animalSells = ratSells + catSells + birdSells + dogSells + petSells;
    
    
    public float getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public void sellAnimalShowPrice(Animal animal) {
        float price = animal.getPrice();

        switch (animal) {
            case Pet pet -> {
                if (pet instanceof Dog) {
                    System.out.println("It's a dog");
                    dogSells++;
                } else if (pet instanceof Cat) {
                    System.out.println("It's a cat");
                    catSells++;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write the owner's name (only name)");
                String ownerName = scanner.nextLine();

                System.out.println("Write the owner's surname");
                String surname = scanner.nextLine();

                System.out.println("Owner's DNI (with letter)");
                String dni = scanner.nextLine();

                System.out.println("What's the pet's name?");
                String petName = scanner.nextLine();

                pet.setOwner(ownerName, surname, dni, petName);
                petSells++;
            }
            
            case Rat rat -> {
                System.out.println("It's a rat");
                price = rat.getPrice() * rat.getWeight();
                ratSells++;
            }
            
            case Bird bird -> {
                System.out.println("It's a bird");
                birdSells++;
            }
            
            default -> System.out.println("Animal not recognized. Anyways, it is sold.");
        }
        
        animalSells++;
        this.moneyAccount+= price;

        System.out.println("Sold by " + price + "€");
    }
    
    public void showTotalSold() {
        System.out.println("Animals: " + this.animalSells);
    }
    
    private void showTotalRatSold() {
        System.out.println("Rats: " + this.ratSells);
    }
    
    private void showTotalBirdSold() {
        System.out.println("Birds: " + this.birdSells);
    }
    
    private void showTotalDogSold() {
        System.out.println("Dogs: " + this.dogSells);
    }
    
    private void showTotalCatSold() {
        System.out.println("Cats: " + this.catSells);
    }
    
    public void showAnimalsSold() {
        showTotalRatSold();
        showTotalBirdSold();
        showTotalDogSold();
        showTotalCatSold();
    }
    
    public void showNumberPets() {
        System.out.println(getPets().length-petSells);
    }
    
    public void showOwnPets(String dni) {
        boolean ownsSomething = false;
        for (Pet pet : getPets()) {
            if (pet.getDNI() != null && pet.getDNI().equals(dni)) {
                ownsSomething = true;
                System.out.println("You own " + pet.getName());
            }
        }
        if (!ownsSomething) {
            System.out.println("You don't own any pets");
        }
    }
    
    public void showChipAndName(String name) {
        for (Pet pet : getPets()) {
            if (pet.getName() != null && pet.getName().equals(name)) {
                System.out.println("Name: " + pet.getName() + 
                        "\nChip number: " + pet.getChipNumber() +
                        "\nOwner's name: " + pet.getOwnerName() +
                        "\nOwner surname: " + pet.getSurname());
            }
        }
    }

    public void showCharasteristics(int eanCode, Animal[] animals) {
        for (Animal animal : animals) {
            if (eanCode == animal.getEanCode()) {
                switch (animal) {
                    case Pet pet -> {
                        if (pet instanceof Dog) {
                            System.out.println(((Dog) pet).isPedigree() ? "Is pedigree and its name is " : "Its name is" + pet.getName() + ", its breed is " + ((Dog) pet).getBreed() + ", its color is " + ((Dog) pet).getColor() + ", its hair is " + ((Dog) pet).getTypeHAIR() + ", it is " + pet.getSex() + " and eats: " + Arrays.toString(((Dog) pet).getEats())) ;
                        } else if (pet instanceof Cat) {
                            System.out.println("Its name is " + pet.getName() + ", its breed is " + ((Cat) pet).getBreed() + ", its color is " + ((Cat) pet).getColor() + ", its hair is " + ((Cat) pet).getTypeHAIR() + ", it is " + pet.getSex() + " and eats: " + Arrays.toString(((Cat) pet).getEats()));
                        }
                    }

                    case Rat rat -> {
                        System.out.println("This rat weighs " + ((Rat) rat).getWeight() + " kg, its size is " +
                                ((Rat) rat).getSize() + " cm, it is " + rat.getSex() + ".");
                    }

                    case Bird bird -> {
                        System.out.println("This bird's type is " + ((Bird) bird).getType() + ", its color is " +
                                ((Bird) bird).getColor() + ", it is " + bird.getSex() +
                                " and eats: " + Arrays.toString(((Bird) bird).getEats()));
                    }

                    default -> System.out.println("This animal's species is " + animal.getSpecie() + ", it is " + animal.getSex() + ".");
                }
            }
        }
    }

    public boolean canMate(int chipNumber1, int chipNumber2) {
        Pet pet1 = null;
        Pet pet2 = null;
        
        for (Pet pet : getPets()) {
            if (pet.getChipNumber() == chipNumber1) {
                System.out.println("Pet with id: " + pet.getChipNumber() + "found");
                pet1 = pet;
                System.out.println(pet.getChipNumber());
                
            } else if (pet.getChipNumber() == chipNumber2) {
                System.out.println("Pet with id: " + pet.getChipNumber() + "found");
                pet2 = pet;
                System.out.println(pet.getChipNumber());
            }
        }
        
        System.out.println(pet1 != null ? pet1.getEanCode() : 0);
        System.out.println(pet2 != null ? pet2.getEanCode() : 0);
        
        if (pet1 == null) {
            System.out.println(chipNumber1 + " no se ha encontrado");
            return false;
            
        } else if (pet2 == null) {
            System.out.println(chipNumber2 + " no se ha encontrado");
            return false;
        }
        
        if (pet1.getSex() != pet2.getSex()) {
            System.out.println("They can mate");
            return true;
            
        } else {
            System.out.println("They cannot mate");
            return false;
        }
    }
    
    public boolean doLikeFood(Animal animal, String userFood) {
        if (animal instanceof Rat) {
            System.out.println("It doesn't eat anything from here");
            
        } else {
            for(String food : animal.getEats()) {
                if(food.equals(userFood)) {
                    System.out.println(animal.getSpecie() + " likes " + userFood);
                    return true;
                }
            }
        }

        System.out.println(animal.getSpecie() + " doesn't like " + userFood);
        return false;
    }
    
}
