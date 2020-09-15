package net.xdclass.forum.service;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.dto.PageDTO;

public interface ReplyService {
    PageDTO<Reply> findReplyPageTopicId(int cId,int page,int pageSize);

    int replyByTopicId(User loginUser, int topicId, String content);
}
