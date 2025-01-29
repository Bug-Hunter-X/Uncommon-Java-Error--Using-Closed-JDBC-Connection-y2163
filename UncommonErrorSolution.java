public class UncommonErrorSolution {

    public static void main(String[] args) {
        try {
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            // ...perform database operations...
            if (!connection.isClosed()) { //Check if the connection is closed before using
                java.sql.Statement statement = connection.createStatement();
                //Use the statement here
                statement.close();
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Exception: " + e.getMessage());
        }
    }
}