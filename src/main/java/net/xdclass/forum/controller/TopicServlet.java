package net.xdclass.forum.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.ReplyService;
import net.xdclass.forum.service.TopicService;
import net.xdclass.forum.service.impl.ReplyServiceImpl;
import net.xdclass.forum.service.impl.TopicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private  static  final  int pageSize = 2;

    public void  list(HttpServletRequest request, HttpServletResponse response){
        int cId = Integer.parseInt(request.getParameter("c_id"));
        //默认第一页
        int page = 1;
        String currentPage = request.getParameter("page");
        if(currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }
        PageDTO<Topic> topicPageDTO = topicService.listTopicPageByCid(cId, page, pageSize);
        request.setAttribute("topicPage",topicPageDTO);
        System.out.println(topicPageDTO.toString());
    }
    public void findDetailById(HttpServletRequest request, HttpServletResponse response) {
        int topicId = Integer.parseInt(request.getParameter("topic_id"));
        //默认第一页
        int page = 1;
        String currentPage = request.getParameter("page");
        if(currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }
        Topic topic = topicService.findById(topicId);
        System.out.println("topic"+topic.toString());
        PageDTO<Reply> pageDTO = replyService.findReplyPageTopicId(topicId,page,pageSize);
        System.out.println(pageDTO.toString());
        request.setAttribute("topic",topic);
        request.setAttribute("replyPage",pageDTO);

    }
}
