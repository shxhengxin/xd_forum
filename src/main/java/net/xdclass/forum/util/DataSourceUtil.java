package net.xdclass.forum.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName : DataSourceUtil  //类名
 * @Description : 数据库连接池  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-12 22:02  //时间
 */
public class DataSourceUtil {
    private static DataSource dataSource;
    static {
        try{
            InputStream resourceAsStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBPC失败");
        }
    }

    /***
     * @author shenhengxin
     * @description 获取连接池
     * @Date 22:10 2020/9/12
     * @Param []
     * @return javax.sql.DataSource
     */
    public static DataSource getDataSource() {
        return  dataSource;
    }
}
