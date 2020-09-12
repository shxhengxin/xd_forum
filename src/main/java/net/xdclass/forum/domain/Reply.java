package net.xdclass.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName : Reply  //类名
 * @Description : 话题回复  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-12 21:55  //时间
 */
@Data
public class Reply {

    private int id;
    private int topicId;
    private int floor;
    private String content;
    private int userId;
    private String username;
    private String userImg;
    private Date createTime;
    private Date updateTime;
    private int delete;

}
