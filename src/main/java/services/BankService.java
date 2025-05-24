package services;

import config.DatabaseConfig;
import models.User;

import java.sql.*;

public class BankService {
    public static boolean deposit(double amount) {
        if (AuthService.getCurrentUser() == null) return false;

        try (Connection conn = DatabaseConfig.getConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE users SET balance = balance + ? WHERE id = ?");
            stmt.setDouble(1, amount);
            stmt.setInt(2, AuthService.getCurrentUser().getId());
            int affected = stmt.executeUpdate();

            if (affected > 0) {
                AuthService.getCurrentUser().setBalance(
                        AuthService.getCurrentUser().getBalance() + amount);
                conn.commit();
                return true;
            }
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean withdraw(double amount) {
        User user = AuthService.getCurrentUser();
        if (user == null || user.getBalance() < amount) return false;

        try (Connection conn = DatabaseConfig.getConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE users SET balance = balance - ? WHERE id = ?");
            stmt.setDouble(1, amount);
            stmt.setInt(2, user.getId());
            int affected = stmt.executeUpdate();

            if (affected > 0) {
                user.setBalance(user.getBalance() - amount);
                conn.commit();
                return true;
            }
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
