import config.DatabaseConfig;
import controllers.MainController;

public class App {
    public static void main(String[] args) {
        DatabaseConfig.initializeDatabase();

        new MainController().start();
    }
}
