package miau.dona.petshop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuOptions menuOptions = new MenuOptions();
        Scanner scanner = new Scanner(System.in);

        int option = -1;
        
        while (option != 0) {
            System.out.println("""
                    Welcome to the PetShop menu \
                    
                    (for testing EANCodes are from 1 to 20, check them out on Extra.java) \
                    
                    (and anyways, all options are shown when selecting an option for an easier test) \
                    
                    Select an option only typing the number. TO LEAVE TYPE 0 \
                    
                    \
                    
                    1. Sell an animal/s and show its final price. \
                    
                    2. Show total animals sold. \
                    
                    3. Show total pets left. \
                    
                    4. Show total dogs, cats, birds and rats sold. \
                    
                    5. Show the owner of a pet entering the owner DNI’s. \
                    
                    6. Show the number chip and name of a pet entering the name of the pet. \
                    
                    7. Showing the characteristics of an animal (sex, age, and its the specific
                    characteristics) entering its EAN code. \
                    
                    8. Show if 2 pets can be mated by asking the owner for the chip number. \
                    
                    9. To Know if a dog, cat, or bird likes a specific type of food. \
                    
                    \
                    
                    INPUT YOUR NUMBER NOW""");
            option = scanner.nextInt();
            
            switch (option) {
                case 0 -> {
                    System.out.println("Leaving...");
                }
                case 1 -> {
                    System.out.println("1. Sell an animal/s and show its final price.");
                    menuOptions.option1();
                }
                
                case 2 -> {
                    System.out.println("2. Show total animals sold.");
                    menuOptions.option2();
                }
                
                case 3 -> {
                    System.out.println("3. Show total pets left.");
                    menuOptions.option3();
                }
                
                case 4 -> {
                    System.out.println("4. Show total dogs, cats, birds and rats sold.");
                    menuOptions.option4();
                }
                
                case 5 -> {
                    System.out.println("5. Show the owner of a pet entering the owner DNI’s.");
                    menuOptions.option5();
                }
                
                case 6 -> {
                    System.out.println("6. Show the number chip and name of a pet entering the name of the pet.");
                    menuOptions.option6();
                }
                
                case 7 -> {
                    System.out.println("7. Showing the characteristics of an animal (sex, age, and its the specific\n" +
                            "characteristics) entering its EAN code.");
                    menuOptions.option7();
                }
                
                case 8 -> {
                    System.out.println("8. Show if 2 pets can be mated by asking the owner for the chip number.");
                    menuOptions.option8();
                }

                case 9 -> {
                    System.out.println("9. To Know if a dog, cat, or bird likes a specific type of food.");
                    menuOptions.option9();
                }

                default -> {
                    System.out.println("Invalid option");
                }
            }
            if (option != 1) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            menuOptions.spaceLines();
        }
    }
}

/*
Make a program that implements the operation of "pet shop". The shop will sell
various types of animals. All animals have in common is that they are characterized by
their sex (which must be MALE or FEMALE), the age of the animal (measured in days)
and EAN code.

The types of animals they sell are: Cats, Dogs, Birds and Rats.
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

When an animal is sold, it should be reflected in some variable to show the number
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
 1. Sell an animal/s and show its final price.
 2. Show total animals sold.
 3. Show total pets.
 4. Show total dogs, cats, birds and rats sold.
 5. Show the owner of a pet entering the owner DNI’s.
 6. Show the number chip and name of a pet entering the name.
 7. Showing the characteristics of an animal (sex, age, and its the specific
characteristics) entering its EAN code.
 8. Show if 2 pets can be mated by asking the owner for the chip number.
 9. To Know if a dog, cat, or bird likes a type of food.*/