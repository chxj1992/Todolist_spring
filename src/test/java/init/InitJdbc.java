package init;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sun.tools.jar.resources.jar;

import java.io.IOException;
import java.util.Scanner;

/**
 * add_your_description_here
 * Author: chen
 * DateTime: 1/10/14 12:51 PM
 */
public class InitJdbc {


    public static JdbcTemplate init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/todo_list_test?characterEncoding=UTF-8&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("87822971");

        return  new JdbcTemplate(dataSource);
    }


    public static void initMockData() {

        ClassPathResource resource = new ClassPathResource("MockData.txt",InitJdbc.class);

        String sql = "";
        try {
            Scanner scanner = new Scanner(resource.getFile());
            while(scanner.hasNextLine()) {
                sql += scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        InitJdbc.init().execute(sql);
    }


}
