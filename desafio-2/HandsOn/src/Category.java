public class Category {
    private long id;
    private String name, description;

    // Constructors
    Category(String name, String description, long id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }
    Category(){

    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
