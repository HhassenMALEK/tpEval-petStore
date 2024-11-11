package fr.diginamic.business;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Représente un animal de type Animal.
 * Entité JPA liée à la table ANIMAL en BDD.
 *
 * @author Hassen MALEK
 */
@Entity
@Table(name="ANIMAL")
public class Animal implements Serializable {

    /**
     * Identifiant unique de l'adresse,
     * généré automatiquement par la BDD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    /**
     * Date de naissance de l'animal.
     */
    @Column(name="BIRTH")
    private LocalDate birth;

    /**
     * couleur de l'animal.
     */
    @Column(name="COLOR")
    private String color;

    /**
     * PetStore où l'animal se trouve.
     * relation Many-To-One avec PetStore
     */
    @ManyToOne
    @JoinColumn(name="PETSTORE_ID")
    private PetStore petStore;

    /**
     * Constructeur par défaut requis par JPA.
     */
    public Animal() {}

    /**
     *  Instancier un nouvel animal.
     * @param birth la date de naissance de l'animal
     * @param color la couleur de l'animal
     * @param petStore le magasin de type PetStore associé
     */
    public Animal(LocalDate birth, String color, PetStore petStore) {
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    /**
     * Getter pour id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter pour birth
     *
     * @return birth
     */
    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Setter
     *
     * @param birth birth
     */
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    /**
     * Getter pour color
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter
     *
     * @param color color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter pour petStore
     *
     * @return petStore
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Setter
     *
     * @param petStore petStore
     */
    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    /**
     *Méthode toString pour représenter les informations d'un animal.
     *
     * @return String
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", color='").append(color).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}

