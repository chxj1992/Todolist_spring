package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * 用户操作
 * Author: chen
 * DateTime: 1/10/14 2:03 PM
 */
public class UserControllerTest {

    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;


    @InjectMocks
    private UserController userController;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

       //given
        when(userService.isValidUser("root", "123")).thenReturn(
                new Integer(1));
        when(userService.isValidUser(not(eq("root")), anyString())).thenReturn(
                new Integer(0));
        when(userService.isValidUser(anyString(), not(eq("123")))).thenReturn(
                new Integer(0));
        when(request.getSession()).thenReturn(
                session);
    }

    @Test
    public void should_show_login_page_without_a_session() throws Exception {
        when(session.getAttribute("userId")).thenReturn(
            null);
        String view = userController.login(request, response);

        assertThat(view, is("login"));
    }

    @Test
    public void should_not_show_login_page() throws Exception {
        when(session.getAttribute("userId")).thenReturn(
                new Integer(1));
        String view = userController.login(request, response);

        assertNull(view);
    }

    @Test
    public void login_success() throws Exception {
        Map json = (Map) userController.doLogin("root", "123", request);
        assertThat((String) json.get("status"), is("1"));
    }

    @Test
    public void login_fail_with_wrong_username() throws Exception {
        Map json = (Map) userController.doLogin("admin", "123", request);
        assertThat((String) json.get("status"), is("0"));
    }

    @Test
    public void login_fail_with_wrong_password() throws Exception {
        Map json = (Map) userController.doLogin("root", "1234", request);
        assertThat((String) json.get("status"), is("0"));
    }

}
