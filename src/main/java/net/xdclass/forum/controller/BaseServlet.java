package net.xdclass.forum.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName : BaseServlet  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 14:28  //时间
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取请求方法
        String method = req.getParameter("method");
        if(method != null) {
            try{
                //获得当前被访问对象的字节码对象，和字节对象里面指定的方法
                Method targetMethod = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);

                targetMethod.invoke(this,req,resp);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
