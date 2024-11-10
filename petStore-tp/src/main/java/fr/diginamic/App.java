package fr.diginamic;

import fr.diginamic.business.*;
import fr.diginamic.enums.FishLivEnv;
import fr.diginamic.enums.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        //Paramétrage de création de la DB avec JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Instantiation d'objets de type Petstore.
        PetStore parisStore = new PetStore("Au Paradis des Pattes", "Phlippe");
        PetStore lyonStore = new PetStore("Félin Pour L'Autre", "Jean Philippe");
        PetStore marseilleStore = new PetStore("Anima Life", "Martin");

        //Instantiation d'objets de type Adresse pour différentes villes.
        Adresse adresseMarseille = new Adresse("12", "Rue de la liberté", "13001", "Marseille");
        Adresse adresseParis = new Adresse("152", "Rue des Colombes", "75003", "Paris");
        Adresse adreseeLyon = new Adresse("1", "Rue des Albatros","69006", "Lyon" );

        //Affectation des Adresses aux différents PetStore.
        marseilleStore.addAdresse(adresseMarseille);
        lyonStore.addAdresse(adreseeLyon);
        parisStore.addAdresse(adresseParis);

        //Instantiation d'objet de type Animal avec des types spécifiques (Fish et Cat)
        Animal RedFish = new Fish(LocalDate.now(),"Red", parisStore, FishLivEnv.FRESH_WATER );
        Animal  siameseCat = new Cat(LocalDate.now(), "Cream", lyonStore, "002356");
        Animal  clownfish = new Fish (LocalDate.now(), "orange", marseilleStore, FishLivEnv.SEA_WATER);

        //Affectation des animaux aux différents magasins PetStore.
        marseilleStore.addAnimal(clownfish);
        parisStore.addAnimal(siameseCat);
        lyonStore.addAnimal(clownfish);

        //Instantiation d'objets de type Product.
        Product fishFood = new Product("FF0321", "Tropical Fish Flakes", ProdType.FOOD, 15.99 );
        Product catFood = new Product("CF123", "Almo Salamon", ProdType.FOOD, 45.86);
        Product aquariumCleaner = new Product("AC456", "Aquarium Gravel Cleaner", ProdType.CLEANING, 39.99);
        Product catToy = new Product("T123", "Interactive Cat Toy", ProdType.ACCESSORY, 23.69);

        //Affectation des produits de type Product aux différents magasins PetStore.
        marseilleStore.addProduct(fishFood);
        parisStore.addProduct(catFood);
        lyonStore.addProduct(aquariumCleaner);
        parisStore.addProduct(catToy);


        //Ajout des magasins petstore à la base de données avec persistance en cascade des entités liées (adresses, animaux, produits)
        em.persist(parisStore);
        em.persist(lyonStore);
        em.persist(marseilleStore);

        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}