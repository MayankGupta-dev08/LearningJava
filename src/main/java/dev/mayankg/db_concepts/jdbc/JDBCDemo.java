package dev.mayankg.db_concepts.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Steps to connect to a database using JDBC:
 * <ol>
 *  <li>Import the JDBC packages. (java.sql.*)</li>
 *  <li>Load (dep in pom) and register the JDBC driver.</li>
 *  <li>Create a connection.</li>
 *  <li>Create a statement.</li>
 *  <li>Execute the query.</li>
 *  <li>Process the results.</li>
 *  <li>Close the connection.</li>
 * </ol>
 */
public class JDBCDemo {
    public static void main(String[] args) {
        try {
            // Step 2: Load and register the JDBC driver for postgresql
            Class<?> pgsqlDriverClass = Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registered!");

            // Step 3: Create a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/employee",
                    "postgres",
                    "postgres"
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
            System.out.println("PostgreSQL JDBC Driver not found!");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            throw new RuntimeException(e);
        }
    }
}
