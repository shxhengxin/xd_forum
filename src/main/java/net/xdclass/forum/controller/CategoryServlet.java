package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Category;
import net.xdclass.forum.service.CategoryService;
import net.xdclass.forum.service.impl.CategoryServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName : CategoryServlet  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 14:31  //时间
 */
@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    /**
     * @author shenhengxin
     * @description 返回全部分类
     * @Date 14:34 2020/9/13
     * @Param [request, response]
     * @return void
     */
    public void list(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list = categoryService.list();
        System.out.println(list.toString());
    }

    public void findById(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Category category = categoryService.findById(id);
        System.out.println(category);
    }
}
