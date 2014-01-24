package service;

import dao.UserDao;
import exception.UserInvalidException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;


/**
 * Author: chen
 * DateTime: 1/8/14 9:20 AM
 */
public class UserService {

    @Autowired
    private UserDao userDao;


    public Integer isValidUser(String username, String password) throws UserInvalidException {

        if ( username == "" || password == "" )
            throw(new UserInvalidException("Empty String is Invalid"));

        User user = userDao.getByUserName(username);
        if ( user == null || user.getUserId() == null )
            throw(new UserInvalidException("Invalid User"));

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if ( !user.getPassword().equals(md5Password) )
            throw(new UserInvalidException("Wrong Password"));

        return user.getUserId();
    }


}
