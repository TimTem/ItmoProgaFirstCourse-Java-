package sample.DesirilizationFromServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    static Connection dbConnection;
    protected static final String DB_URL = "jdbc:postgresql://localhost:5432/studs";
    protected static final String USER = "s371814";
    protected static final String PASS = "UTkL64PhIA4ls4S1";
    public static Connection getDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            properties.put("user", USER);
            properties.put("password", PASS);
            dbConnection = DriverManager.getConnection(DB_URL, properties);
            return dbConnection;
        } catch (Exception e) {
            System.err.println("БД отключена!");
            return null;
        }
    }
}
