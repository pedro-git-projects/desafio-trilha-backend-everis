package br.com.finances.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lancamentos")
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false, referencedColumnName = "id")
    private Category categoryID;

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{O nome deve ter entre 3 e 15 caracteres}")
    private String name;

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{A descrição deve ter entre 3 e 15 caracteres}")
    private String description;

    @NotNull(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 10, message = "{A mensagem deve ter entre 3 e 10 caracteres}")
    private String type;

    @NotNull(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Min(value = 0, message = "{O valor não pode ser menor do que zero}")
    private String amount;

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    private String date;

    @NotNull(message = "{Campo(s) obrigatórios não foram preenchidos}")
    private Boolean paid;


    public Entry(Category categoryID, String name, String description, String type, String amount, String date, Boolean paid) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }
}

