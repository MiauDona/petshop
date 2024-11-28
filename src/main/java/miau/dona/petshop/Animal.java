package miau.dona.petshop;

public abstract class Animal {
    private char sex;
    private int ageDays;
    private final int eanCode;
    private int price = 0;
    private String specie;
    private int animalsSold = 0;
    private String[] eats;

    public Animal(int eanCode, int ageDays, char sex, int price) {
        this.eanCode = eanCode;
        this.ageDays = ageDays;
        this.price = price;

        if (sex == 'f' || sex == 'm') {
            this.sex = sex;
        } else {
            this.sex = 'f';
        }
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
    
    public String[] getEats() {
        return eats;
    }
    
    public void setEats(String[] eats) {
        this.eats = eats;
    }
}
