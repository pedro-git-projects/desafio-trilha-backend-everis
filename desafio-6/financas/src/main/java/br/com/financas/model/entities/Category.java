package br.com.financas.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O título é obrigatório")
    private String title;

    @NotEmpty(message = "A descrição é obrigatória")
    private String description;

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
