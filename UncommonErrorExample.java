public class UncommonErrorExample {

    public static void main(String[] args) {
        try {
            // Simulate an uncommon error: accessing a resource that's unexpectedly closed
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            // ...perform database operations...
            connection.close();
            // Attempt to use the connection after it's closed
            connection.createStatement(); //This will throw an exception
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Exception: " + e.getMessage());
        }
    }
}