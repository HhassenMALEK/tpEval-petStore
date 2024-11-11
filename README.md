# PetStore - Gestion de Magasin d'Animaux de Compagnie

PetStore est une application de gestion d'un magasin d'animaux de compagnie. Elle permet de gérer les informations relatives aux magasins, aux animaux, et aux produits disponibles. Ce système est conçu pour permettre aux utilisateurs de :

- Gérer les magasins d'animaux.
- Ajouter, supprimer et visualiser les animaux et produits disponibles dans chaque magasin.
- Maintenir les relations entre les magasins, les animaux et les produits.

Le projet utilise **JPA** (Jakarta Persistence API) pour la gestion des entités et interagit avec une base de données relationnelle via **Hibernate**. Pour la base de données, j'ai utilisé **MariaDB**.

## Fonctionnalités

### 1. Gestion des magasins
- Créer des magasins.
- Associer un magasin à une adresse.
- Lier des magasins à des animaux et des produits disponibles.

### 2. Gestion des animaux
- Ajouter et supprimer des animaux dans un magasin.
- Gérer différents types d'animaux (poissons, chats, etc.).
- Suivi des informations liées à chaque animal (identifiant, couleur, etc.).

### 3. Gestion des produits
- Ajouter et supprimer des produits dans un magasin.
- Gérer les différents types de produits (alimentation, accessoires, nettoyage).

### 4. Relations entre magasins, animaux et produits
- Associer chaque animal et produit à un magasin spécifique.
- Garantir la cohérence entre les entités via les relations définies dans la base de données (par exemple, `OneToMany` et `ManyToMany`).

## Technologies Utilisées

- **Java** : Langage principal de développement.
- **JPA (Jakarta Persistence API)** : Gestion de la persistance des données.
- **Hibernate** : Framework pour l'interaction avec la base de données relationnelle.
- **MariaDB** : Base de données relationnelle.
- **Maven** : Gestion des dépendances et construction du projet.

## Structure du Projet

### Packages Principaux

- **`fr.diginamic.business`** : Contient les classes principales de l'application : `PetStore`, `Adresse`, `Animal`, `Fish`, `Cat`, et `Product`.
- **`fr.diginamic.enums`** : Définit les énumérations utilisées dans l'application : `ProdType` (types de produits) et `FishLivEnv` (environnements de vie des poissons).

### Entités Principales

- **PetStore** : Représente un magasin d'animaux avec une collection d'animaux et de produits.
- **Animal** : Classe de base représentant un animal, avec des sous-classes comme `Fish` et `Cat`.
- **Product** : Représente un produit disponible dans un magasin, classé en types (alimentation, accessoires, nettoyage).

### Enumérations

- **FishLivEnv** : Enumération qui définit les types d'environnements de vie des poissons (par exemple, `FRESH_WATER` et `SEA_WATER`).
- **ProdType** : Enumération qui définit les types de produits disponibles dans le magasin (par exemple, `FOOD`, `ACCESSORY`, `CLEANING`).

## Exemple d'Utilisation

### Création et gestion des magasins

```java
// Création de magasins
PetStore parisStore = new PetStore("Paris PetStore", "Alice Dupont");
PetStore lyonStore = new PetStore("Lyon PetStore", "Paul Martin");

// Ajout d'adresse aux magasins
Adresse parisAddress = new Adresse("10 Rue de Paris", "Paris", "75000");
parisStore.ajouterAdresse(parisAddress);

// Ajout d'animaux dans les magasins
Animal redFish = new Fish(LocalDate.now(), "Red", parisStore, FishLivEnv.FRESH_WATER);
Animal siameseCat = new Cat(LocalDate.now(), "Cream", lyonStore, "002356");

// Ajouter les animaux aux magasins
parisStore.ajouterAnimal(redFish);
lyonStore.ajouterAnimal(siameseCat);

// Affichage des magasins et des animaux associés
System.out.println(parisStore);
System.out.println(lyonStore);
