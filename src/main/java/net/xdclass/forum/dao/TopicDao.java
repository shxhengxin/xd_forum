package net.xdclass.forum.dao;

import net.xdclass.forum.domain.Topic;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName : TopicDao  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 16:12  //时间
 */
public class TopicDao extends BaseDao{

    /***
     * @author shenhengxin
     * @description 根据cid查询总行数
     * @Date 16:32 2020/9/13
     * @Param [cId]
     * @return int
     */
    public int countTotalTopicByCid(int cId) {
        String sql = "select count(id) from topic where c_id=? AND `delete`=0";
        Long count = null;
        try {
            count = (Long) queryRunner.query(sql, new ScalarHandler<>(), cId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  count.intValue();
    }

    /***
     * @author shenhengxin
     * @description 分页查询
     * @Date 16:33 2020/9/13
     * @Param [cId, from, pageSize]
     * @return java.util.List<net.xdclass.forum.domain.Topic>
     */
    public List<Topic> findListByCid(int cId, int from, int pageSize) {
        String sql = "select * from topic where c_id=? AND `delete`=0  order by update_time desc limit ?,?";
        List<Topic> topicList = null;
        try {
            topicList = queryRunner.query(sql,new BeanListHandler<>(Topic.class,processor),cId,from,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  topicList;
    }

    public Topic findById(int topicId) {
        String sql = "select * from topic where id=? and `delete`=0";
        Topic topicByIdInfo = null;
        try {
            topicByIdInfo = queryRunner.query(sql,new BeanHandler<>(Topic.class,processor),topicId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  topicByIdInfo;
    }

    public int save(Topic topic) throws Exception {
        String sql = "insert into topic (c_id,title,content,pv,user_id,username,user_img,create_time,update_time,hot,`delete`) values (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
          topic.getcId(),topic.getTitle(),topic.getContent(),topic.getPv(),topic.getUserId(),
          topic.getUsername(),topic.getUserImg(),topic.getCreateTime(),topic.getUpdateTime(),
          topic.getHot(),topic.getDelete()
        };

        int rows = 0;
        try {
            rows = queryRunner.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw  new Exception();
        }
        return  rows;

    }
    /***
     * @author shenhengxin
     * @description
     * @Date 19:40 2020/9/16
     * @Param [topicId, newPV, pv]
     * @return int
     */
    public  int updatePV(int topicId, int newPV, int oldPV) {
        String sql = "update topic set pv=? where pv=? and id=?";
        int rows = 0;
        try {
            rows = queryRunner.update(sql,newPV,oldPV);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  rows;
    }

}
