package fr.diginamic.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Représente un magasin de type PetStore.
 * Entité JPA liée à la table PETSTORE en BDD.
 *
 * @author Hassen MALEK
 */

@Entity@Table(name="PETSTORE")
public class PetStore {

    /**
     * Identifiant unique du magasin,
     * généré automatiquement par la BDD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    /**
     * Nom du magasin.
     */
    @Column(name="NAME")
    private String name;

    /**
     * nom du manager du magasin.
     */
    @Column(name="MANAGER_NAME")
    private String managerName;

    /*
    * Adresse du magasin
    * relation One-To-One avec Adresse.
    */
    @OneToOne(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Adresse adresse;

    /**
     * Liste des produits disponibles dans le magasin.
     * Relation Many-To-Many avec la classe Product.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PRODUCT_PETSTORE",
    joinColumns= @JoinColumn(name="PETSTORE_ID", referencedColumnName="ID"),
    inverseJoinColumns = @JoinColumn(name="PRODUCT_ID", referencedColumnName = "ID"))
    private Set<Product> products;

    /**
     *  Liste des animaux présents dans le magasin.
     *  relation One-TO-Many avec Animal.
     */
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Set<Animal> animals;

    /**
     * Liste des animaux et produits en stock.
     * Chaque animal et produit ne peut être présent qu'une seule fois.
     */
    {
        products = new HashSet<>();
        animals = new HashSet<>();
    }

    /**
     * Constructeur par défaut requis par JPA.
     */
    public PetStore() {}

    /**
     * Instancier un nouveau PetStore.
     * @param name
     * @param managerName
     */
    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    /**
     * Associe une adresse au magasin
     * @param adresse nouvelle adresse à associer
     */
    public void addAdresse(Adresse adresse){
        if(adresse != null){
            this.adresse = adresse;
            adresse.setPetStore(this);
        }
    }

    /**
     * Ajoute un animal au magasin
     * @param animal nouvel animal à associer
     */
    public void addAnimal(Animal animal){
        if(animal != null){
            animals.add(animal);
            animal.setPetStore(this);
        }
    }
    /**
     * Retire un animal du magasin
     * @param animal nimal à retirer
     */
    public void remouveAnimal(Animal animal){
        if(animal != null){
            this.getAnimals().remove(animal);
        }
    }

    /**
     * Ajoute un produit au magasin
     * @param product nouveau prodiut à ajouter
     */
    public void addProduct(Product product){
        if(product != null){
            this.products.add(product);

        }
    }

    /**
     * retire un produit du magasin
     * @param product prioduit à retirer
     */
    public void removeProduct(Product product){
        if(product != null){
            this.getProducts().remove(product);
        }
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
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour managerName
     *
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter
     *
     * @param managerName managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter pour products
     *
     * @return products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Setter
     *
     * @param products products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Getter pour animals
     *
     * @return animals
     */
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Setter
     *
     * @param animals animals
     */
    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Getter pour adresse
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter
     *
     * @param adresse adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    /**
    *Méthode toString pour représenter les informations d'un magasin.
    *
    * @return String
    */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", products=").append(products);
        sb.append(", animals=").append(animals);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}
