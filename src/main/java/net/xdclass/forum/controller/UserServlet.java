package net.xdclass.forum.controller;

import net.xdclass.forum.domain.User;
import net.xdclass.forum.service.CategoryService;
import net.xdclass.forum.service.UserService;
import net.xdclass.forum.service.impl.CategoryServiceImpl;
import net.xdclass.forum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "userServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }else {
            System.out.println("注册失败");
            request.getRequestDispatcher("/user/register.jsp").forward(request,response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String phone = request.getParameter("phone");
        final String pwd = request.getParameter("pwd");
        final User user = userService.login(phone, pwd);
        if(user != null) {
            request.getSession().setAttribute("loginUser",user);
            //跳转页面 // TODO: 2020/9/19
            response.sendRedirect("/topic?method=list&c_id=1");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }


    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        //页面跳转 // TODO: 2020/9/19
        response.sendRedirect("topic?method=list&c_id=1");
    }




}
