package soedinenie;

import java.sql.*;

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

    public int getPerson() throws SQLException {
        String SQL = "SELECT * FROM person";
        int count = 0;
        Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()){
            String name  = rs.getString("name");
            Date date  = rs.getDate("birthday");
            System.out.println(name+ ", " +date.toString());
        }

        return count;
    }
    public void registr(String name,String password) throws SQLException {
        Connection conn= connect();
        String SQL ="insert into users2 (name_user,password) values (?,?)";
        PreparedStatement statement = conn.prepareStatement(SQL);

        String encyrptedPwd = zashifrovat(password);

        statement.setString(2,encyrptedPwd);
        statement.setString(1,name);
        statement.executeUpdate();

    }

    public void authorize(String name, String pwd) throws SQLException {
        Connection conn=connect();
        String encyrpted=zashifrovat(pwd);

        String SQL = String.format("SELECT* from users2 where name_user='%s' and password='%s';",name,encyrpted);
       Statement statement= conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        if( resultSet.next()==true){
            System.out.println("Welcome");

        }
        else {
            System.out.println("sorry");
        }


    }



    private static String zashifrovat(String password) {

        String reversed ="";
        for (int i=password.length()-1; i>=0; i-- ){

            reversed+=password.charAt(i);
//            System.out.println(password.charAt(i));
//            System.out.println(reversed);

        }

        reversed+=reversed.charAt(reversed.length()-1);
        System.out.println(reversed);
        return reversed;

    }



}






