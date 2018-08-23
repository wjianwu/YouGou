package darian.service;

import darian.entity.Comment;

import java.util.List;

public interface ReplyService {

	//评论
	boolean subComment(Comment comment);

	//显示当前帖子的所有评论
	List<Comment> showComment(int topicId);
}
