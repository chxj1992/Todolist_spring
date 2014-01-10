package controller;

import dao.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tool.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


/**
 * Content 操作
 * Author: chen
 * DateTime: 1/8/14 2:32 PM
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentDao contentDao;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public Object addContent() throws UnsupportedEncodingException {

        String context = request.getParameter("context");
        Boolean ret = contentDao.addContent(context);

        if( !ret )  return Json.fail("添加失败");

        return Json.success("添加成功");
    }

    @RequestMapping(value="remove",method = RequestMethod.POST)
    @ResponseBody
    public Object removeContent(@RequestParam("content_id") Integer content_id) {

        Boolean ret = contentDao.removeContent(content_id);

        if( !ret )  return Json.fail("删除失败");

        return Json.success("删除成功");
    }

    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateContent(@RequestParam("content_id") Integer content_id,@RequestParam() String context) {

        Boolean ret = contentDao.updateContent(content_id, context);

        if( !ret )  return Json.fail("更新失败");

        return Json.success("更新成功");
    }

}
