package controller;

import dao.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tool.AjaxReturn;

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


    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    public Object addContent(@RequestParam("content") String context) throws UnsupportedEncodingException {

        Boolean ret = contentDao.addContent(context);

        if( !ret )  return AjaxReturn.fail("添加失败");

        return AjaxReturn.success("添加成功");
    }

    @RequestMapping(value="remove", method = RequestMethod.POST)
    @ResponseBody
    public Object removeContent(@RequestParam("content_id") Integer content_id) {

        Boolean ret = contentDao.removeContent(content_id);

        if( !ret )  return AjaxReturn.fail("删除失败");

        return AjaxReturn.success("删除成功");
    }

    @RequestMapping(value="update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateContent(@RequestParam("contentId") Integer contentId, @RequestParam("context") String context) {

        Boolean ret = contentDao.updateContent(contentId, context);

        if( !ret )  return AjaxReturn.fail("更新失败");

        return AjaxReturn.success("更新成功");
    }

}
