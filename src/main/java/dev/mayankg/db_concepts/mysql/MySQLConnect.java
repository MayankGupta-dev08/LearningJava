package dev.mayankg.db_concepts.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
    public static void main(String[] args) {
        try {
            // Step 2: Load and register the JDBC driver for mysql
            Class<?> mysqlDriverClass = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // Step 3: Create a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/my_database",
                    "my_user",
                    "my_password"
            );
            System.out.println("Connected to the database!");

            // Step 4: Create a statement
            Statement statement = connection.createStatement();

            // Step 5: Execute the query
            String query = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 6: Process the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
            }

            // Step 7: Close the connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            throw new RuntimeException(e);
        }
    }
}
