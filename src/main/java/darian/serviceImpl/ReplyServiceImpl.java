package darian.serviceImpl;

import darian.dao.CommentDao;
import darian.entity.Comment;
import darian.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private CommentDao commentDao;

	@Override
	public boolean subComment(Comment comment) {
		return commentDao.insert(comment) > 0;
	}

	@Override
	public List<Comment> showComment(int topicId) {
		return commentDao.selectAll();
	}
}