package br.com.finances.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String name;

    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Category(Long id) {

        this.id = id;
    }

}
