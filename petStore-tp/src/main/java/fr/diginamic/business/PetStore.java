package fr.diginamic.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity@Table(name="PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="MANAGER_NAME")
    private String managerName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PRODUCT_PETSTORE",
    joinColumns= @JoinColumn(name="PETSTORE_ID", referencedColumnName="ID"),
    inverseJoinColumns = @JoinColumn(name="PRODUCT_ID", referencedColumnName = "ID"))
    private Set<Product> products;
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Set<Animal> animals;
    @OneToOne(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Adresse adresse;

    {
        products = new HashSet<>();
        animals = new HashSet<>();
    }

    public PetStore() {}

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }
    public void addAdresse(Adresse adresse){
        if(adresse != null){
            this.adresse = adresse;
            adresse.setPetstore(this);
        }
    }

    public void addAnimal(Animal animal){
        if(animal != null){
            animals.add(animal);
            animal.setPetStore(this);
        }
    }

    public void remouveAnimal(Animal animal){
        if(animal != null){
            this.getAnimals().remove(animal);
        }
    }
    public void addProduct(Product product){
        if(product != null){
            this.products.add(product);

        }
    }
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
