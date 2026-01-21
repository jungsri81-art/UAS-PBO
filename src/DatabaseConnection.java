import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_belanja";
        String user = "root";   // ganti sesuai user MySQL kamu
        String password = "jungis";   // ganti sesuai password MySQL kamu
        return DriverManager.getConnection(url, user, password);
    }
}