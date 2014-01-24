package service;

import dao.UserDao;
import exception.UserInvalidException;
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
    public void check_empty_password() throws Exception {
        String errorInfo = "";
        try {
            userService.isValidUser("root", "");
        } catch ( UserInvalidException e ) {
            errorInfo = e.getMessage();
        }
        assertThat(errorInfo, is("Empty String is Invalid"));
    }


    @Test
    public void check_empty_username() throws Exception {
        String errorInfo = "";
        try {
            userService.isValidUser("", "123");
        } catch ( UserInvalidException e ) {
            errorInfo = e.getMessage();
        }
        assertThat(errorInfo, is("Empty String is Invalid"));
    }

    @Test
    public void check_invalid_username() throws Exception {
        String errorInfo = "";
        try {
            userService.isValidUser("abc", "123");
        } catch ( UserInvalidException e ) {
            errorInfo = e.getMessage();
        }
        assertThat(errorInfo, is("Invalid User"));
    }

    @Test
    public void check_wrong_password() throws Exception {
        String errorInfo = "";
        try {
            userService.isValidUser("root", "12345");
        } catch ( UserInvalidException e ) {
            errorInfo = e.getMessage();
        }
        assertThat(errorInfo, is("Wrong Password"));
    }
}
