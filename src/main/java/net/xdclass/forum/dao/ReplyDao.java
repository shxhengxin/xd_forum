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
}
