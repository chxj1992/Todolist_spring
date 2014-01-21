package dao;

import init.InitJdbc;
import mapper.UserRowMapper;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserDao 测试
 * Author: chen
 * DateTime: 1/9/14 11:20 PM
 */
//@ContextConfiguration(locations = {"classpath:beans-mock.xml"})
public class UserDaoTest {

    //@Spy
    //@Autowired //为何无法从成功注入?
    //private JdbcTemplate jdbc;

    @Spy
    private JdbcTemplate jdbc = InitJdbc.init();

    @Spy
    private UserRowMapper userRowMapper;

    @InjectMocks
    private UserDao userDao;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void get_all_users_number_should_be_3() throws Exception {
        List<User> users = userDao.getAllUsers();
        assertThat(users.size(), is(3));
    }

    @Test
    public void get_all_users_name_right() throws Exception {
        List<User> users = userDao.getAllUsers();
        int i = 0;
        for( User user : users) {
            i++;
            assertThat(user.getUserName(), is("test"+i));
        }
    }

    @Test
    public void get_exist_user_by_user_id() throws Exception {
        User user1 = userDao.getByUserId(1);
        assertThat(user1.getUserName(), is("test1"));
    }

    @Test
    public void get_not_exist_user_by_user_id() throws Exception {
        User nullUser = userDao.getByUserId(100);
        assertNull(nullUser.getUserId());
    }

    @Test
    public void get_exist_user_by_user_name() throws Exception {
        User user1 = userDao.getByUserName("test1");
        assertThat(user1.getUserName(), is("test1"));
    }

    @Test
    public void get_not_exist_user_by_user_name() throws Exception {
        User nullUser = userDao.getByUserName("user_not_exist");
        assertNull(nullUser.getUserId());
    }

}
