package darian.dao;

import darian.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectAll();

    int updateByPrimaryKey(Collect record);

    //查询帖子是否已被收藏
	Collect selectByUserTopic(@Param("userId")int userId,@Param("topicId")int topicId);

	//取消收藏，删除相关信息
	int deleteByUserTopic(@Param("userId")int userId,@Param("topicId")int topicId);

	//查询当前用户已收藏的
	List<Collect> selectAllByUser(@Param("userId")int userId);
}