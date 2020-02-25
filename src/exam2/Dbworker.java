package exam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dbworker {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "12345677";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void putnewnews(String zagolovok,String textnews,String time){
        try (Connection conn= connect()){
            String SQL ="insert into news ( zagolovok, textnews,  public) values (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(2,zagolovok);
            statement.setString(1,textnews);
            statement.setString(3,time);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }





    }
}
