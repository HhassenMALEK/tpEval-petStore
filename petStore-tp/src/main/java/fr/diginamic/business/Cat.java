package fr.diginamic.business;

import java.time.LocalDate;

/**
 * Représente un chat (Cat)
 * Hérité de la classe Animal.
 *
 * @author Hassen MALEK
 */
public class Cat extends Animal {
    /**
     * Identifiant unique du chat, représenté sous forme de puce électronique.
     */
    private String chipId;

    /**
     * Instancier un nouveau chat.
     * @param birth
     * @param Color
     * @param pestStore
     * @param chipId
     */
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

    /**
     *Méthode toString pour représenter les informations d'un chat.
     *
     * @return String
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipid='").append(chipId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
