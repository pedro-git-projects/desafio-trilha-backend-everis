package br.com.financas.model;

import javax.persistence.*;

// indicates that the class is a persistent Java class.
@Entity
// provides the table that maps this entity.
@Table (name = "Category")
public class Category {

    @Id // primary key.
    @GeneratedValue(strategy = GenerationType.AUTO) // defines generation strategy for the primary key.
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private  String description;

    // Constructors
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
    }
    public Category(){

    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}