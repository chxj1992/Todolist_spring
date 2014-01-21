package mapper;

import model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: chen
 * DateTime: 1/8/14 10:11 AM
 */
public class UserRowMapper implements RowMapper{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("password"),
                rs.getTimestamp("create_time")
        );
        return user;
    }

}
