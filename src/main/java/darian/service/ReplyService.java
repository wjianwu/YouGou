package darian.service;

import darian.entity.Comment;
import darian.entity.Define;

import java.util.List;

public interface ReplyService {

	//评论
	boolean subComment(Comment comment);

	//显示当前帖子的所有评论
	List showComment(int topicId);

	//回帖周榜
	List<Define> huiTie();
}
