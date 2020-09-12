package net.xdclass.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName : Category  //类名
 * @Description : 分类  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-12 21:49  //时间
 */
@Data
public class Category {
    private int id;
    private String name;
    private int weight;
    private Date createTime;
}
