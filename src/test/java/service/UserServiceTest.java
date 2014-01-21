package service;

import dao.UserDao;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * UserService 测试
 * Author: chen
 * DateTime: 1/9/14 9:37 PM
 */
public class UserServiceTest {


    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

       //given
        when(userDao.getByUserId(1)).thenReturn(
            new User(1,"root","202cb962ac59075b964b07152d234b70",new Timestamp(0)));
        when(userDao.getByUserName("root")).thenReturn(
            new User(1,"root","202cb962ac59075b964b07152d234b70",new Timestamp(0)));
    }


    @Test
    public void check_password_right() throws Exception {
        Integer userId = userService.isValidUser("root", "123");
        assertThat(userId,is(1));
    }

    @Test
    public void check_password_wrong() throws Exception {

        Integer userId = userService.isValidUser("root", "1234");
        assertThat(userId,is(0));
    }


}
