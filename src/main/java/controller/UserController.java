package controller;

import exception.UserInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import utils.AjaxReturn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Author: chen
 * DateTime: 1/7/14 11:43 AM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 已登录则不可访问该页面
        if( request.getSession().getAttribute("userId") != null ){
            response.sendRedirect("/");
            return null;
        }

        return "login";
    }

    @RequestMapping(value="doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map doLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {

        Integer userId;
        try {
            userId = userService.isValidUser(userName, password);
        } catch (UserInvalidException e) {
            return AjaxReturn.fail("用户名或密码错误");
        }

        request.getSession().setAttribute("userId", userId );
        return AjaxReturn.success("登录成功");
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    @ResponseBody
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().setAttribute("userId", null );
        response.sendRedirect("/");
    }


}
