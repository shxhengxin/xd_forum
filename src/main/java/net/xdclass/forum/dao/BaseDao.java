package net.xdclass.forum.dao;

import net.xdclass.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;

/**
 * @ClassName : BaseDao  //类名
 * @Description : 基础dao  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 14:47  //时间
 */
public class BaseDao {
    protected QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    protected BeanProcessor beanProcessor = new GenerousBeanProcessor();
    protected RowProcessor processor = new BasicRowProcessor(beanProcessor);

}
