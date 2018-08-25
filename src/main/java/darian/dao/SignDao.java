package darian.dao;

import darian.entity.Sign;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    Sign selectByPrimaryKey(Integer id);

    List<Sign> selectAll();

    int updateByPrimaryKey(Sign record);

	Sign selectByUserId(@Param("userId") int userId);
}