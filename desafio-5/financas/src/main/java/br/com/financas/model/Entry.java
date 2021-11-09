package br.com.financas.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
    @Digits(integer =6, fraction = 2, message = "Preencha apenas com dígitos numéricos")
    private String amount;

    @NotEmpty(message = "A data é um campo obrigatório")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "Insira a data em algum dos formatos: dd/mm/YYYY, dd-mm-YYYY, dd.mm.YYYY, dd mmm YYYY, dd-mmm-YYYY, dd/mmm/YYYY, dd.mmm.YYYY with Leap Year Support")
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

    public Entry () {};


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "EntryController{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", paid=" + paid +
                '}';
    }

}
