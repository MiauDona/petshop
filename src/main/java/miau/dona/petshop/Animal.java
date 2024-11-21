package miau.dona.petshop;

import java.util.Objects;

public abstract class Animal {
    private char sex;
    private int ageDays;
    private final int eanCode;
    private int price = 0;
    private String specie;
    private int animalsSold = 0;

    public Animal(int eanCode, int ageDays, char sex, int price) {
        this.eanCode = eanCode;
        this.ageDays = ageDays;
        this.sex = sex;
        this.price = price;
    }
    
    public boolean canMate(Animal couple) {
        return getSex() != couple.getSex() && Objects.equals(getSpecie(), couple.getSpecie());
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
    
    public String getSpecie() {
        return specie;
    }

    public int getEanCode() {
        return eanCode;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    public int getPrice() {
        return price;
    }
}
