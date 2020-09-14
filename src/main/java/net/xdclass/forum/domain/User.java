package net.xdclass.forum.domain;

import lombok.Data;

import java.util.Date;


/***
 * @author shenhengxin
 * @description 开发者论坛
 * @Date 21:47 2020/9/12
 * @Param
 * @return
 */
@Data
public class User {
    private int id;
    private String phone;
    private int sex;
    private String pwd;
    private String img;
    private Date createTime;
    private int role;
    private String username;

}
