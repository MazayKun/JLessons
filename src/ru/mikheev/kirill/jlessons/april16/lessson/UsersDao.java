package ru.mikheev.kirill.jlessons.april16.lessson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    private Connection psql;

    public UsersDao(Connection psql) {
        this.psql = psql;
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = psql.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
        List<User> allUsers = new ArrayList<>();
        while(resultSet.next()) {
            allUsers.add(
                    createUserFromResultSet(resultSet)
            );
        }
        return allUsers;
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }

    public void save(User user) throws SQLException {
        Statement statement = psql.createStatement();
        if(statement.execute(constructInsertUserQuery(user))) {
            throw new RuntimeException("INSERT ERROR");
        }
    }

    private String constructInsertUserQuery(User user) {
        return "INSERT INTO users(name, age) VALUES (\'" +
                user.getName() +
                "\'," +
                user.getAge() +
                ");";
    }
}
