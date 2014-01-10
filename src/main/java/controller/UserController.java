package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import tool.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * add_your_description_here
 * Author: chen
 * DateTime: 1/7/14 11:43 AM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpServletRequest request;


    @RequestMapping("login")
    public String login(HttpServletResponse response) throws IOException {

        // 已登录则不可访问该页面
        if( request.getSession().getAttribute("userId") != null ){
            response.sendRedirect("/");
            return null;
        }

        return "login";
    }


    @RequestMapping(value="doLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object doLogin(@RequestParam("user_name") String userName, @RequestParam("password") String password ) {

        Integer userId = userService.checkPassword(userName,password);

        if( userId == 0 )  return Json.fail("用户名或密码错误");

        request.getSession().setAttribute("userId", userId );
        return Json.success("登录成功");
    }


}
