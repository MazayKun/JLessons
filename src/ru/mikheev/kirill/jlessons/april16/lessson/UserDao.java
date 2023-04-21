package ru.mikheev.kirill.jlessons.april16.lessson;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers() throws SQLException;

    Optional<User> getUserById(int id) throws SQLException;

    void save(User user) throws SQLException;

    void GIGA_ADDER() throws SQLException;
}
