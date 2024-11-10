package fr.diginamic.business;

import java.time.LocalDate;

public class Cat extends Animal {
    private String chipId;
    public Cat(LocalDate birth, String Color, PetStore pestStore, String chipId){
        super(birth, Color, pestStore);
        this.chipId = chipId;
    }

    /**
     * Getter pour chipid
     *
     * @return chipid
     */
    public String getChipId() {
        return chipId;
    }

    /**
     * Setter
     *
     * @param chipId chipid
     */
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipid='").append(chipId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
