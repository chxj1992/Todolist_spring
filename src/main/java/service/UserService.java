package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: chen
 * DateTime: 1/8/14 9:20 AM
 */
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;


    public Integer checkPassword (String username, String password) {

        User user = userDao.getByUserName(username);

        if ( user == null  )  return 0;

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        if ( !user.getPassword().equals(md5Password) ) return 0;

        return user.getUserId();
    }

    public User loginUserInfo() {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        return userDao.getByUserId(userId);
    }

}
