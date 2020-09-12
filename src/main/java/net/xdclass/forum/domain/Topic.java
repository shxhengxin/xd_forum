package net.xdclass.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName : Topic  //类名
 * @Description : 话题  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-12 21:51  //时间
 */
@Data
public class Topic {
    private int id;
    private int cId;
    private String title;
    private String content;
    private int pv;
    private int userId;
    private String username;
    private String userImg;
    private Date createTime;
    private Date updateTime;
    private int hot;
    private int delete;



}
