package fr.diginamic.business;

import fr.diginamic.enums.FishLivEnv;

import java.time.LocalDate;

public class Fish extends Animal {
    private FishLivEnv livingEnv;

    public Fish(LocalDate birth, String color, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, color, petStore);
        this.livingEnv = livingEnv;
    }

    /**
     * Getter pour livingEnv
     *
     * @return livingEnv
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Setter
     *
     * @param livingEnv livingEnv
     */
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
