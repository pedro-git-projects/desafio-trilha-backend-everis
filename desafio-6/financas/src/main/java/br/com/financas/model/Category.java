package br.com.financas.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "O título é um campo obrigatório")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "A descrição é um campo obrigatório")
    @Column(name = "description")
    private String description;


    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }
}