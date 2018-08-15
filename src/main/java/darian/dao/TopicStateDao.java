package darian.dao;

import darian.entity.TopicState;

import java.util.List;

public interface TopicStateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicState record);

    TopicState selectByPrimaryKey(Integer id);

    List<TopicState> selectAll();

    int updateByPrimaryKey(TopicState record);
}