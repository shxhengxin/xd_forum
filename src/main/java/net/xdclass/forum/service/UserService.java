package net.xdclass.forum.service;

import net.xdclass.forum.domain.User;

public interface UserService {
    User login(String phone,String pwd);
    int register(User user);
}
