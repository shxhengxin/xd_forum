package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.UserDao;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.service.UserService;
import net.xdclass.forum.util.MD5Utile;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();
    @Override
    public User login(String phone, String pwd) {
        final User user = userDao.findByPhoneAndPwd(phone, MD5Utile.getInstance().getMD5(pwd));
        return user;
    }

    @Override
    public int register(User user) {
        user.setImg(getRandomImg());
        user.setCreateTime(new Date());
        user.setRole(1);
        user.setPwd(MD5Utile.getInstance().getMD5(user.getPwd()));
        try {
            return  userDao.register(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
