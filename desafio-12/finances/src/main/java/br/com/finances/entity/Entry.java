package br.com.finances.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{O tipo}")
    private String type;

    @NotNull(message = "{Campo(s) obrigatórios não foram preenchidos}")
    private Double amount;

    @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    private String date;

    @NotNull(message = "{Campo(s) obrigatórios não foram preenchidos}")
    private Boolean paid;


    public Entry(Category categoryID, String name, String description, String type, Double amount, String date, Boolean paid) {
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

