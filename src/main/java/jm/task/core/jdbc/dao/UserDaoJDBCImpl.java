package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final static String CREATE = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), last_name VARCHAR(80), age INT(3))";
    private final static String DROP = "DROP TABLE IF EXISTS User";
    private final static String INSERT = "INSERT INTO User(name, last_name, age) VALUES (?, ?, ?)";
    private final static String SELECT_ALL = "SELECT * FROM User";
    private final static String SELECT_BY_ID = "SELECT * FROM User WHERE id = ?";

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection conn = Util.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE);
            System.out.println("The user table has been created.");
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection conn = Util.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(DROP);
            System.out.println("The user table has been dropped.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection conn = Util.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
