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
	public List getAll() {
		return topicDao.selectAll();
	}
}
