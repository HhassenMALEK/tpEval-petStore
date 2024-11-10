package fr.diginamic.business;

import jakarta.persistence.*;

@Entity
@Table(name="ADRESSE")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String number;
    @Column(name="Street")
    private String Street;
    @Column(name="ZIPCODE")
    private String zipcode;
    @Column(name="CITY")
    private String city;
    @OneToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore petStore;

    public Adresse() {}

    public Adresse(String name, String street, String zipcode, String city) {
        this.number = name;
        this.Street = street;
        this.zipcode = zipcode;
        this.city = city;
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
     * Getter pour name
     *
     * @return name
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter
     *
     * @param number name
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter pour Street
     *
     * @return Street
     */
    public String getStreet() {
        return Street;
    }

    /**
     * Setter
     *
     * @param Street Street
     */
    public void setStreet(String street) {
        Street = street;
    }

    /**
     * Getter pour zipcode
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
     * Getter pour city
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
     * Getter pour petstore
     *
     * @return petstore
     */
    public PetStore getPetstore() {
        return petStore;
    }

    /**
     * Setter
     *
     * @param petstore petstore
     */
    public void setPetstore(PetStore petstore) {
        this.petStore = petstore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("id=").append(id);
        sb.append(", name='").append(number).append('\'');
        sb.append(", Street='").append(Street).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", petstore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
