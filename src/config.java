import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class config {
        private static Connection mysqlconfig;
    private static String url = "jdbc:mysql://localhost:3306/dbsiswa";
    private static String username = "root";
    private static String password = "";

    public static Connection configDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mysqlconfig = DriverManager.getConnection(url, username, password);
            return mysqlconfig;
        } catch (Exception e) {
            System.err.println("Koneksi gagal " + e.getMessage());
            return null;
        }
    }
}
       



    
