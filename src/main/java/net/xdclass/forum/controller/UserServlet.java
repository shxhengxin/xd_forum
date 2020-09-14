package net.xdclass.forum.controller;

import net.xdclass.forum.domain.User;
import net.xdclass.forum.service.UserService;
import net.xdclass.forum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "userServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void register(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        final Map<String, String[]> map = request.getParameterMap();

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        final int register = userService.register(user);
        if(register > 0) {
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        final String phone = request.getParameter("phone");
        final String pwd = request.getParameter("pwd");
        final User user = userService.login(phone, pwd);
        if(user != null) {
            request.setAttribute("loginUsder",user);
            //跳转页面 todo
        }
        System.out.println(user.toString());
        request.setAttribute("msg","用户名或密码错误");
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().invalidate();
        //页面跳转 todo
    }




}
