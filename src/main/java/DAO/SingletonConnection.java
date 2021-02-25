package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    public static final String URL_CONNECTION_DB = "jdbc:mysql://localhost:3306/end_md3?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private static Connection connection;

    public Connection getConnection(){
        if (connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL_CONNECTION_DB,USER,PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("Khong co driver");
            } catch (SQLException e) {
                System.err.println("Khong ket noi duoc");
            }
            System.out.println("ket noi thanh cong !!!");
        }
        return connection;
    }

}

