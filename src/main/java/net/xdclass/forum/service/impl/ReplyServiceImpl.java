package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.ReplyDao;
import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.ReplyService;

import java.util.List;

/**
 * @ClassName : ReplyServiceImpl  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 17:15  //时间
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao = new ReplyDao();
    @Override
    public PageDTO<Reply> findReplyPageTopicId(int topicId, int page, int pageSize) {
        //查询总记录数
        int totalRecordNum = replyDao.countTotalReplyBytopicId(topicId);
        int from = (page-1) * pageSize;
        //分页查询
        List<Reply> replyList = replyDao.findReplyListBytopicId(topicId,from,pageSize);
        PageDTO<Reply> pageDTO = new PageDTO<>(page,pageSize,totalRecordNum);
        pageDTO.setList(replyList);
        return  pageDTO;
    }
}
