package darian.dao;

import darian.entity.Topic;

import java.util.List;

public interface TopicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Integer id);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);
}