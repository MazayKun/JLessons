package ru.mikheev.kirill.jlessons.april16.lessson;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TransactionalUserDao implements UserDao {

    private final Connection psql;
    private final SimpleUsersDao simpleUsersDao;

    public TransactionalUserDao(Connection psql) {
        this.psql = psql;
        this.simpleUsersDao = new SimpleUsersDao(psql);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> result;
        try {
            psql.setAutoCommit(false);
            result = simpleUsersDao.getAllUsers();
            psql.commit();
        } catch (SQLException e) {
            psql.rollback();
            throw e;
        }
        return result;
    }

    @Override
    public Optional<User> getUserById(int id) throws SQLException {
        Optional<User> result;
        try {
            psql.setAutoCommit(false);
            result = simpleUsersDao.getUserById(id);
            psql.commit();
        } catch (SQLException e) {
            psql.rollback();
            throw e;
        }
        return result;
    }

    @Override
    public void save(User user) throws SQLException {
        try {
            psql.setAutoCommit(false);
            simpleUsersDao.save(user);
            psql.commit();
        } catch (SQLException e) {
            psql.rollback();
            throw e;
        }
    }

    @Override
    public void GIGA_ADDER() throws SQLException {
        try {
            psql.setAutoCommit(false);
            simpleUsersDao.GIGA_ADDER();
            psql.commit();
        } catch (SQLException e) {
            psql.rollback();
            throw e;
        }
    }
}
