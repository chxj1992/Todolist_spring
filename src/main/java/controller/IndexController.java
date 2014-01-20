package controller;

import dao.ContentDao;
import dao.UserDao;
import model.Content;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * add_your_description_here
 * Author: chen
 * DateTime: 1/7/14 10:34 AM
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ContentDao contentDao;
    @Autowired
    private UserDao userDao;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage(ModelMap model, HttpServletRequest request) {

        Integer userId = (Integer) request.getSession().getAttribute("userId");
        User user = userDao.getByUserId(userId);
        List<Content> contents = contentDao.getListByUserId(user.getUserId());

        model.addAttribute("user", user);
        model.addAttribute("contents", contents);
        return "index";
	}

}
