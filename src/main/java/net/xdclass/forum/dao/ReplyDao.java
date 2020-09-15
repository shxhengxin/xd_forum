package net.xdclass.forum.dao;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName : ReplyDao  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-13 17:16  //时间
 */
public class ReplyDao extends BaseDao{
    public int countTotalReplyBytopicId(int topicId) {
        String sql = "select count(id) from reply where topic_id=? ";
        Long count = null;
        try {
            count = (Long) queryRunner.query(sql,new ScalarHandler<>(),topicId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  count.intValue();
    }

    public List<Reply> findReplyListBytopicId(int topicId, int from, int pageSize) {
        String sql = "select * from reply where topic_id=?  order by create_time asc limit ?,?";
        List<Reply> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<>(Reply.class,processor),topicId,from,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  list;
    }

    /**
     * @author shenhengxin
     * @description 查找最新楼层
     * @Date 21:19 2020/9/15
     * @Param [topicId]
     * @return int
     */
    public int findLatestFloorByTopicId(int topicId) {
        Integer floor = null;
        int defaultFloor = 0;
        String sql = "select floor from reply where topic_id=? order by floor desc limit 1";
        try {
            floor = (Integer) queryRunner.query(sql,new ScalarHandler<>(),topicId);
            if(floor == null){
                return  defaultFloor;
            }else {
                return  floor.intValue();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return  -1;
    }

    /***
     * @author shenhengxin
     * @description 保存回复内容
     * @Date 21:19 2020/9/15
     * @Param [reply]
     * @return int
     */
    public int save(Reply reply) throws Exception {
        String sql = "insert into reply (topic_id,floor,content,user_id,username,user_img,create_time,update_time,`delete`)" +
                "values (?,?,?,?,?,?,?,?,?)";

        Object [] params = {
                reply.getTopicId(),reply.getFloor(),reply.getContent(),reply.getUserId(),reply.getUsername(),reply.getUserImg(),
                reply.getCreateTime(),reply.getUpdateTime(),reply.getDelete()
        };
        int rows = 0;
        try {
            rows = queryRunner.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new Exception();
        }
        return rows;
    }
}
