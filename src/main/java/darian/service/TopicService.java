package darian.service;

import darian.entity.Collect;
import darian.entity.Topic;

import java.util.List;

public interface TopicService {

	//发布新帖
	boolean issueTopic(Topic topic);

	//查询当前用户所有帖子
	List getAllTopics(int userId);

	//查询所有帖子（不带分类，但只查前十条，按时间）
	List getAll(int ec);

	//按分类查询所有
	List getAllByClass(int classId);

	//结贴未结帖
	List getByEnable(int enable);

	Topic getDetail(int topicId);

	//更新回复数量
	boolean replyCount(int topicId);

	//主键查topic
	Topic getById(int topicId);

	//收藏帖子
	boolean insertCollect(Collect collect);

}
