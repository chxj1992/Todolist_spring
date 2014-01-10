package service;

import dao.UserDao;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

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
    @Mock
    MockHttpServletRequest request;
    @Mock
    MockHttpSession session;

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
        when(request.getSession()).thenReturn(
            session);
        when(session.getAttribute("userId")).thenReturn(
            new Integer(1));
    }


    @Test
    public void check_password_right() throws Exception {
        Integer userId = userService.checkPassword("root","123");
        assertThat(userId,is(1));
    }

    @Test
    public void check_password_wrong() throws Exception {

        Integer userId = userService.checkPassword("root","1234");
        assertThat(userId,is(0));
    }

    @Test
    public void login_user_name_right() throws Exception {
        User loginUser = userService.loginUserInfo();
        assertThat(loginUser.getUserName(),is("root"));
    }

}
