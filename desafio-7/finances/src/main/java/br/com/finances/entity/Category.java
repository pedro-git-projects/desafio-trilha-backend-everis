package br.com.finances.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{O nome deve ter entre 3 e 15 caracteres}")
    private String name;

    @NotBlank(message="{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{A descrição deve ter entre 3 e 15 caracteres}")
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Category(Long id) {

        this.id = id;
    }

}
