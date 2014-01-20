package controller;

import dao.ContentDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * content 操作
 * Author: chen
 * DateTime: 1/10/14 2:41 PM
 */
public class ContentControllerTest {

    @Mock
    private ContentDao contentDao;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;


    @InjectMocks
    private ContentController contentController;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

       //given
        when(contentDao.addContent(anyString())).thenReturn(
                new Boolean(true));
        when(contentDao.removeContent(1)).thenReturn(
                new Boolean(true));
        when(contentDao.removeContent(100)).thenReturn(
                new Boolean(false));
        when(contentDao.updateContent(eq(1), anyString())).thenReturn(
                new Boolean(true));
        when(contentDao.updateContent(eq(100), anyString())).thenReturn(
                new Boolean(false));
    }


    @Test
    public void test_add_content_success() throws Exception {
        Map json = (Map) contentController.addContent("a context");
        assertThat((String) json.get("status"), is("1"));
    }


    @Test
    public void test_remove_content_success() throws Exception {
        Map json = (Map) contentController.removeContent(1);
        assertThat((String) json.get("status"), is("1"));
    }


    @Test
    public void test_update_content_success() throws Exception {
        Map json = (Map) contentController.updateContent(1, "new content");
        assertThat((String) json.get("status"), is("1"));
    }

    @Test
    public void test_remove_not_exist_content_fail() throws Exception {
        Map json = (Map) contentController.removeContent(100);
        assertThat((String) json.get("status"), is("0"));
    }

    @Test
    public void test_update_not_exist_content_fail() throws Exception {
        Map json = (Map) contentController.updateContent(100, "new content");
        assertThat((String) json.get("status"), is("0"));
    }

}
