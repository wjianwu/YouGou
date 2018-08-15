package darian.dao;

import darian.entity.TopicStateType;

import java.util.List;

public interface TopicStateTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicStateType record);

    TopicStateType selectByPrimaryKey(Integer id);

    List<TopicStateType> selectAll();

    int updateByPrimaryKey(TopicStateType record);
}