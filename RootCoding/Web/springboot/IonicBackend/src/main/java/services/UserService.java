package services;

import ReadWriteSplit.ReadOnlyConnection;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ReadOnlyConnection
    public List<User> getUserList() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setPhone(resultSet.getString("phone"));
                return user;
            }
        });
    }

    public int insertRaw(User user){
        return jdbcTemplate.update("INSERT INTO USER VALUES('"
                + user.getId() + "', '"
                + user.getName() + "', '"
                + user.getAge() + "', '"
                + user.getPhone() + "')");
    }
}