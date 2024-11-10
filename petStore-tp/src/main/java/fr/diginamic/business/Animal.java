package fr.diginamic.business;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ANIMAL")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="BIRTH")
    private LocalDate birth;
    @Column(name="COLOR")
    private String color;
    @ManyToOne
    @JoinColumn(name="PETSTORE_ID")
    private PetStore petStore;

    public Animal() {}

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

