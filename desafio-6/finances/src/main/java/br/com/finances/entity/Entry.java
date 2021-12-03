package br.com.finances.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String name;

    private String description;

    private String type;

    private String amount;

    private String date;

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

