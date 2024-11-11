package fr.diginamic.business;

import fr.diginamic.enums.ProdType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * représente un produit de type Product.
 * Entité JPA liée a la table PRODUCT en BDD.
 *
 * author Hassen MALEK
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

    /**
     * Identifiant unique du Produit,
     * généré automatiquement par la BDD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    /**
     * code du produit.
     */
    @Column(name="CODE")
    private  String code;

    /**
     * labes du produit
     */
    @Column(name="LABEL")
    private String label ;

    /**
     * type de produit
     */
    @Column(name="TYPE")
    private ProdType type;

    /**
     * prix du produit
     */
    @Column(name="PRICE")
    private double price;

    /**
     *Liste des magasins où le produit est en stock.
     * relation Many-To-Many avec PetStore.
     */
    @ManyToMany(mappedBy = "products" )
    private Set<PetStore> petStores;

    /**
     * Liste des magasins ou le produit est en stock.
     * Chaque animal et produit ne peut être présent qu'une seule fois.
     */
    {
        petStores = new HashSet<>();
    }

    /**
     * Constructeur par défaut requis par JPA.
     */
    public Product() {}

    /**
     * Instancier un nouveau produit.
     * @param code
     * @param label
     * @param type
     * @param price
     */
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
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
     * Getter pour code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter pour label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter
     *
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter pour type
     *
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter
     *
     * @param type type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter pour price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter
     *
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter pour petStores
     *
     * @return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter
     *
     * @param petStores petStores
     */
    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    /**
     *Méthode toString pour représenter les informations d'un produit.
     *
     * @return String
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petStores=").append(petStores);
        sb.append('}');
        return sb.toString();
    }

}
