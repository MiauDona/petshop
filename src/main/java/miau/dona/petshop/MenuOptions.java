package miau.dona.petshop;

import miau.dona.petshop.Animals.Bird;
import miau.dona.petshop.Animals.Cat;
import miau.dona.petshop.Animals.Dog;
import miau.dona.petshop.Animals.Rat;

import java.util.Scanner;

public class MenuOptions extends Extra {
    private float moneyAccount = 0;
    private int ratSells = 0;
    private int catSells = 0;
    private int birdSells = 0;
    private int dogSells = 0;
    private int petSells = 0;
    private int animalSells = 0;
    private final Animal[] animals = Extra.declareAnimals();

    // Array of EANCodes of the animals that has been sold
    int[] sold = new int[animals.length];

    // Aux variable that increases when an animal is sold to save its EANCode in this position
    int soldPosition = 0;
    
    MenuOptions() {
        countPets(getAnimals());
        classifyPets(getAnimals());
    }

    public void sellAnimalShowPrice(Animal animal) {
        float price = animal.getPrice();
        
        // If it is a pet, ask the user the info required
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
            
            case Bird ignored -> {
                System.out.println("It's a bird");
                birdSells++;
            }
            
            default -> System.out.println("Animal not recognized. Anyways, it is sold.");
        }
        
        animalSells++;
        this.moneyAccount+= price;

        System.out.println("Sold by " + price + "€");
        System.out.println("Money in account: " + this.moneyAccount);
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
        System.out.println("Pets left in stock: " + (getPets().length-petSells));
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
        boolean found = false;
        for (Pet pet : getPets()) {
            if (pet.getName() != null && pet.getName().trim().equalsIgnoreCase(name.trim())) {
                System.out.println("Name: " + pet.getName() + 
                        "\nChip number: " + pet.getChipNumber() +
                        "\nOwner's name: " + pet.getOwnerName() +
                        "\nOwner surname: " + pet.getSurname());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No chip number found");
        }
        
    }
    
    public void showCharasteristics(int eanCode, Animal[] animals) {
        // If finds the animal by eancode then shows the charasteristics of it
        for (Animal animal : animals) {
            if (eanCode == animal.getEanCode()) {
                showMessageForShowingCharasteristics(animal);
            }
        }
    }
    
    public void showMessageForShowingCharasteristics(Animal animal) {
        
        // Tells if the animal is female or male because the sex variable is a char
        String sex = animal.getSex() == 'f' ? "female" : "male";
            
        // Detects which animal it is and shows a message depending on it.
        switch (animal) {
                case Dog dog -> {
                    String pedigreePhrase = dog.isPedigree() ? " is pedigree " : " is not pedigree";
                    System.out.println((dog.getName() == null ? ("This dog is not sold yet and its breed is " + dog.getBreed() + pedigreePhrase + ", its color is " + dog.getColor() + ", its hair is " + dog.getTypeHAIR() + ", \nit's  " + sex + " and is been alive " + dog.getAgeDays() + " days ")
                            : "Its name is " + dog.getName() + pedigreePhrase +", its owner is " + dog.getOwnerName() + " " + dog.getSurname()
                            + ", its breed is " + dog.getBreed() + ", its color is " + dog.getColor() + ", its hair is " + dog.getTypeHAIR() + " and is been alive " +dog.getAgeDays() + " days "));

                }

                case Cat cat -> {
                    System.out.println((cat.getName() == null ? ("This cat is not sold yet and its breed is " + cat.getBreed() + ", its color is " + cat.getColor() + ", its hair is " + cat.getTypeHAIR() + ", \nit's  " + sex +" and is been alive " + cat.getAgeDays() + " days ") :
                            ("Its name is " + cat.getName() + ", its owner is " + cat.getOwnerName() + " " + cat.getSurname()) + ", its breed is " + cat.getBreed() + ", its color is " + cat.getColor() + ", \nits hair is " + cat.getTypeHAIR() +  ", its  " + sex + " and is been alive " +cat.getAgeDays() + " days "));
                }

                case Rat rat -> {
                    System.out.println("This rat weighs " + ((Rat) rat).getWeight() + " kg, its size is " +
                            ((Rat) rat).getSize() + " cm, it is " +  ", and it's  " + sex);
                }

                case Bird bird -> {
                    System.out.println("This bird's type is " + ((Bird) bird).getType() + ", its color is " +
                            ((Bird) bird).getColor() + ", and it is " + sex);
                }

                default -> System.out.println("This animal's specie is " + animal.getSpecie() + ", it is " + sex + ".");
            }
        }
        
    public void canMate(int chipNumber1, int chipNumber2) {
        Pet pet1 = null;
        Pet pet2 = null;
        
        // Finds the chipNumber of the parameters and if it finds them, saves the animal with that chipnumber
        for (Pet pet : getPets()) {
            if (pet.getChipNumber() == chipNumber1) {
                pet1 = pet;
                
            } else if (pet.getChipNumber() == chipNumber2) {
                pet2 = pet;
            }
        }
        
        // If any pet is not found don't finish the code execution
        if (pet1 == null) {
            System.out.println(chipNumber1 + " not found");
            return;
            
        } else if (pet2 == null) {
            System.out.println(chipNumber2 + " not found");
            return;
        }
        
        // If both sex are different (male and female) they can mate
        if (pet1.getSex() != pet2.getSex()) {
            System.out.println("They can mate");

        } else {
            System.out.println("They cannot mate");
        }
    }
    
    public void doLikeFood(Animal animal, String userFood) {
        if (animal instanceof Rat) {
            System.out.println("It doesn't eat anything from here");
            
        } else {
            for(String food : animal.getEats()) {
                if(food.equals(userFood)) {
                    System.out.println(animal.getSpecie() + " likes " + userFood);
                    return;
                }
            }
        }

        System.out.println(animal.getSpecie() + " doesn't like " + userFood);
    }

    public void option1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here are all EANCodes in stock");
        showAllEANCodes();

        System.out.println("\nGive me its EANCode");
        int eanCode = scanner.nextInt();

        if (eanCode <= 0) {
            System.out.println("EAN Code must be a positive integer");
            option1();
        }
        
        boolean found = false;

        // Looks for the animal in the sold array to know if it has been sold
        for (int eancodeIsSold : sold) {
            if (eancodeIsSold == eanCode) {
                found = true;
                System.out.println("Animal has been sold before");
            }
        }
        
        // If it's not sold then sell it and add it to the sold array
        if (!found) {
            for(Animal animal1 : animals) {
                if(animal1.getEanCode() == eanCode) {
                    sellAnimalShowPrice(animal1);
                    sold[soldPosition] = animal1.getEanCode();
                    soldPosition++;

                    found = true;
                    break;
                }
            }
        }
        
        // If the animal is not found then is not sold and send this message
        if (!found) {
            System.out.println("We couldn't find your animal");
        }

        // Ask the user to sell another
        System.out.println("Want to sell another animal? (Y/N)");

        if (scanner.next().equalsIgnoreCase("Y")) {
            option1();
        }
    }

    public void option2() {
        showTotalSold();
    }

    public void option3() {
        showNumberPets();
    }

    public void option4() {
        showAnimalsSold();
    }

    public void option5() {
        // Show all options and if there are no pets then the user can't do anything and returns back to the menu
        boolean anyPet = showDNIOfSoldPets();
        Scanner scanner = new Scanner(System.in);
        
        if (anyPet) {
            System.out.println("Enter DNI");
            String dni = scanner.next();

            showOwnPets(dni);
        } else {
            System.out.println("There are no pets with owner");
        }

    }

    public void option6() {
        // Show all options and if there are no pets then the user can't do anything and returns back to the menu
        boolean anyPet = showNameOfSoldPets();
        Scanner scanner = new Scanner(System.in);
        if (anyPet) {
            System.out.println("\nChoose the name of your pet");
            String name = scanner.next();
            showChipAndName(name);
        } else {
            System.out.println("There are no pets sold");
        }


    }

    public void option7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter EANCODE");
        int eanCode = scanner.nextInt();
        showCharasteristics(eanCode, animals);

        System.out.println("Do you want to see another animal? (Y/N)");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("Y")) {
            option7();
        }
    }

    public void option8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chip numbers:");
        showChipNumbers();
        
        System.out.println("\nEnter first chipnumber");
        int firtschipNumber = scanner.nextInt();

        System.out.println("Enter second chipnumber");
        int secondchipNumber = scanner.nextInt();

        canMate(firtschipNumber, secondchipNumber);
    }

    public void option9() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give me its EANCode");
        int eanCode = scanner.nextInt();

        System.out.println("What do you want to know if it eats it? ('Meat', 'Fish', Feed', 'Bones')");
        String food = scanner.next();

        for(Animal animal1 : animals) {
            if(animal1.getEanCode() == eanCode) {
                doLikeFood(animal1, food);
                break;
            }
        }
    }

    public boolean showNameOfSoldPets() {
        boolean isAnyPetSold = false;

        for (Pet pet : getPets()) {
            for (int soldCode : sold) {
                if (pet.getEanCode() == soldCode) {
                    isAnyPetSold = true;
                    System.out.print("[" + pet.getName() + "] ");
                }
            }
        }
        if (isAnyPetSold) {
            System.out.println("\nIn the line before there are the name(s) of the pets' owners of pets that has been sold");
        }

        return isAnyPetSold;
    }

    public boolean showDNIOfSoldPets() {
        boolean isAnyPetSold = false;

        for (Pet pet : getPets()) {
            for (int soldCode : sold) {
                if (pet.getEanCode() == soldCode) {
                    isAnyPetSold = true;
                    System.out.print("[" + pet.getDNI() + "] ");
                }
            }
        }
        if (isAnyPetSold) {
            System.out.println("\nIn the line before there are the DNI(s) of the pets' owners of pets that has been sold");
        }

        return isAnyPetSold;
    }

    public void spaceLines() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void showAllEANCodes() {
        System.out.print("[");

        // Shows all animals that aren't in the sold array
        for (Animal animal : animals) {
            boolean isSold = false;

            for (int i : sold) {
                if (animal.getEanCode() == i) {
                    isSold = true;
                    break;
                }
            }

            if (!isSold) {
                System.out.print("[" + animal.getEanCode() + "]");
            }
        }
        System.out.print("]");
    }
    
    public void showChipNumbers() {
        for (Pet pet : getPets()) {
            System.out.print("[" + pet.getChipNumber() + "]");
        }
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
