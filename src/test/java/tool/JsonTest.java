package tool;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * add_your_description_here
 * Author: chen
 * DateTime: 1/9/14 11:05 PM
 */
public class JsonTest {


    @Test
    public void success_status_should_be_1() throws Exception {
        String status = Json.success().get("status").toString();
        assertThat(status,is("1"));
    }

    @Test
    public void fail_status_should_be_0() throws Exception {
        String status = Json.fail().get("status").toString();
        assertThat(status,is("0"));    }
}
