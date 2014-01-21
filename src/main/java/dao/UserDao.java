package dao;

import mapper.UserRowMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: chen
 * DateTime: 1/7/14 2:42 PM
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private UserRowMapper userRowMapper;

    public User getByUserId(Integer userId) {
        User user;
        try{
            user = (User) jdbc.queryForObject("SELECT * FROM user WHERE user_id = ?", userRowMapper, new Object[]{userId});
        } catch (EmptyResultDataAccessException e) {
            user = new User();
        }
        return user;
    }

    public List<User> getAllUsers() {
        return jdbc.query("SELECT * FROM user WHERE 1", userRowMapper);
    }

    public User getByUserName(String userName) {
         User user;
        try{
            user = (User) jdbc.queryForObject("SELECT * FROM user WHERE user_name = ?", userRowMapper, new Object[]{userName});
        } catch (EmptyResultDataAccessException e) {
            user = new User();
        }
        return user;
    }

}
