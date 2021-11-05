package br.com.financas.model;


import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private String amount;

    @Column
    private String date;

    @Column
    private boolean paid;


    public Entry( String title, String description, String type, String amount, String date, boolean paid) {

        this.title = title;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }


    // Getters & Setters

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

    public void setId(long id) {
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

    // Overriding toString to print the values and not the adress
    @Override
    public String toString() {
        return "Entry{" +
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
