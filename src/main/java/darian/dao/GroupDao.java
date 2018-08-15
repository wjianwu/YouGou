package darian.dao;

import darian.entity.Group;

import java.util.List;

public interface GroupDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    Group selectByPrimaryKey(Integer id);

    List<Group> selectAll();

    int updateByPrimaryKey(Group record);
}