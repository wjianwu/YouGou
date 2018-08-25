package darian.serviceImpl;

import darian.dao.CollectDao;
import darian.dao.TopicDao;
import darian.entity.Collect;
import darian.entity.Topic;
import darian.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicDao topicDao;
	@Resource
	private CollectDao collectDao;

	@Override
	public boolean issueTopic(Topic topic) {
		return topicDao.insert(topic) > 0;
	}

	@Override
	public List getAllTopics(int userId) {
		return topicDao.selectAllById(userId);
	}

	@Override
	public List getAll(int ec) {
		if(ec == 0){
			return topicDao.selectAll();
		}else {
			return topicDao.selectAllByEc();
		}
	}

	@Override
	public List getAllByClass(int classId) {
		return topicDao.selectAllByClassId(classId);
	}

	@Override
	public List getByEnable(int enable) {
		return topicDao.selectByEnable(enable == 1);
	}

	@Override
	public Topic getDetail(int topicId) {
		return topicDao.selectByPrimaryKey(topicId);
	}

	@Override
	public boolean replyCount(int topicId) {
		int rep = topicDao.selectByTopicId(topicId);
		return topicDao.replyCount(topicId,rep+1) > 0;
	}

	@Override
	public Topic getById(int topicId) {
		return topicDao.selectByPrimaryKey(topicId);
	}

	@Override
	public boolean insertCollect(Collect collect) {
		return collectDao.insert(collect) > 0;
	}

	@Override
	public boolean selectByUserTopic(int userId, int topicId) {
		return collectDao.selectByUserTopic(userId,topicId)==null;
	}

	@Override
	public boolean deleteByUserTopic(int userId, int topicId) {
		return collectDao.deleteByUserTopic(userId,topicId) == 1;
	}

	@Override
	public List<Collect> selectAllByUser(int userId) {
		return collectDao.selectAllByUser(userId);
	}
}
