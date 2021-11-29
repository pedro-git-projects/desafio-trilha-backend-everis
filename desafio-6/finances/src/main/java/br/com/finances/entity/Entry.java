package br.com.finances.entity;
import javax.persistence.*;
import java.util.Objects;

@Table(name = "lancamentos")
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false, referencedColumnName = "id")
    private Category categoryID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private String amount;

    @Column(name = "date")
    private String date;

    @Column(name = "paid")
    private Boolean paid;

    public Entry() {}

    public Entry(Long id, Category categoryID, String name, String description, String type, String amount, String date, Boolean paid) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(getId(), entry.getId()) && Objects.equals(getCategoryID(), entry.getCategoryID()) && Objects.equals(getName(), entry.getName()) && Objects.equals(getDescription(), entry.getDescription()) && Objects.equals(getType(), entry.getType()) && Objects.equals(getAmount(), entry.getAmount()) && Objects.equals(getDate(), entry.getDate()) && Objects.equals(getPaid(), entry.getPaid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryID(), getName(), getDescription(), getType(), getAmount(), getDate(), getPaid());
    }
}

