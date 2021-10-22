public class Main {
    public static void main(String[] args) {

        // Instantiating classes
        Category leisure = new Category("Leisure", "Spendings related to leisure", 1234);
        Category health = new Category();

        // Using setters
        health.setName("Health");
        health.setDescription("Spendings related to health");
        health.setId(4321);

        // Printing object in string form
        System.out.println(health);
        System.out.println(leisure);
    }
}