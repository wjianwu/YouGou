package darian.dao;

import darian.entity.UserGroup;

import java.util.List;

public interface UserGroupDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroup record);

    UserGroup selectByPrimaryKey(Integer id);

    List<UserGroup> selectAll();

    int updateByPrimaryKey(UserGroup record);
}