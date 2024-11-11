package fr.diginamic.business;

import fr.diginamic.enums.FishLivEnv;

import java.time.LocalDate;

/**
 * Représente un poisson (fish)
 * Hérité de la classe Animal.
 *
 * @author Hassen MALEK
 */

public class Fish extends Animal {
    /**
     *  Environnement de vie du poisson, déterminé par l'énumération FishLivEnv.
     *
     */
    private FishLivEnv livingEnv;

    /**
     * Instancier un nouveau poisson.
     * @param birth
     * @param color
     * @param petStore
     * @param livingEnv
     */
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

    /**
     *Méthode toString pour représenter les informations d'un poisson.
     *
     * @return String
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
