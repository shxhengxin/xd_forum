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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", pwd='" + pwd + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", role=" + role +
                ", username='" + username + '\'' +
                '}';
    }
}
