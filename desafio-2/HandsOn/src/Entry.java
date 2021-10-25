public class Entry {
    private long id, categoryId;
    private String name, description, type, ammount, date;
    private boolean paid;

    // Constructors
    Entry(long id, long categoryId, String name, String description, String type, String ammount, String date, boolean paid) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.ammount = ammount;
        this.date = date;
        this.paid = paid;
    }

    Entry() {

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

    public String getAmmount() {
        return ammount;
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

    public void setAmmount(String ammount) {
        this.ammount = ammount;
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
                ", ammount='" + ammount + '\'' +
                ", date='" + date + '\'' +
                ", paid=" + paid +
                '}';
    }
}
