//package services;
//
//import config.DatabaseConfig;
//import models.User;
//import java.sql.*;
//
//public class DatabaseService {
//    // Generic query execution
//    public ResultSet executeQuery(String query, Object... params) throws SQLException {
//        Connection conn = DatabaseConfig.getConnection();
//        PreparedStatement stmt = conn.prepareStatement(query);
//
//        for (int i = 0; i < params.length; i++) {
//            stmt.setObject(i + 1, params[i]);
//        }
//
//        return stmt.executeQuery();
//    }
//
//    // Generic update execution
//    public int executeUpdate(String query, Object... params) throws SQLException {
//        try (Connection conn = DatabaseConfig.getConnection()) {
//            PreparedStatement stmt = conn.prepareStatement(query);
//
//            for (int i = 0; i < params.length; i++) {
//                stmt.setObject(i + 1, params[i]);
//            }
//
//            return stmt.executeUpdate();
//        }
//    }
//
//    // User-specific methods
//    public User getUserByPin(String pin) throws SQLException {
//        String query = "SELECT * FROM users WHERE pin = ?";
//        try (ResultSet rs = executeQuery(query, pin)) {
//            if (rs.next()) {
//                return new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("pin"),
//                        rs.getDouble("balance")
//                );
//            }
//        }
//        return null;
//    }
//
//    public boolean updateUserBalance(int userId, double amount) throws SQLException {
//        String query = "UPDATE users SET balance = balance + ? WHERE id = ?";
//        return executeUpdate(query, amount, userId) == 1;
//    }
//}