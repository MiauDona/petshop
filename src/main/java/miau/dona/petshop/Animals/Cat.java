package miau.dona.petshop.Animals;

import miau.dona.petshop.Pet;

public class Cat extends Pet {
    String color;
    String breed;
    String typeHAIR;
    String[] eats = { "Fish", "Feed"};
    
    public Cat(int eanCode, int ageDays, char sex, String color, String breed, String typeHAIR, int chipNumber) {
        super(eanCode, ageDays, sex, 50, chipNumber);
        this.color = color;
        this.breed = breed;
        this.typeHAIR = typeHAIR;
        setSpecie("Cat");
        setEats(eats);
    }

    public String getColor() {
        return color;
    }

    public String getBreed() {
        return breed;
    }

    public String getTypeHAIR() {
        return typeHAIR;
    }

    public String[] getEats() {
        return eats;
    }
}
