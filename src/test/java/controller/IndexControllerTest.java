package controller;

import dao.ContentDao;
import dao.UserDao;
import model.Content;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ModelMap;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * add_your_description_here
 * Author: chen
 * DateTime: 1/10/14 1:42 PM
 */
public class IndexControllerTest {

    @Mock
    ContentDao contentDao;
    @Mock
    UserDao userDao;
    @Mock
    HttpServletRequest request;
    @Mock
    MockHttpSession session;

    ModelMap model;

    @InjectMocks
    IndexController indexController;


    @Before
    public void setUp() throws Exception {

        model = new ModelMap();

        MockitoAnnotations.initMocks(this);

       //given
        when(contentDao.getListByUserId(1)).thenReturn(
                Arrays.asList(
                    new Content(1, "content1"),
                    new Content(1, "content2"),
                    new Content(1, "content3")
                ));
        when(request.getSession()).thenReturn(
            session);
        when(session.getAttribute("userId")).thenReturn(
            new Integer(1));
        when(userDao.getByUserId(1)).thenReturn(
                new User(1, "root", "202cb962ac59075b964b07152d234b70", new Timestamp(0)));
    }


    @Test
    public void test_home_page_view_right() throws Exception {
        String view = indexController.homePage(model, request );
        assertThat(view, is("index"));
    }

    @Test
    public void home_page_user_attribute_should_be_user1() throws Exception {
        indexController.homePage(model, request);
        User user = (User) model.get("user");
        assertThat(user.getUserId(), is(1));
    }

    @Test
    public void home_page_contents_attribute_number_should_be_3() throws Exception {
        indexController.homePage(model, request);
        List<Content> contents = (List<Content>) model.get("contents");
        assertThat(contents.size(), is(3));
    }

}
