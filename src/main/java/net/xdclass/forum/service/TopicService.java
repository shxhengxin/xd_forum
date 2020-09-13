package net.xdclass.forum.service;

import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;

public interface TopicService {
    PageDTO<Topic> listTopicPageByCid(int cId,int page,int pageSize);
    Topic findById(int topicId);
}
