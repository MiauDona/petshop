package miau.dona.petshop;

public abstract class Pet extends Animal {
    private int chipNumber;
    private String name;
    private String surname;
    private String DNI;
    private String ownerName;
    
    public Pet(int eanCode, int ageDays, char sex, int price, int chipNumber) {
        super(eanCode, ageDays, sex, price);
        this.chipNumber = chipNumber;
    }
    
    public int getChipNumber() {
        return chipNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwner(String ownerName, String surname, String DNI, String name) {
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
        this.ownerName = ownerName;
    }
    
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getDNI() {
        return DNI;
    }
}
