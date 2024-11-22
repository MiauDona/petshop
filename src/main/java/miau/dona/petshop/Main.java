package miau.dona.petshop;

/* 
Make a program that implements the operation of “pet shop”. The shop will sell
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
• Dog:100€ (without pedigree), 200€ (with pedigree).
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
TODO 1. Sell an animal/s and show its final price. FIXME como se identifica al animal
TODO 2. Show total animals sold.
TODO 3. Show total pets.
TODO 4. Show total dogs, cats, birds and rats sold. 
TODO 5. Show the owner of a pet entering the owner DNI’s.
TODO 6. Show the number chip and name of a pet entering the name.
TODO 7. Showing the characteristics of an animal (sex, age, and its the specific
    characteristics) entering its EAN code.
TODO 8. Show if 2 pets can be mated by asking the owner for the chip number.
TODO 9. To Know if a dog, cat, or bird likes a type of food.*/

import miau.dona.petshop.MenuOptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = Extra.declareAnimals();
        
        Scanner scanner = new Scanner(System.in);
        MenuOptions menuOptions = new MenuOptions();
        int option = -1;
        
        while (option != 0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("""
                    Welcome to the PetShop menu \
                    
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
                    
                    INPUT YOUR NUMBER NOW
                    """);
            Animal animal = null;
            option = scanner.nextInt();
            
            switch (option) {
                case 0 -> {
                    System.out.println("Leaving...");
                }
                case 1 -> {
                    System.out.println("Give me its EANCode");
                    int eanCode = scanner.nextInt();
                    for(Animal animal1 : animals) {
                        if(animal1.getEanCode() == eanCode) {
                            menuOptions.sellAnimalShowPrice(animal1);
                            System.out.println("Se ha vendido\n\n\n\n\n");
                            break;
                        }
                    }
                }
                
                case 2 -> {
                    menuOptions.showAnimalsSold();
                }
                
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
    }
    
    
    
}
