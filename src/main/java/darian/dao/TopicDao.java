package darian.dao;


import darian.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Integer id);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);

    List selectAllById(@Param("userId") int userId);

    //更新头像的同时更新帖子表里面对应的头像
    int updateTopicImg(@Param("userId")int userId,@Param("filename")String filename);

    //按分类查询所有
	List<Topic> selectAllByClassId(@Param("classId")int classId);

	//结贴未结贴
	List<Topic> selectByEnable(@Param("enable")boolean enable);

	List<Topic> selectAllByEc();

	//topic回复数量
	int selectByTopicId(@Param("topicId") int topicId);
	int replyCount(@Param("topicId") int topicId,@Param("count") int count);
}