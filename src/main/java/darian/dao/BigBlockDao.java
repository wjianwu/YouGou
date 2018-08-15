package darian.dao;

import darian.entity.BigBlock;

import java.util.List;

public interface BigBlockDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BigBlock record);

    BigBlock selectByPrimaryKey(Integer id);

    List<BigBlock> selectAll();

    int updateByPrimaryKey(BigBlock record);
}