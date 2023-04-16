package ru.mikheev.kirill.jlessons.april16.lessson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_USER_PASSWORD = "postgres";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD)){
            UsersDao usersDao = new UsersDao(connection);
            var allUsers = usersDao.getAllUsers();
            System.out.println(allUsers);
//            usersDao.save(new User("Petr I", 30));
//            System.out.println(usersDao.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}
