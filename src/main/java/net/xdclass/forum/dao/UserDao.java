package net.xdclass.forum.dao;

import net.xdclass.forum.domain.User;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao extends BaseDao{
    public User findByPhoneAndPwd(String phone,String md5pwd) {
        String sql = "select * from user where phone=? and pwd=?";
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class,processor),phone,md5pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }

    public int register(User user) throws Exception {
        String sql = "INSERT INTO user (phone,pwd,sex,img,create_time,role,username) values (?,?,?,?,?,?,?)";
        int i = 0;
        Object [] params = {
                user.getPhone(),user.getPwd(),user.getSex(),user.getImg(),user.getCreateTime(),user.getRole(),user.getUsername()
        };
        try {
            i = queryRunner.execute(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return i;
    }
}
