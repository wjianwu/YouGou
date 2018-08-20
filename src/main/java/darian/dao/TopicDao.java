package darian.dao;


import darian.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Integer id);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);

    List selectAllById(@Param("userId") int userId);

    //更新头像的同时更新帖子表里面对应的头像
    int updateTopicImg(@Param("userId")int userId,@Param("filename")String filename);
}