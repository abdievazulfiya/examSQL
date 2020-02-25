package soedinenie;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Dbworker dbworker = new Dbworker();
//        dbworker.connect();
//        dbworker.getPerson();
        String name = "name";
        String pwd = "123";
        dbworker.authorize(name,pwd);



    }




}
