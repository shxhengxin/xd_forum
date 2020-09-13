package net.xdclass.forum.dao;

import net.xdclass.forum.domain.Category;
import net.xdclass.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName : CategoryDao  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 14:44  //时间
 */
public class CategoryDao extends BaseDao{

    /***
     * @author shenhengxin
     * @description 根据id找分类
     * @Date 14:52 2020/9/13
     * @Param [id]
     * @return net.xdclass.forum.domain.Category
     */
    public Category findById(int id){
        String sql = "select * from category where id=?";
        Category category = null;
        try {
            category = queryRunner.query(sql, new BeanHandler<>(Category.class, processor), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  category;
    }

    /***
     * @author shenhengxin
     * @description 获取所有分类
     * @Date 14:56 2020/9/13
     * @Param []
     * @return java.util.List<net.xdclass.forum.domain.Category>
     */
    public List<Category> list() {
        String sql = "select * from category order by weight desc";
        List<Category> categoryList = null;
        try {
            categoryList = queryRunner.query(sql,new BeanListHandler<>(Category.class,processor));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  categoryList;

    }

}
