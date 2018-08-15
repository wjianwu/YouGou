package darian.dao;

import darian.entity.SmallBlock;

import java.util.List;

public interface SmallBlockDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SmallBlock record);

    SmallBlock selectByPrimaryKey(Integer id);

    List<SmallBlock> selectAll();

    int updateByPrimaryKey(SmallBlock record);
}