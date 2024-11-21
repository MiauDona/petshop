package miau.dona.petshop.Animals;

import miau.dona.ejerciciosclase.clases.petshop.Pet;

public class Dog extends Pet {
    String color;
    String breed;
    String typeHAIR;
    boolean pedigree;
    String[] eats = { "Meat", "Bones", "Feed"};
    
    public Dog(int eanCode, int ageDays, char sex, String color, String breed, String typeHAIR, boolean pedigree, int chipNumber) {
        super(eanCode, ageDays, sex, pedigree ? 200 : 100, chipNumber);
        this.color = color;
        this.breed = breed;
        this.typeHAIR = typeHAIR;
        this.pedigree = pedigree;
        setSpecie("Dog");
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

    public boolean isPedigree() {
        return pedigree;
    }

    public String[] getEats() {
        return eats;
    }
}
