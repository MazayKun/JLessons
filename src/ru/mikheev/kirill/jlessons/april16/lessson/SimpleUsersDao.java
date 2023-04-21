package ru.mikheev.kirill.jlessons.april16.lessson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleUsersDao implements UserDao{

    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?;";

    private Connection psql;

    public SimpleUsersDao(Connection psql) {
        this.psql = psql;
    }

    @Override
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

    @Override
    public Optional<User> getUserById(int id) throws SQLException {
        PreparedStatement prepareStatement = psql.prepareStatement(GET_USER_BY_ID_QUERY);
        prepareStatement.setInt(1, id);
        ResultSet resultSet = prepareStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(createUserFromResultSet(resultSet));
        }
        return Optional.empty();
    }

    @Override
    public void save(User user) throws SQLException {
        Statement statement = psql.createStatement();
        if(statement.execute(constructInsertUserQuery(user))) {
            throw new RuntimeException("INSERT ERROR");
        }
    }

    @Override
    public void GIGA_ADDER() throws SQLException {
        for(int i = 0; i < 10; i++) {
            save(new User("TEST TEST", 228));
            if(i == 5) throw new SQLException("ERROR");
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }


    private String constructInsertUserQuery(User user) {
        return "INSERT INTO users(name, age) VALUES (\'" +
                user.getName() +
                "\'," +
                user.getAge() +
                ");";
    }
}
