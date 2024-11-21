package miau.dona.petshop;
/*
The application must perform the following functions:
1. Sell an animal/s and show its final price.
2. Show total animals sold.
3. Show total pets. // No son las ventas, quiere numerar las mascotas
4. Show total dogs, cats, birds and rats sold.
5. Show the owner of a pet entering the owner DNI’s.
TODO 6. Show the number chip and name of a pet entering the name.
TODO 7. Showing the characteristics of an animal (sex, age, and its the specific
        characteristics) entering its EAN code.
TODO 8. Show if 2 pets can be mated by asking the owner for the chip number.
TODO 9. To Know if a dog, cat, or bird likes a type of food.*/

import miau.dona.ejerciciosclase.clases.petshop.Animals.Bird;
import miau.dona.ejerciciosclase.clases.petshop.Animals.Cat;
import miau.dona.ejerciciosclase.clases.petshop.Animals.Dog;
import miau.dona.ejerciciosclase.clases.petshop.Animals.Rat;

public class MenuOptions extends Extra {
    private int moneyAccount = 0;
    private int ratSells = 0;
    private int catSells = 0;
    private int birdSells = 0;
    private int dogSells = 0;
    private int petSells = catSells + birdSells + dogSells;
    private int animalSells = ratSells + catSells + birdSells + dogSells + petSells;

    public int getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public void sellAnimalShowPrice(Animal animal) {
        switch (animal) {
            case Pet pet -> {
                if (pet instanceof Dog) {
                    dogSells++;
                } else if (pet instanceof Cat) {
                    catSells++;
                }
                pet.setOwner("Dueño", "Apellido", "894523j", "animalito");
                petSells++;
            }
            
            case Rat rat -> {
                ratSells++;
            }
            
            case Bird bird -> {
                birdSells++;
            }
            
            default -> System.out.println("No se reconoce ese animal, pero se contara una venta generica");
        }
        
        animalSells++;
        this.moneyAccount+= animal.getPrice();
        System.out.println(animal.getPrice());
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
        System.out.println(getPets().length); 
    }
    
    public void showOwnPets(String dni) {
        for (Pet pet : getPets()) {
            if (pet.getDNI().equals(dni)) {
                System.out.println(pet);
            }
        }
    }
    
    public void showChipAndName(String ownerName) {
        for (Pet pet : getPets()) {
            if (pet.getOwnerName().equals(name)) {
                System.out.println(pet);
            }
        }
    }
    
}
