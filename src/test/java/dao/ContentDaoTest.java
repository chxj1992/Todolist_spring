package dao;

import init.InitJdbc;
import mapper.ContentRowMapper;
import model.Content;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Content 测试
 * Author: chen
 * DateTime: 1/10/14 11:15 AM
 */
public class ContentDaoTest {

    //@Spy
    //@Autowired //为何无法从成功注入?
    //private JdbcTemplate jdbc;

    @Spy
    private JdbcTemplate jdbc = InitJdbc.init();
    @Spy
    private ContentRowMapper contentRowMapper;
    @Mock
    MockHttpServletRequest request;
    @Mock
    MockHttpSession session;


    @InjectMocks
    private ContentDao contentDao;

    @Before
    public void setUp() throws Exception {

        InitJdbc.initMockData();

        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(
            session);
        when(session.getAttribute("userId")).thenReturn(
            new Integer(1));
    }



    @Test
    public void user1_contents_number_should_be_3() throws Exception {
        List<Content> contents = contentDao.getListByUserId(1);
        assertThat(contents.size(),is(3));
    }

    @Test
    public void add_user1_content_success() throws Exception {
        Boolean ret = contentDao.addContent("context_new");
        assertThat(ret,is(true));
    }

    @Test
    public void user1_content_number_after_add_should_be_4() throws Exception {
        Boolean ret = contentDao.addContent("context_new");
        List<Content> contents = contentDao.getListByUserId(1);
        assertThat(contents.size(),is(4));
    }

    @Test
    public void remove_user1_content_success() throws Exception {
        Boolean ret = contentDao.removeContent(1);
        assertThat(ret,is(true));
    }

    @Test
    public void user1_content_number_after_remove_should_be_2() throws Exception {
        Boolean ret = contentDao.removeContent(1);
        List<Content> contents = contentDao.getListByUserId(1);
        assertThat(contents.size(),is(2));
    }

    @Test
    public void update_content_success() throws Exception {
        contentDao.updateContent(1,"update content");
        List<Content> contents = contentDao.getListByUserId(1);
        assertThat(contents.get(0).getContext(),is("update content"));
    }

    @Test
    public void update_not_exist_content() throws Exception {
        Boolean ret = contentDao.updateContent(100,"update content");
        assertThat(ret,is(false));
    }

}
