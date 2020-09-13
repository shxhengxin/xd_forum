package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.CategoryDao;
import net.xdclass.forum.domain.Category;
import net.xdclass.forum.service.CategoryService;

import java.util.List;

/**
 * @ClassName : CategoryServletImpl  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 14:43  //时间
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> list() {
        return  categoryDao.list();
    }
}
