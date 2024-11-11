# PetStore

## Description

Le **PetStore** est une application de gestion d'un magasin d'animaux de compagnie des produits au sein d'un magasin. Elle permet de gérer les informations relatives aux magasins, aux animaux, et aux produits disponibles. Ce système est conçu pour permettre aux utilisateurs de :

- Gérer les magasins d'animaux.
- Ajouter, supprimer et visualiser les animaux et produits disponibles dans chaque magasin.
- Maintenir les relations entre les magasins, les animaux et les produits.

Le projet utilise **JPA** (Jakarta Persistence API) pour la gestion des entités et interagit avec une base de données relationnelle via **Hibernate**. Le tout est structuré autour d'un modèle orienté objets, facilitant la gestion et l'interaction avec les données persistantes.

## Fonctionnalités

### Gestion des magasins (PetStore)
-creer des magasins
- Associer un magasin avec une adresse.
- Lier des magasins à des animaux et des produits disponibles.

### Gestion des animaux
- Ajouter et supprimer des animaux dans un magasin.
- Gérer différents types d'animaux (poissons, chats, etc.).
- Suivi des informations liées à chaque animal (identifiant, couleur, etc.).

### Gestion des produits
- Ajouter et supprimer des produits dans un magasin.
- Gérer les différents types de produits (alimentation, accessoires, nettoyage).
  
### Relations entre magasins, animaux et produits
- Associer chaque animal et produit à un magasin spécifique.
- Garantir la cohérence entre les entités via les relations définies dans la base de données (par exemple, `OneToMany` et `ManyToMany`).

## Structure du Projet

### Packages Principaux

- **`fr.diginamic.business`** : Ce package contient les classes principales de l'application, telles que `PetStore`, `Animal`, `Fish`, `Cat`, et `Product`, qui gèrent les relations entre les magasins, les animaux et les produits.
  
- **`fr.diginamic.enums`** : Ce package définit les énumérations utilisées dans l'application, telles que `ProdType` pour les types de produits et `FishLivEnv` pour les environnements de vie des poissons.

### Entités Principales

- **PetStore** : Représente un magasin d'animaux. Ce magasin peut contenir une collection d'animaux et de produits. Il permet de gérer les animaux et produits disponibles dans un magasin spécifique.
  
- **Animal** : Classe représentant un animal. Elle dispose de sous-classes comme `Fish` (poisson) et `Cat` (chat). Chaque animal a des attributs spécifiques, comme un identifiant de puce (pour les chats) ou un environnement de vie (pour les poissons).
  
- **Product** : Représente un produit disponible dans un magasin. Il peut être classé en plusieurs types, comme les aliments, les accessoires ou les produits de nettoyage, grâce à l'énumération `ProdType`.

### Enumérations

- **FishLivEnv** : Enumération qui définit les types d'environnements de vie des poissons (par exemple, `FRESH_WATER` pour l'eau douce et `SEA_WATER` pour l'eau de mer).
  
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
