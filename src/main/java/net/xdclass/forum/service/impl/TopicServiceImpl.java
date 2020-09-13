package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.TopicDao;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.TopicService;

import java.util.List;

/**
 * @ClassName : TopicServiceImpl  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 16:07  //时间
 */
public class TopicServiceImpl implements TopicService {
    private  TopicDao topicDao = new TopicDao();
    @Override
    public PageDTO<Topic> listTopicPageByCid(int cId, int page, int pageSize) {
        //查询总记录数
        int totalRecordNum = topicDao.countTotalTopicByCid(cId);
        int from = (page-1) * pageSize;
        //分页查询
        List<Topic> topicList = topicDao.findListByCid(cId,from,pageSize);
        PageDTO<Topic> pageDTO = new PageDTO<>(page,pageSize,totalRecordNum);
        pageDTO.setList(topicList);
        return  pageDTO;
    }

    @Override
    public Topic findById(int topicId) {
        Topic topicDaoById = topicDao.findById(topicId);
        return  topicDaoById;
    }
}
