package fr.diginamic.business;

import jakarta.persistence.*;


/**
 * Représente un animal dans un PetStore.
 * Entité JPA liée à la table Adresse en BDD.
 *
 * @author Hassen MALEK
 */
@Entity
@Table(name="ADRESSE")
public class Adresse {

    /**
     * Identifiant unique de l'adresse.
     * généré automatiquement par la BDD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    /**
     * Numéro de l'adresse
     */
    @Column(name="NUMBER")
    private String number;

    /**
     * Rue où se trouve l'adresse.
     */
    @Column(name="STREET")
    private String street;

    /**
     * Code postal de l'adresse.
     */
    @Column(name="ZIPCODE")
    private String zipcode;
    /**
     * ville de l'adresse.
     */
    @Column(name="CITY")
    private String city;

    /**
     * Magasin associé à cette adresse.
     * Relation One-To-One avec PetStore, mappée sur la colonne ID_STORE.
     */
    @OneToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore petStore;

    /**
     * Constructeur par défaut requis par JPA.
     */
    public Adresse() {}

    /**
     * Constructeur pour instancier une nouvelle adresse
     * @param name
     * @param street
     * @param zipcode
     * @param city
     */
    public Adresse(String name, String street, String zipcode, String city) {
        this.number = name;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }


    /**
     * Getter
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
     * Getter
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter
     *
     * @param number number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter
     *
     * @return Street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter
     *
     * @param street Street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter
     *
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Setter
     *
     * @param zipcode zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Getter
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter
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
     * Méthode toString pour représenter les informations d'une adresse.
     *
     * @return les informations sous forme de chaîne de caractères
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("id=").append(id);
        sb.append(", name='").append(number).append('\'');
        sb.append(", Street='").append(street).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", petstore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
