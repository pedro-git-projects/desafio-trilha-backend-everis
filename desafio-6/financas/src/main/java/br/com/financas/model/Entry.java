package br.com.financas.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "entries")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "O título é um campo obrigatório")
    @Column
    private String title;

    @NotEmpty(message = "A descrição é um campo obrigatório")
    @Column
    private String description;

    @NotEmpty(message = "O tipo é um campo obrigatório")
    @Column
    private String type;

    @NotEmpty(message = "A quantidade é um campo obrigatório")
    @Column
    @Digits(integer = 6, fraction = 2, message = "Preencha apenas com dígitos numéricos")
    private String amount;

    @NotEmpty(message = "A data é um campo obrigatório")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "Insira a data em algum dos formatos: dd/mm/YYYY, dd-mm-YYYY, dd.mm.YYYY, dd mmm YYYY, dd-mmm-YYYY, dd/mmm/YYYY, dd.mmm.YYYY")
    @Column
    private String date;

    @NotNull
    @Column
    private boolean paid;

    public Entry(String title, String description, String type, String amount, String date, boolean paid) {

        this.title = title;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }
}
