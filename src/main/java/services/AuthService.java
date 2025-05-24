package services;
import config.DatabaseConfig;
import models.User;
import java.sql.*;

public class AuthService {
    private static User currentUser;

    public static User getCurrentUser(){return currentUser;}

    public static boolean login(String pin){
        try(Connection conn = DatabaseConfig.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Users WHERE pin = ?");
            stmt.setString(1, pin);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                currentUser = new User(rs.getInt("id"), rs.getString("name"), rs.getString("pin"), rs.getDouble("balance"));
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public static void logout(){currentUser = null;}
}
