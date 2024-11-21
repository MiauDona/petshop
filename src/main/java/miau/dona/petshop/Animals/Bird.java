package miau.dona.petshop.Animals;

import miau.dona.ejerciciosclase.clases.petshop.Animal;

public class Bird extends Animal {
    String color;
    String type;
    String[] eats = {"Feed"};
    
    public Bird(int eanCode, int ageDays, char sex, String color, String type) {
        super(ageDays, eanCode, sex, 10);
        this.color = color;
        this.type = type;
        setSpecie("Bird");
    }

    public String[] getEats() {
        return eats;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
    
}
