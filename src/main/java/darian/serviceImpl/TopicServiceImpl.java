package darian.serviceImpl;

import darian.dao.TopicDao;
import darian.entity.Topic;
import darian.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicDao topicDao;

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


}
