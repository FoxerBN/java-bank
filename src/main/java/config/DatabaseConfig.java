
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String DB_URL = "jdbc:h2:./database/bankdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            conn.createStatement().execute(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "name VARCHAR(100) NOT NULL, " +
                            "pin VARCHAR(4) NOT NULL, " +
                            "balance DECIMAL(10, 2) NOT NULL DEFAULT 0)"
            );

            ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) as count FROM users");
            if (rs.next() && rs.getInt("count") == 0) {
                conn.createStatement().execute(
                        "INSERT INTO users (name, pin, balance) VALUES " +
                                "('John Doe', '0000', 1000.00), " +
                                "('Jane Smith', '0001', 2500.00), " +
                                "('Bob Johnson', '0002', 500.00), " +
                                "('Alice Williams', '0003', 3000.00), " +
                                "('Charlie Brown', '0004', 750.00)"
                );
                System.out.println("Database initialized successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}