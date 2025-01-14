package miau.dona.petshop.Animals;

import miau.dona.petshop.Animal;

public class Bird extends Animal {
    String color;
    String type;
    String[] eats = {"Feed"};

    public Bird(int eanCode, int ageDays, char sex, String color, String type) {
        super(eanCode, ageDays, sex, 10);
        this.color = color;
        this.type = type;
        setSpecie("Bird");
        setEats(eats);
    }
    
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
    
}
