package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDb {
    private final String user = "root";
    private final String pass = "";
    private final String utf8 = "?characterEncoding=utf-8";
    private final String dbName = "mydatabase";
    private final String url = "jdbc:mysql://localhost:3306/" + dbName + utf8;
    private Connection con;

    public ConnexionDb() {
        connection();
    }

    protected void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the correct driver class name
            this.con = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Connection réussie");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

    @Override
    public String toString() {
        return super.toString();

    }
}
