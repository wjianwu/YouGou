package darian.dao;

import darian.entity.Reply;
import java.util.List;

public interface ReplyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    Reply selectByPrimaryKey(Integer id);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply record);
}