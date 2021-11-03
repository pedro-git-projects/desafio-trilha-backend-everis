package br.com.financas.model;


import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "categoryId")
    private long categoryId;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "type")
    private String type;

    @Column (name = "amount")
    private String amount;

    @Column (name = "date")
    private String date;

    @Column (name = "paid")
    private boolean paid;

    // Constructors
    public Entry(long categoryId, String name, String description, String type, String amount, String date, boolean paid) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }

    public Entry() {

    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
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

    // Overriding toString to print the values and not the adress
    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", paid=" + paid +
                '}';
    }
}
