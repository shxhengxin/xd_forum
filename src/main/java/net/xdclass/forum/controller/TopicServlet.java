package net.xdclass.forum.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.CategoryService;
import net.xdclass.forum.service.ReplyService;
import net.xdclass.forum.service.TopicService;
import net.xdclass.forum.service.impl.CategoryServiceImpl;
import net.xdclass.forum.service.impl.ReplyServiceImpl;
import net.xdclass.forum.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : TopicServlet  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 15:57  //时间
 */
@WebServlet(name = "TopicServlet",urlPatterns = {"/topic"})
public class TopicServlet extends BaseServlet{
    private TopicService topicService = new TopicServiceImpl();
    private ReplyService replyService = new ReplyServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private  static  final  int pageSize = 2;

    public void  list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("c_id"));
        //默认第一页
        int page = 1;
        String currentPage = request.getParameter("page");
        if(currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }
        PageDTO<Topic> topicPageDTO = topicService.listTopicPageByCid(cId, page, pageSize);
        request.setAttribute("topicPage",topicPageDTO);
        request.setAttribute("categoryList",categoryService.list());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    public void findDetailById(HttpServletRequest request, HttpServletResponse response) {
        int topicId = Integer.parseInt(request.getParameter("topic_id"));
        //默认第一页
        int page = 1;
        String currentPage = request.getParameter("page");
        if(currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }
        //处理浏览量，如果同个session内只算一次
        String sessionReadKey = "is_read_" + topicId;
        Boolean isRead = (Boolean) request.getSession().getAttribute(sessionReadKey);
        if(isRead == null) {
            request.getSession().setAttribute(sessionReadKey,true);
            topicService.addOnePV(topicId);
        }

        Topic topic = topicService.findById(topicId);
        System.out.println("topic"+topic.toString());
        PageDTO<Reply> pageDTO = replyService.findReplyPageTopicId(topicId,page,pageSize);
        System.out.println(pageDTO.toString());
        request.setAttribute("topic",topic);
        request.setAttribute("replyPage",pageDTO);

    }

    public void addTopic(HttpServletRequest request,HttpServletResponse response) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser == null ) {
            request.setAttribute("msg","请登录");
            return;
            //页面跳转 todo
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int cId = Integer.parseInt(request.getParameter("c_id"));
        int rows = topicService.addTopic(loginUser,title,content,cId);
        if(rows == 1) {
            //发布主题成功
        }else {
            //发布主题失败
        }
    }

    public void replyByTopicId(HttpServletRequest request,HttpServletResponse response) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser == null ) {
            request.setAttribute("msg","请登录");
            return;
            //页面跳转 todo
        }
        int topicId = Integer.parseInt(request.getParameter("topic_id"));
        String content = request.getParameter("content");
        int rows = replyService.replyByTopicId(loginUser,topicId,content);
        if(rows == 0) {
            //发布回复成功
        }else {
            //发布回复失败
        }
    }
}
