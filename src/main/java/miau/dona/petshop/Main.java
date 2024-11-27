package miau.dona.petshop;

/* 
Make a program that implements the operation of "pet shop". The shop will sell
various types of animals. All animals have in common is that they are characterized by
their sex (which must be MALE or FEMALE), the age of the animal (measured in days)
and EAN code. 

TODO The types of animals they sell are: Cats, Dogs, Birds and Rats. 
 Rats are considered snakes bait.

The characteristics of each of them are as follows:
a) Cat: it has the properties of color, breed, and type of hair.
b) Dog: it has the properties of color, breed, type of hair and if it has
pedigree or not.
c) Birds: it has the properties of color and type.
d) Rats: its property is weight (gr) and size (cm).

The animals eat:
• Dogs: meat, bones and feed.
• Cats: fish and feed.
• Birds: only feed.

TODO When an animal is sold, it should be reflected in some variable to show the number
 of animals that have been sold in the shop. The prices of each animal is (per unit):
• Cat: 50€.
• Dog: 100€ (without pedigree), 200€ (with pedigree).
• Bird:10€
• Rat:2€

Cats and dogs are considered pets. All the pet have a chip that identifies the
animal (positive integer), as well as being able to assign it a name. In addition, when a
pet is sold, it must be assigned the name of the owner (name, surname and DNI).
Birds are sold by recording only the sale of the animal. Rats are sold by kgs and
are not sold smaller than 5 cm in size and 200gr in weight.

Animals can mate as long as one of them is male and the other female and they
are of the same type. Rats are not allowed to mate (prohibited).

The application must perform the following functions:
TODO 1. Sell an animal/s and show its final price.
TODO 2. Show total animals sold.
TODO 3. Show total pets.
TODO 4. Show total dogs, cats, birds and rats sold. 
TODO 5. Show the owner of a pet entering the owner DNI’s.
TODO 6. Show the number chip and name of a pet entering the name.
TODO 7. Showing the characteristics of an animal (sex, age, and its the specific
    characteristics) entering its EAN code.
TODO 8. Show if 2 pets can be mated by asking the owner for the chip number.
TODO 9. To Know if a dog, cat, or bird likes a type of food.*/

import miau.dona.petshop.Animals.Bird;
import miau.dona.petshop.MenuOptions;

import java.util.Scanner;

public class Main {
    static Animal[] animals = Extra.declareAnimals();
    static MenuOptions menuOptions = new MenuOptions();
    static Scanner scanner = new Scanner(System.in);
    static int[] sold = new int[animals.length];
    static int soldPosition = 0;

    public static void main(String[] args) {
        menuOptions.countAnimals(animals);
        menuOptions.classifyAnimals(animals);

        int option = -1;
        
        while (option != 0) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("""
                    \
                    
                    \
                    
                    Welcome to the PetShop menu \
                    
                    (for testing EANCodes are from 1 to 20, check them out on Extra.java) \
                    
                    Select an option only typing the number. TO LEAVE TYPE 0 \
                    
                    \
                    
                    1. Sell an animal/s and show its final price. \
                    
                    2. Show total animals sold. \
                    
                    3. Show total pets. \
                    
                    4. Show total dogs, cats, birds and rats sold. \
                    
                    5. Show the owner of a pet entering the owner DNI’s. \
                    
                    6. Show the number chip and name of a pet entering the name. \
                    
                    7. Showing the characteristics of an animal (sex, age, and its the specific
                    characteristics) entering its EAN code. \
                    
                    8. Show if 2 pets can be mated by asking the owner for the chip number. \
                    
                    9. To Know if a dog, cat, or bird likes a type of food. \
                    
                    \
                    
                    INPUT YOUR NUMBER NOW""");
            Animal animal = null;
            option = scanner.nextInt();
            
            switch (option) {
                case 0 -> {
                    System.out.println("Leaving...");
                }
                case 1 -> {
                    option1();
                }
                
                case 2 -> {
                    option2();
                }
                
                case 3 -> {
                    option3();
                }
                
                case 4 -> {
                    option4();
                }
                
                case 5 -> {
                    option5();
                }
                
                case 6 -> { // FIXME
                    option6();
                }
                
                case 7 -> {
                    option7();
                }
                
                case 8 -> {
                    option8();
                }

                case 9 -> {
                    option9();
                }

                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
    }
    
    public static void option1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me its EANCode");
        int eanCode = scanner.nextInt();

        boolean found = false;

        for (int eancodeIsSold : sold) {
            if (eancodeIsSold == eanCode) {
                found = true;
                System.out.println("Animal has been sold before");
            }
        }

        if (!found) {
            for(Animal animal1 : animals) {
                if(animal1.getEanCode() == eanCode) {
                    menuOptions.sellAnimalShowPrice(animal1);
                    sold[soldPosition] = animal1.getEanCode();
                    soldPosition++;

                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("We couldn't find your animal");
        }

        System.out.println("Want to sell another animal? (Y/N)");

        if (scanner.next().equalsIgnoreCase("Y")) {
            option1();
        }
    }

    public static void option2() {
        menuOptions.showTotalSold();
    }

    public static void option3() {
        menuOptions.showNumberPets();
    }

    public static void option4() {
        menuOptions.showAnimalsSold();
    }

    public static void option5() {
        System.out.println("Enter DNI");
        String dni = scanner.next();

        menuOptions.showOwnPets(dni);
    }

    public static void option6() {
        System.out.println("Names of the pets that has been sold:");
        boolean anyPet = showNameOfSoldPets(); // No encuentra la mascota despues de delcararla y pone aun asi que no hay ninguna.
        
        if (anyPet) {
            System.out.println("\nInput the name of the pet");
            String name = scanner.next();
            menuOptions.showChipAndName(name);
        }
    }

    public static void option7() {
        System.out.println("Enter EANCODE");
        int eanCode = scanner.nextInt();
        menuOptions.showCharasteristics(eanCode,animals);
    }

    public static void option8() {
        System.out.println("Enter first chipnumber");
        System.out.println("(Should be the same as the EANCode for simplicity and testing)");
        int firtschipNumber = scanner.nextInt();

        System.out.println("Enter second chipnumber");
        int secondchipNumber = scanner.nextInt();

        menuOptions.canMate(firtschipNumber, secondchipNumber);
    }

    public static void option9() {
        System.out.println("Give me its EANCode");
        int eanCode = scanner.nextInt();

        System.out.println("What do you want to know if it eats it? ('Meat', 'Fish', Feed', 'Bones')");
        String food = scanner.next();

        for(Animal animal1 : animals) {
            if(animal1.getEanCode() == eanCode) {
                menuOptions.doLikeFood(animal1, food);
                break;
            }
        }
    }

    public static boolean showNameOfSoldPets() {
        if (sold[0] == 0) {
            System.out.println("There are no pets sold");
            return false;
        }

        for (Pet pet : menuOptions.getPets()) {
            for (int soldCode : sold) { // Devuelve null
                if (pet.getEanCode() == soldCode) {
                    System.out.print(pet.getName() + " ");
                }
            }
        }
        return true;
    }
    
}
