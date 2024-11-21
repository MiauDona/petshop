package miau.dona.petshop.Animals;

import miau.dona.ejerciciosclase.clases.petshop.Animal;

public class Rat extends Animal {
    float weight;
    float size;
    
    public Rat(int eanCode, int ageDays, char sex ,float weight, float size) {
        super(eanCode, ageDays, sex, 2);
        this.weight = weight;
        this.size = size;
        setSpecie("Rat");
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
